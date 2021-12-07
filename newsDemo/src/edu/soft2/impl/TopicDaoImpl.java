package edu.soft2.impl;

import edu.soft2.dao.TopicDao;
import edu.soft2.pojo.Topic;
import edu.soft2.util.DaoFactory;

import java.sql.*;
import java.util.*;

public class TopicDaoImpl implements TopicDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Topic topic = null;
    @Override
    public List<Topic> findAllTopic() {
        List<Topic> list = new ArrayList<Topic>();
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from topic;");
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Topic(
                        rs.getInt("tid"),
                        rs.getString("tname")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.close(rs,ps,conn);
        }
        return list;
    }

    /**
     * 按照tname查询
     * @param tname
     * @return
     */
    @Override
    public Topic findTopicByName(String tname) {
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from topic where tname=?;");
            ps.setString(1,tname);
            rs = ps.executeQuery();
            while(rs.next()) {
                topic = new Topic(
                        rs.getInt("tid"),
                        rs.getString("tname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.close(rs,ps,conn);
        }
        return topic;
    }

    @Override
    public boolean addTopic(String tname) {
        int rows = 0;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement(
             "insert into topic(tname) value(?)");
            ps.setString(1,tname);
            rows = ps.executeUpdate();//返回执行结果
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.close(rs,ps,conn);
        }
        if(rows != 0 && rows!=-1){//更新成功
            return true;
        }
        return false;
    }

    @Override
    public boolean delTopic(String tid) {
        int rows = 0;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement(
                    "delete  from topic where tid = ?;");
            ps.setString(1,tid);
            rows = ps.executeUpdate();
            if(rows != 0 && rows!=-1){//更新成功
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.close(rs,ps,conn);
        }
        return false;
    }

    @Override
    public boolean updateTopic(String tid, String tname) {
        int rows = 0;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement(
                    "update topic set tname=? where tid = ?;");
            ps.setString(1,tname);
            ps.setString(2,tid);
            rows = ps.executeUpdate();
            if(rows != 0 && rows!=-1){//更新成功
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.close(rs,ps,conn);
        }
        return false;
    }
}
