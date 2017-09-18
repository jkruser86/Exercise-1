package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
        // execute sample.sql so we always get fresh database rows
    }

    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = userDao.getAllUsers();

        assertEquals("Unexpected number of users returned", 6, users.size());
    }

    @Test
    public void lastNameSearchTest() throws Exception {
    }

}