package edu.soft2.util;

import java.sql.*;
/**
 * 单例模式(懒汉模式)
 */
public class DaoFactory {
    private static Connection conn = null;

    private DaoFactory() {
    }

    /** 获取数据库连接*/
    public static synchronized Connection getConn(){
        if(conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");//5.X版本的mysql
//			Class.forName("com.mysql.cj.jdbc.Driver");//8.0版本的mysql
                conn = (Connection) DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/news?"
                                + "useUnicode=true&characterEncoding=utf-8"
                                + "&useSSL=false&serverTimezone=Asia/Shanghai",
                        "root",
                        "");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
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
