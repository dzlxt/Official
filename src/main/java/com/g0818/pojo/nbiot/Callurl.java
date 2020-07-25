package com.g0818.pojo.nbiot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "call")
public class Callurl {

	private static String callurl;
	private static String callbackurl_nbcmd;
	
	public static String getCallurl() {
		return callurl;
	}
	
	public void setCallurl(String callurl) {
		Callurl.callurl=callurl;
	}
	
	public static String getcallbackurl_nbcmd() {
		return callbackurl_nbcmd;
	}
	
	public void setcallbackurl_nbcmd(String callbackurl_nbcmd) {
		Callurl.callurl=callbackurl_nbcmd;
	}
	
}
