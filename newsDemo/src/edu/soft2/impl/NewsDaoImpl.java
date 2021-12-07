package edu.soft2.impl;

import edu.soft2.dao.NewsDao;
import edu.soft2.pojo.News;
import edu.soft2.util.DaoFactory;

import java.sql.*;
import java.util.*;

public class NewsDaoImpl implements NewsDao {
    @Override
    public List<News> findAllNews() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<News> list = new ArrayList<News>();
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from news;");
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.close(rs,ps,conn);
        }

        return list;
    }
}
