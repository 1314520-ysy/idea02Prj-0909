package edu.soft2.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelp {
    public static Connection conn = getConn();
    public static Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");//5.X版本的mysql
//			Class.forName("com.mysql.cj.jdbc.Driver");//8.0版本的mysql
            conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/caocao?"
                            + "useUnicode=true&characterEncoding=utf-8"
                            + "&useSSL=false&serverTimezone=Asia/Shanghai",
                    "root",
                    "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
