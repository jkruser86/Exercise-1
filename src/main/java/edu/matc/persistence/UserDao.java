package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author Jamie Kruser
 */
public class UserDao {

    private final Logger logger = Logger.getLogger(this.getClass());


    /**
     * This method gets all users from the database
     * @return all users on the table
     */
    public List<User> getAllUsers() {

        String sql = "SELECT * FROM users";
        return databaseQuery(sql);
    }

    /**
     * This method uses the input last name to search the database and returns the found user
     * @param lastName The last name to search for
     * @return the user that was found using the last name
     */
    public List<User> lastNameSearch(String lastName) {

        String sql = "SELECT * FROM users WHERE last_name = '" + lastName + "'";
        return databaseQuery(sql);
    }

    /**
     * This method creates a User from the input ResultSet
     * @param results The ResultSet passed in
     * @return The User that was created from the results
     * @throws SQLException
     */
    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setDateOfBirth(results.getDate("date_of_birth"));
        return user;
    }

    /**
     * This method connects to a database and searches using the input SQL
     * @param sql The input SQL to use to search the table
     * @return A list of User found on the table
     */
    private List<User> databaseQuery(String sql) {

        logger.info("The sql statement was: " + sql);
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                addToUserList(results, users);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }
        return users;
    }

    /**
     * This method will add the user to the user List
     * @param results The input ResultSet
     * @param users The list of User
     * @throws SQLException
     */
    private void addToUserList(ResultSet results, List<User> users) throws SQLException {
        User employee = createUserFromResults(results);
        users.add(employee);
    }

}