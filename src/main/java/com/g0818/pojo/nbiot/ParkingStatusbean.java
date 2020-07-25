package com.g0818.pojo.nbiot;

//车位状态数据库的pojo
public class ParkingStatusbean {

	private		int		id;
	private		String	lockID;
	private		int		status;
	private		int		starttime;
	private		int		endtime;
	private		int		Unit_Price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLockID() {
		return lockID;
	}
	public void setLockID(String lockID) {
		this.lockID = lockID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStarttime() {
		return starttime;
	}
	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}
	public int getEndtime() {
		return endtime;
	}
	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}
	public int getUnit_Price() {
		return Unit_Price;
	}
	public void setUnit_Price(int unit_Price) {
		Unit_Price = unit_Price;
	}
		
}
