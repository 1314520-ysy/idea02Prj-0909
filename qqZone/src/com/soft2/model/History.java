package com.soft2.model;

import java.util.Date;

public class History {

	private int id;
	private int uid;
	private int fid;
	private Date visittime;
	private User User;
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getVisittime() {
		return visittime;
	}
	public void setVisittime(Date visittime) {
		this.visittime = visittime;
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", uid=" + uid + ", fid=" + fid + ", visittime=" + visittime + ", User=" + User
				+ "]";
	}
	
}
