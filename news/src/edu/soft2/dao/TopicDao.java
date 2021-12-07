package edu.soft2.dao;

import edu.soft2.pojo.Topic;
import edu.soft2.tools.DaoFactory;

import java.sql.*;
import java.util.*;

public class TopicDao {
    /**
     * 查询所有Topic数据
     * @return
     */
    public List<Topic> findAllTopic() {
        List<Topic> allTopic = new ArrayList<Topic>();
        Connection conn = DaoFactory.getConn();
        String sql = "select * from topic";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                allTopic.add(new Topic(
                        rs.getInt("tid"),
                        rs.getString("tname")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allTopic;
    }
    /**
     * 根据tname查询Topic
     * @param tname
     * @return
     */
    public Topic findTopicByName(String tname) {
        Topic topic = null;
        Connection conn = DaoFactory.getConn();
        String sql = "select * from topic where tname = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tname);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                topic = new Topic(
                        rs.getInt("tid"),
                        rs.getString("tname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topic;
    }
    /**
     * 增加topic
     * @param tname
     * @return
     */
    public boolean addTopic(String tname){
        boolean flag = false;
        Connection conn = DaoFactory.getConn();
        String sql="insert into topic(tname) values(?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tname);
            flag = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * 删除topic
     * @param tid
     * @param
     * @return
     */
    public boolean delTopic(int tid){
        int rows = 0;
        Connection conn = DaoFactory.getConn();
        String sql="delete from topic where tid = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,tid);
//            ps.setString(2,tname);
            rows = ps.executeUpdate();
            if(rows != 0 && rows!=-1){//更新成功
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *修改topic
     * @param tid
     * @param tname
     * @return
     */
    public boolean updateTopic(int tid,String tname){
        int rows = 0;
        Connection conn = DaoFactory.getConn();
        String sql="update topic set tname = ? where tid = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tname);
            ps.setInt(2,tid);
            rows = ps.executeUpdate();
            if(rows != 0 && rows!=-1){//更新成功
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

