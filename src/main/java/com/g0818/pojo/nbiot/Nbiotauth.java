package com.g0818.pojo.nbiot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //将java bean放入容器
public class Nbiotauth {
	private		static	String appid;
	private		static	String secret;
	private		static	String platformIp;
	private		static	String platformport;
	public		static	String getAppid() {
		return appid;
	}
	
	@Value("${nb.appid}")
	public void setAppid(String appid) {
		Nbiotauth.appid = appid;
	}
	public static String getSecret() {
		return secret;
	}
	
	@Value("${nb.secret}")
	public void setSecret(String secret) {
		Nbiotauth.secret = secret;
	}
	public static String getPlatformIp() {
		return platformIp;
	}
	
	@Value("${nb.platformIp}")
	public void setPlatformIp(String platformIp) {
		Nbiotauth.platformIp = platformIp;
	}
	public static String getPlatformport() {
		return platformport;
	}
	
	@Value("${nb.platformport}")
	public void setPlatformport(String platformport) {
		Nbiotauth.platformport = platformport;
	}
	
		
}
