package edu.soft2.service.impl;

import edu.soft2.dao.NewsDao;
import edu.soft2.dao.impl.NewsDaoImpl;
import edu.soft2.pojo.News;
import edu.soft2.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Override
    public int getTotalCount() {
        NewsDao newsDao = (NewsDao) new NewsDaoImpl();//调用下层
        return newsDao.getTotalCount();
    }
    @Override
    public List<News> getPageNewsList(int CurrPageNo, int pageSize) {
        NewsDao newsDao = (NewsDao) new NewsDaoImpl();//调用下层
        return newsDao.getPageNewsList(CurrPageNo,pageSize);
    }
}
