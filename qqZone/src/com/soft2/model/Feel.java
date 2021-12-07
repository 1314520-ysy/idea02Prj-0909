package com.soft2.model;

import java.util.Date;

public class Feel {

	private int id;
	private int uid;
	private String context;
	private Date createtime;
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
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Feel [id=" + id + ", uid=" + uid + ", context=" + context + ", createtime=" + createtime + "]";
	}
	
}
