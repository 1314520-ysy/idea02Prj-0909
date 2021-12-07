package edu.soft2.tools;

import java.sql.*;
/**
 * 单例模式(懒汉模式)
 */

/** 获取数据库连接，关闭数据库的连接*/
public class DaoFactory {
    private static Connection conn = getConn();
    /** 获取数据库连接*/
    private DaoFactory(){}
    public static Connection getConn(){
        try {
           /* Class.forName("com.mysql.jdbc.Driver");//5.X版本的mysql
//			Class.forName("com.mysql.cj.jdbc.Driver");//8.0版本的mysql
            conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/news?"
                            + "useUnicode=true&characterEncoding=utf-8"
                            + "&useSSL=false&serverTimezone=Asia/Shanghai",
                    "root",
                    "");*/
            PropertiesManager pro = PropertiesManager.getInstance();//获取单例对象
            Class.forName(pro.getString("database-driver-class"));//反射的方式获取数据库驱动的对象
            conn = DriverManager.getConnection(
                    pro.getString("database-url"),
                    pro.getString("database-username"),
                    pro.getString("database-password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /** 关闭数据库的连接*/
    public static void close(ResultSet rs, PreparedStatement ps,Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
