package com.soft2.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.soft2.model.Feel;

public class FeelDao extends BaseDao{
	public List<Feel> findFeels(int uid) {
		
		String sql="select * from feel where uid=?  order by id desc";
		Object[] object = new Object[1] ;
		object[0]=uid; 
		List<Object> objs=excuteQuery(sql, object);
		List feels=new ArrayList<Feel>();
		for (int i = 0; i < objs.size(); i++) {
			HashMap map=(HashMap) objs.get(i);
			Feel feel =new Feel();
			feel.setId((int)map.get("id"));;
			feel.setContext((String)map.get("context"));
			feel.setCreatetime((Date)map.get("createtime"));
			feels.add(feel);
		}
		//if(users.size()==1) {
			
		//}
		return feels;
	}
	public int findFeelsCount(int uid) {
		
		String sql="select count(*) from feel where uid=?";
		Object[] object = new Object[1] ;
		object[0]=uid; 
		Long objs=(Long) executeQuerySingle(sql, object);
		return objs.intValue();
		
	}
	public boolean addFeels(Feel feel) {
		
		String sql="insert into feel (`uid`,`context`,`createtime`) value(?,?,?) ";
		Object[] object = new Object[3] ;
		object[0]=feel.getUid(); 
		object[1]=feel.getContext();
		object[2]=feel.getCreatetime();
		int count=exeUpdate(sql, object);
		if(count==1) {
			return true;
		}
		return false;
	}
//	public static void main(String[] args) {
//		findOneUser("2", "3");
//	}
}
