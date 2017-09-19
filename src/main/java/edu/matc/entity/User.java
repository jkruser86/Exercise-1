package edu.matc.entity;

import edu.matc.utility.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity
@Table(name = "users")

public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private String userid;

    @Column(name = "date_of_birth")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateOfBirth;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     */
    public User(String firstName, String lastName, String userid, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets dateOfBirth.
     *
     * @return the dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets dateOfBirth.
     *
     * @param dateOfBirth the dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {

        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    /**
     * Calculates user's age
     *
     * @return userAge the age of the user
     */

    public int age() {
        int userAge;

        LocalDate currentDate = LocalDate.now();

        if (dateOfBirth.getMonthValue() == currentDate.getMonthValue()) {
            if (dateOfBirth.getDayOfMonth() > currentDate.getDayOfMonth()) {
                userAge = currentDate.getYear() - dateOfBirth.getYear() - 1;
            } else {
                userAge = currentDate.getYear() - dateOfBirth.getYear() - 1;
            }
        } else if (dateOfBirth.getMonthValue() > currentDate.getMonthValue()) {
            userAge = currentDate.getYear() - dateOfBirth.getYear() - 1;
        } else {
            userAge = currentDate.getYear() - dateOfBirth.getYear();
        }

        return userAge;
    }

}