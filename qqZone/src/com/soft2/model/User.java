package com.soft2.model;

import java.util.Date;

public class User {
	private int uid;
	private String username;
	private String pwd;
	private String qq;
	private Date birthday;
	private String nickname;
	private float money;
	private String headpic;
	private String hometown;
	private String nowaddress;
	private int ismarry;
	private int state;
	private Date lastvisit;
	private Date createtime;
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	private String modify_suc;
	private int sex;
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getNowaddress() {
		return nowaddress;
	}

	public void setNowaddress(String nowaddress) {
		this.nowaddress = nowaddress;
	}

	public int getIsmarry() {
		return ismarry;
	}

	public void setIsmarry(int ismarry) {
		this.ismarry = ismarry;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getLastvisit() {
		return lastvisit;
	}

	public void setLastvisit(Date lastvisit) {
		this.lastvisit = lastvisit;
	}

	public String getModify_suc() {
		return modify_suc;
	}

	public void setModify_suc(String modify_suc) {
		this.modify_suc = modify_suc;
	}

	public String getHeadpic() {
		return headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", pwd=" + pwd + ", qq=" + qq + ", birthday=" + birthday
				+ ", money=" + money + ", headpic=" + headpic + "]";
	}

}
