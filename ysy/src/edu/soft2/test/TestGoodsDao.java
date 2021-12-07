package edu.soft2.test;

import edu.soft2.dao.GoodsDao;
import edu.soft2.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

//GoodsDao的测试类
public class TestGoodsDao {
    public static void main(String[] args) {
        List<Goods> list = new ArrayList<>();
        list = new GoodsDao().queryAllGoods();//接受方法返回值
        //打印ist中的goods对象(toSttring()方法)
        for (Goods goods:list){
            System.out.println(goods);
        }
    }
}
