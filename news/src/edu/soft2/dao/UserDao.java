package edu.soft2.dao;

import edu.soft2.pojo.User;
import edu.soft2.tools.DaoFactory;

import java.sql.*;

public class UserDao {
    /**
     * 查询用户表news_user
     * @return
     */
    public User findUser(String username,String upwd){
        User user = null;
        //1.获取数据库连接
       Connection conn = DaoFactory.getConn();
       String sql = "select * from news_user where username=? and upwd = ?;";
        System.out.println("sql="+sql);
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,upwd);
            //2.获取查询结果集
            ResultSet rs = ps.executeQuery();
            //3.解析查询结果
            while (rs.next()) {
            //查询结果不为空，则封装到User实体类对象中
                user = new User();
                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("username"));
                user.setUpwd(rs.getString("upwd"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return user;
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return 0不存在用户/1存在用户
     */
    public int findUserByName(String username){
        int falg = 0;
        String sql = "select * from news_user where username = ?";//?是占位符
        Connection conn = DaoFactory.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                falg = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return falg;
    }
    public boolean addUser(String username ,String upwd ){
        boolean flag = false;
        Connection conn = DaoFactory.getConn();
        String sql="insert into news_user(username,upwd) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,upwd);
            flag = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
