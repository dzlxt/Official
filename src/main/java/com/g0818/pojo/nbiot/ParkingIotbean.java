package com.g0818.pojo.nbiot;

//锁体安装位置信息bean
public class ParkingIotbean {

	private		int		id;
	private		String	city;
	private		String	partition;
	private		String	Street;
	private		int		parkingNO;
	private		String	lockNO;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPartition() {
		return partition;
	}
	public void setPartition(String partition) {
		this.partition = partition;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public int getParkingNO() {
		return parkingNO;
	}
	public void setParkingNO(int parkingNO) {
		this.parkingNO = parkingNO;
	}
	public String getLockNO() {
		return lockNO;
	}
	public void setLockNO(String lockNO) {
		this.lockNO = lockNO;
	}
	
	
}
