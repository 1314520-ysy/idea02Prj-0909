package com.soft2.utils;

import java.sql.*;

/**
 * 单例模式(懒汉模式)
 */
public class DaoFactory {

    private static Connection conn = null;

    private DaoFactory() {
    }

    //开启数据库
    public static synchronized Connection getConn(){
        if (conn == null) {
            try {
                PropertiesManager pro = PropertiesManager.getInstance();
                String driver = pro.getString("database-driver-class");
                String url = pro.getString("database-url");
                String username = pro.getString("database-username");
                String pwd = pro.getString("database-password");
                Class.forName(driver);
                conn =  DriverManager.getConnection(url,username,pwd);
            /*Context context = new InitialContext();//创建Context对象
                //Context对象获取"命名空间"路径，获取数据源对象
             DataSource ds =
             (DataSource) context.lookup("java:comp/env/jdbc/qqZone");
             conn = ds.getConnection();//获取数据库连接对象*/
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    //关闭数据库
    public static void closeConn(ResultSet rs, PreparedStatement ps,Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
