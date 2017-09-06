package edu.matc.entity;

import java.util.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private Date dateOfBirth;

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
    public User(String firstName, String lastName, String userid, Date dateOfBirth) {
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
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets dateOfBirth.
     *
     * @param dateOfBirth the dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
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
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTime(dateOfBirth);

        Calendar currentDate = Calendar.getInstance();

        if (birthDay.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)) {
            if (birthDay.get(Calendar.DATE) > currentDate.get(Calendar.DATE)) {
                userAge = currentDate.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR) - 1;
            } else {
                userAge = currentDate.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
            }
        } else if (birthDay.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH)) {
            userAge = currentDate.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR) - 1;
        } else {
            userAge = currentDate.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        }

        return userAge;
    }

}