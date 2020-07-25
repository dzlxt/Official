package com.g0818.pojo.nbiot;

//收入明细数据库bean
public class IncomeDetails {
	
	private int id;
	private String lockNO;
	private int stoptime;
	private int money;
	private int sstime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLockNO() {
		return lockNO;
	}
	public void setLockNO(String lockNO) {
		this.lockNO = lockNO;
	}
	public int getStoptime() {
		return stoptime;
	}
	public void setStoptime(int stoptime) {
		this.stoptime = stoptime;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getSstime() {
		return sstime;
	}
	public void setSstime(int sstime) {
		this.sstime = sstime;
	}
	
	

}
