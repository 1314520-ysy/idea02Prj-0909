package edu.soft2.dao;

import edu.soft2.pojo.Topic;

import java.util.List;

public interface TopicDao {
    public List<Topic> findAllTopic();

    public Topic findTopicByName(String tname);

    public boolean addTopic(String tname);

    public boolean delTopic(String tid);

    public boolean updateTopic(String tid,String tname);

}
