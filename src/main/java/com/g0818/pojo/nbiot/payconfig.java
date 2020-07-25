package com.g0818.pojo.nbiot;

import java.io.InputStream;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wxpay")
public class payconfig   {

	private    String AppID;
	private    String MchID;
	private  static  String Key;
	private    InputStream CertStream;
	private    int HttpConnectTimeoutMs;
	private    int HttpReadTimeoutMs;
	private    String NotifyUrl;
	private		String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNotifyUrl() {
		return NotifyUrl;
	}

	public String getAppID() {
		return AppID;
	}

	public void setAppID(String appID) {
		AppID = appID;
	}

	public void setMchID(String mchID) {
		MchID = mchID;
	}

	public void setKey(String key) {
		Key = key;
	}

	public void setCertStream(InputStream certStream) {
		CertStream = certStream;
	}

	public void setHttpConnectTimeoutMs(int httpConnectTimeoutMs) {
		HttpConnectTimeoutMs = httpConnectTimeoutMs;
	}

	public void setHttpReadTimeoutMs(int httpReadTimeoutMs) {
		HttpReadTimeoutMs = httpReadTimeoutMs;
	}

	public void setNotifyUrl(String notifyUrl) {
		NotifyUrl = notifyUrl;
	}


	public String getMchID() {
		return MchID;
	}


	public  String getKey() {
		return Key;
	}


	public InputStream getCertStream() {
		return CertStream;
	}

	public int getHttpConnectTimeoutMs() {
		return HttpConnectTimeoutMs;
	}


	public int getHttpReadTimeoutMs() {
		return HttpReadTimeoutMs;
	}
	
	public String  getnotifyUrl() {
		return NotifyUrl;
	}


}