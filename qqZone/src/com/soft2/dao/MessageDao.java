package com.soft2.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.soft2.model.Message;
import com.soft2.model.User;

public class MessageDao extends BaseDao{
	public List<Message> findMessages(int uid) {
		String sql="select * from Message where uid=?  order by id desc";
		Object[] object = new Object[1] ;
		object[0]=uid; 
		List<Object> objs=excuteQuery(sql, object);
		List messages=new ArrayList<Message>();
		for (int i = 0; i < objs.size(); i++) {
			HashMap map=(HashMap) objs.get(i);
			Message message =new Message();
			message.setId((int)map.get("id"));
			UserDao userDao =new UserDao();
			User user=userDao.findOneUserById((int)map.get("fid"));
			message.setUser(user);
			message.setId((int)map.get("id"));;
			message.setContext((String)map.get("context"));
			message.setCreatetime((Date)map.get("createtime"));
			messages.add(message);
		}
		//if(users.size()==1) {
			
		//}
		return messages;
	}
	public int findMessagesCount(int uid) {
		String sql="select count(*) from message where uid=?";
		Object[] object = new Object[1] ;
		object[0]=uid; 
		Long objs=(Long) executeQuerySingle(sql, object);
		return objs.intValue();
	}
	public boolean addMessage(Message message) {
		String sql="insert into message (`uid`,`context`,`createtime`,`fid`) value(?,?,?,?) ";
		Object[] object = new Object[4] ;
		object[0]=message.getUid(); 
		object[1]=message.getContext();
		object[2]=message.getCreatetime();
		object[3]=message.getFid();
		int count=exeUpdate(sql, object);
		if(count==1) {
			return true;
		}
		return false;
	}
	public boolean delMessage(Message message) {
		String sql="insert into message (`uid`,`context`,`createtime`,`fid`) value(?,?,?,?) ";
		Object[] object = new Object[4] ;
		object[0]=message.getUid(); 
		object[1]=message.getContext();
		object[2]=message.getCreatetime();
		object[3]=message.getFid();
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
