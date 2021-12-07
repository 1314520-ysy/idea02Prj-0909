package edu.soft2.tools;

import edu.soft2.pojo.News;

import java.util.List;

public class Page {
    private int totalPageCount = 1;//总页数
    private int pageSize = 0;//每页行数
    private int totalCount = 0;//总记录数
    private int currPageNo = 1;//当前页面
    private List<News> newsList;//当前页中的News对象的List集合

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        //计算总计录数
        totalPageCount = this.totalPageCount%pageSize == 0 ?
                (this.totalCount/pageSize):this.totalCount/pageSize+1;
        this.totalPageCount = totalPageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
        }
    }

    public int getCurrPageNo() {
        if (totalPageCount == 0) {
            return 0;
        }
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        if (this.currPageNo > 0) {
            this.currPageNo = currPageNo;
        }
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
