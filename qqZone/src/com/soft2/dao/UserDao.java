package com.soft2.dao;

import java.util.HashMap;
import java.util.List;

import com.soft2.model.User;

public class UserDao extends BaseDao {
	public User findOneUser(String userName, String passWord) {

		String sql = "select * from user where username=? and pwd=?";
		Object[] object = new Object[2];
		object[0] = userName;
		object[1] = passWord;
		List<Object> users = excuteQuery(sql, object);
		User user = null;
		if (users.size() == 1) {
			HashMap map = (HashMap) users.get(0);
			user = new User();
			user.setUsername(userName);
			user.setUid((int) map.get("uid"));
			user.setHeadpic((String) map.get("headpic"));
			user.setPwd((String) map.get("pwd"));
		}
		System.out.println(users);
		return user;
	}
	public User findOneUser(String userName) {

		String sql = "select * from user where username=?";
		Object[] object = new Object[1];
		object[0] = userName;
		List<Object> users = excuteQuery(sql, object);
		User user = null;
		if (users.size() == 1) {
			HashMap map = (HashMap) users.get(0);
			user = new User();
			user.setUsername(userName);
			user.setUid((int) map.get("uid"));
			user.setHeadpic((String) map.get("headpic"));
			user.setPwd((String) map.get("pwd"));
		}
		return user;
	}
	public User findOneUserById(int uid) {

		String sql = "select * from user where uid=?";
		Object[] object = new Object[1];
		object[0] = uid;
		List<Object> users = excuteQuery(sql, object);
		User user = null;
		if (users.size() == 1) {
			HashMap map = (HashMap) users.get(0);
			user = new User();
			user.setUsername((String) map.get("userName"));
			user.setUid((int) map.get("uid"));
			user.setHeadpic((String) map.get("headpic"));
			user.setPwd((String) map.get("pwd"));
		}
		System.out.println(users);
		return user;
	}

	public int updatePassword(String userName, String passWord) {
		String sql = "update user set pwd=? where username=?";
		Object[] object = new Object[2];
		object[0] = passWord;
		object[1] = userName;
		int count = exeUpdate(sql, object);
		return count;
	}

	public int regUser(User user) {
		String sql = "insert user (`username`,`pwd`,`qq`,`nickname`,`birthday`,`crreatetime`,`headpic`) value(?,?,?,?,?,?,?)";
		Object[] object = new Object[7];
		object[0] = user.getUsername();
		object[1] = user.getPwd();
		object[2] = user.getQq();
		object[3] = user.getNickname();
		object[4] = user.getBirthday();
		object[5] = user.getCreatetime();
		object[6] = user.getHeadpic();
		int count =exeUpdate(sql, object);
		return count;
	}

}
