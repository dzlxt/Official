package com.g0818.Util;

import com.g0818.pojo.nbiot.Nbiotauth;
import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.Authentication;

public class AuthUtil {
	
	private static NorthApiClient northApiClient = null;

		public static NorthApiClient initApiClient() {
			
			String base_path=System.getProperty("user.dir");//"/www/tomcat/webapps/ROOT/WEB-INF/classes";
			SSLConfig sslconfig = new SSLConfig();
			sslconfig.setTrustCAPath( base_path+"/src/main/resources/cert/ca.jks");
			sslconfig.setTrustCAPwd("Huawei@123");
			sslconfig.setSelfCertPath( base_path+"/src/main/resources/cert/outgoing.CertwithKey.pkcs12");
			sslconfig.setSelfCertPwd("IoM@1234");
			
		if (northApiClient != null) {
			return northApiClient;
		}
		northApiClient = new NorthApiClient();

		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setPlatformIp(Nbiotauth.getPlatformIp());//平台IP;
		clientInfo.setPlatformPort(Nbiotauth.getPlatformport());//平台端口号;
		clientInfo.setAppId(Nbiotauth.getAppid());//平台appid;
		clientInfo.setSecret(Nbiotauth.getSecret());//平台密码；
//        clientInfo.setSecret(getAesPropertyValue("secret"));
			try {
			northApiClient.setClientInfo(clientInfo);
			northApiClient.initSSLConfig();
		} catch (NorthApiException e) {

			System.out.println(e.toString());
		}
		return northApiClient;
    }
	
	public static String getaccessToken(){

		Authentication authentication = new Authentication(northApiClient);
		try {
			authentication.startRefreshTokenTimer();
		} catch (NorthApiException e) {
			e.printStackTrace();
		}
		AuthOutDTO authOutDTO=null;
		try {
			authOutDTO = authentication.getAuthToken();
		} catch (NorthApiException e) {
			e.printStackTrace();
		}		   
        String accessToken = authOutDTO.getAccessToken();
        return accessToken;
	}

	public static void refreshToken(){
		NorthApiClient northApiClient = initApiClient();
		AuthRefreshInDTO authRefreshInDTO = new AuthRefreshInDTO();
		Authentication authentication = new Authentication(northApiClient);
		AuthOutDTO authOutDTO = new AuthOutDTO();
		try {
			authOutDTO = authentication.getAuthToken();
		} catch (NorthApiException e) {
			e.printStackTrace();
		}
		authRefreshInDTO.setAppId(Nbiotauth.getAppid());
		authRefreshInDTO.setSecret(northApiClient.getClientInfo().getSecret());
		String refreshToken = authOutDTO.getRefreshToken();
		authRefreshInDTO.setRefreshToken(refreshToken);
		AuthRefreshOutDTO authRefreshOutDTO =new AuthRefreshOutDTO();
		try {
			authRefreshOutDTO = authentication.refreshAuthToken(authRefreshInDTO);
		} catch (NorthApiException e) {
			e.printStackTrace();
		}
		System.out.println(authRefreshOutDTO);
	}
}
