package edu.soft2.test;

import edu.soft2.dao.UsersDao;
import edu.soft2.pojo.Users;

/**
 * 测试UsersDao中的方法
 */
public class TestUsersDao {
    public static void main(String[] args) {
       Users user= new UsersDao().findUser("peter","123");
        System.out.println(user);
    }
}
