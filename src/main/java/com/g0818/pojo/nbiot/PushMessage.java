package com.g0818.pojo.nbiot;



public class PushMessage {

	private Integer id;
	private String deviceId;
	private String eventTime;
	private String parkingState;
	
	public String getParkingState() {
		return parkingState;
	}

	public void setParkingState(String parkingState) {
		this.parkingState = parkingState;
	}

	public PushMessage() {
	}

	public PushMessage(Integer id, String deviceId ,String parkingState,String eventTime) {
		this.id = id;
		this.deviceId = deviceId;
		this.eventTime = eventTime;
		this.parkingState = parkingState;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
