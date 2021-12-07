package com.soft2.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.soft2.model.History;

public class HistoryDao extends BaseDao{
	public List<History> findHistory(int uid) {
		String sql="select * from History where uid=?";
		Object[] object = new Object[1] ;
		object[0]=uid; 
		List<Object> objs=excuteQuery(sql, object);
		List historys=new ArrayList<History>();
		for (int i = 0; i < objs.size(); i++) {
			HashMap map=(HashMap) objs.get(i);
			History history =new History();
			history.setId((int)map.get("id"));;
			history.setFid((int)map.get("fid"));
			history.setVisittime((Date)map.get("visittime"));
			historys.add(history);
		}
		return historys;
	}
	public boolean insertHistory(History history) {
		String sql="insert into History (`uid`,`fid`,`visittime`) value(?,?,?)";
		Object[] object = new Object[3] ;
		object[0]=history.getUid();
		object[1]=history.getFid();
		object[2]=new Date();
		int count=exeUpdate(sql, object);
		if(count==1) {
			return true;
		}else {
			return false;
		}
		
	}
	public static void main(String[] args) {
		FriendShipDao fs=new FriendShipDao();
		System.out.println(fs.findFriendCount(1));
	}
}
