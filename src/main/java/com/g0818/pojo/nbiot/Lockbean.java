package com.g0818.pojo.nbiot;

//锁的基本数据bean
public class Lockbean {

	private		int		id;
	private		String	IMEI;
	private		String	NBcar;
	private		int		parkingNo;
	private		byte		EnabledState;
	private		String	motherboard;
	private		String	batteryNO;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getNBcar() {
		return NBcar;
	}
	public void setNBcar(String nBcar) {
		NBcar = nBcar;
	}
	public int getParkingNo() {
		return parkingNo;
	}
	public void setParkingNo(int parkingNo) {
		this.parkingNo = parkingNo;
	}
	public byte getEnabledState() {
		return EnabledState;
	}
	public void setEnabledState(byte enabledState) {
		EnabledState = enabledState;
	}
	public String getMotherboard() {
		return motherboard;
	}
	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
	}
	public String getBatteryNO() {
		return batteryNO;
	}
	public void setBatteryNO(String batteryNO) {
		this.batteryNO = batteryNO;
	}
	
	
}
