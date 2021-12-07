package edu.soft2.service;

import edu.soft2.pojo.News;

import java.util.List;

public interface NewsService {
    public int getTotalCount();

    public List<News> getPageNewsList(int CurrPageNo,int pageSize);

}
