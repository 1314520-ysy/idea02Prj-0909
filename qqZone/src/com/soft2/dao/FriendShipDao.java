package com.soft2.dao;

public class FriendShipDao extends BaseDao{

	public int findFriendCount(int uid) {
		String sql="select count(*) from friendship where uid=? ";
		Object[] object = new Object[1] ;
		object[0]=uid; 
		int objs=executeQuerySingleInt(sql, object);
		return objs==0?0:objs;
	}
	
	public static void main(String[] args) {
		FriendShipDao fs=new FriendShipDao();
		System.out.println(fs.findFriendCount(1));
	}
}
