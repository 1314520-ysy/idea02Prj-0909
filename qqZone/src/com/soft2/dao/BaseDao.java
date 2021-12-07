package com.soft2.dao;

import com.soft2.utils.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;
    protected CallableStatement callableStatement = null;//创建CallableStatement对象
    /**
     * SQL 查询将查询结果直接放入ResultSet中
     * @param sql SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 结果集
     */
    private ResultSet exeQuery(String sql, Object[] params) {
        System.out.println("exeQuery---sql="+sql);
        try {
            // 获得连接
            conn = DaoFactory.getConn();

            // 调用SQL
            ps = conn.prepareStatement(sql);

            // 参数赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            // 执行
            rs = ps.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }
    /**
     * insert update delete SQL语句的执行的统一方法
     * @param sql SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 受影响的行数
     */
    public int exeUpdate(String sql, Object[] params) {
        System.out.println("exeUpdate--sql="+sql);
        // 受影响的行数
        int affectedLine = 0;
        try {
            // 获得连接
            conn = DaoFactory.getConn();
            // 调用SQL
            ps = conn.prepareStatement(sql);
            // 参数赋值
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
 /*在此 PreparedStatement 对象中执行 SQL 语句，
该语句必须是一个 SQL 数据操作语言（Data Manipulation Language，DML）语句，比如 INSERT、UPDATE 或 DELETE语句；
或者是无返回内容的 SQL 语句，比如 DDL 语句。*/
            affectedLine = ps.executeUpdate();// 执行

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return affectedLine;
    }
    /**
     * SQL 查询将查询结果：一行第一列
     * @param sql SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 第一列对象
     */
    public Object executeQuerySingle(String sql, Object[] params) {
        System.out.println("executeQuerySingle--sql="+sql);
        Object object = null;
        try {
            rs = exeQuery(sql, params);// 调用查询执行方法
            if(rs.next()) {
                object = rs.getObject(1);//获取第一列
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return object;
    }
    /**
     * SQL 查询将查询结果：一行第一列
     * @param sql SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 第一列int值
     */
    public int executeQuerySingleInt(String sql, Object[] params) {
        System.out.println("executeQuerySingleInt---sql="+sql);
        int object = 0;
        try {
            rs = exeQuery(sql,params);// 调用查询执行方法
            if(rs.next()) {
                object = rs.getInt(1);//获取第一列
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return object;
    }
    /**
     * 获取结果集，并将结果放在List中
     * @param sql  SQL语句
     * @params  参数，没有则为null
     * @return List结果集
     */
    public List<Object> excuteQuery(String sql, Object[] params) {
        System.out.println("executeQuerySingleInt---sql="+sql);
        // 执行SQL获得结果集
        ResultSet rs = exeQuery(sql, params);
        System.out.println(sql);
        // 创建ResultSetMetaData对象
        ResultSetMetaData rsmd = null;
        // 结果集列数
        int columnCount = 0;
        try {
            rsmd = rs.getMetaData();
            // 获得结果集列数
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }
        // 创建List
        List<Object> list = new ArrayList<Object>();
        try {
            // 将ResultSet的结果保存到List中
            while (rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));
                }
                list.add(map);//每一个map代表一条记录，把所有记录存在list中
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    /**
     * 存储过程带有一个输出参数的方法
     * @param sql 存储过程语句
     * @param params 参数数组
     * @param outParamPos 输出参数位置
     * @param SqlType 输出参数类型
     * @return 输出参数的值
     */
    public Object excuteQuery(String sql, Object[] params,int outParamPos, int SqlType) {
        System.out.println("excuteQuery---sql="+sql);
        Object object = null;
        conn = DaoFactory.getConn();
        try {
            // 调用存储过程
            // prepareCall:创建一个 CallableStatement 对象来调用数据库存储过程。
            callableStatement = conn.prepareCall(sql);

            // 给参数赋值
            if(params != null) {
                for(int i = 0; i < params.length; i++) {
                    callableStatement.setObject(i + 1, params[i]);
                }
            }

            // 注册输出参数
            callableStatement.registerOutParameter(outParamPos, SqlType);

            // 执行
            callableStatement.execute();

            // 得到输出参数
            object = callableStatement.getObject(outParamPos);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return object;
    }
}
