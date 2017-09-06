package edu.matc.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Test", "User", "6", getDate("08-01-2000"));
    }

    private Date getDate(String s) {

    }

    @Test
    public void age() throws Exception {
    }

}