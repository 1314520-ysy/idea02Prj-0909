package edu.soft2.impl;

import edu.soft2.dao.BaseDao;
import edu.soft2.dao.UserDao;
import edu.soft2.pojo.User;
import edu.soft2.util.DaoFactory;

import java.sql.*;

/**
 * 实现UserDao接口
 */
public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public User findUser(String username, String pwd) {
        User user = null;
        String sql = "select * from news_user where username = ? and upwd = ?;";
        Object[] params = {username,pwd};
        rs = this.executeSQL(sql,params);
        //解析结果集
        try{
            while (rs.next()){
                user = new User(
                        rs.getString("uid"),
                        rs.getString("username"),
                        rs.getString("upwd")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource();
        }
        return user;
    }
}
      /*  try {
            //连接数据库
            conn = DaoFactory.getConn();
            //查询
            ps = conn.prepareStatement(
            "select * from news_user where username = ? and upwd = ?;");
            ps.setString(1,username);
            ps.setString(2,upwd);
            rs = ps.executeQuery();
            //解析结果集
            while(rs.next()){
                //封装到User对象中
                user = new User(
                    rs.getString("uid"),
                    rs.getString("username"),
                    rs.getString("upwd")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.close(rs,ps,conn);
        }
        return user;
    }
}
*/
