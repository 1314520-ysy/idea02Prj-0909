package edu.soft2.dao;

import edu.soft2.pojo.Goods;
import edu.soft2.tools.DBHelp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来访问Goods表
 */
public class GoodsDao {
    /**
     * 查询Goods的所有数据
     * @return Goods对象的List集合
     */
    public List<Goods> queryAllGoods(){
        List<Goods> list = new ArrayList<>();
    //1.获取数据库的连接
       Connection conn = DBHelp.getConn();
    //2.获取PrepareStatement
    try {
        PreparedStatement ps = conn.prepareStatement("select * from goods;");
    //3.获取查询结果
        ResultSet rs = ps.executeQuery();
    //4.解析查询结果
        while(rs.next()){
            //获取一行数据，放入一个Goods对象中,将Goods对象放入list集合
            Goods goods = new Goods();//创建Goods对象

            goods.setGoodsid(rs.getString("Goodsid"));//将列字段Goodsid内容作为属性值放入Goods对象
            goods.setTitle(rs.getString("Title"));//将列字段Title内容作为属性值放入Goods对象
            goods.setUnitPrice(rs.getString("UnitPrice"));//将列字段UnitPrice内容作为属性值放入Goods对象
            goods.setDiscount(rs.getString("Discount"));
            goods.setCateid(rs.getString("Cateid"));
            goods.setStoreid(rs.getString("Storeid"));
            goods.setRoat(rs.getString("Roat"));
            goods.setDescription(rs.getString("Description"));
            goods.setPackingExpense(rs.getString("PackingExpense"));
            list.add(goods);//将Goods对象放入list集合
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }
        return list;
    }
}
