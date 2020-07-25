package com.g0818.pojo.nbiot;

public class CmdResult {

	private String deviceId;
	private String commandId;
	private String resultCode;
	private  CmdRes result;
	
	public CmdRes getResult() {
		return result;
	}
	public void setResult(CmdRes result) {
		this.result = result;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getCommandId() {
		return commandId;
	}
	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
}
