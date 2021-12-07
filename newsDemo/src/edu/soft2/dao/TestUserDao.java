package edu.soft2.dao;

import edu.soft2.impl.UserDaoImpl;

public class TestUserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findUser("peter","123"));
    }
}
