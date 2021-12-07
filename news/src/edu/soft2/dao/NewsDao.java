package edu.soft2.dao;

import edu.soft2.pojo.News;

import java.util.List;

public interface NewsDao {
    public int getTotalCount();
    public List<News> findNews(String nTid);
    public List<News> findAllNews();
    public List<News> getPageNewsList(int CurrPageNo, int pageSize);
}
