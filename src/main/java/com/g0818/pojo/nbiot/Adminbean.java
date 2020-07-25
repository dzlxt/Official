package com.g0818.pojo.nbiot;

//后台管理员数据库bean


public class Adminbean {
	private Integer	id;
	private String uname;
	private String upwd;
	private Integer	logintime;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Integer getLogintime() {
		return logintime;
	}
	public void setLogintime(Integer logintime) {
		this.logintime = logintime;
	}
	
}
