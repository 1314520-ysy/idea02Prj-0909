package edu.soft2.test;

import edu.soft2.dao.impl.NewsDaoImpl;
import edu.soft2.pojo.News;

import java.util.List;

/**
 * NewsDao的测试类
 */
public class NewsDaoTest {
    public static void main(String[] args) {
        NewsDaoImpl newDao = new NewsDaoImpl();
        //测试findNews()方法，根据nTid字段查询新闻
       // List<News> list = newDao.findNews("1");
        //测试findAllNews()方法，查询所有新闻
        List<News> list = newDao.findAllNews();
        System.out.println("共查到"+list.size()+"个News对象");
        for(News news:list){
            System.out.println(news.toString());
        }
    }
}
