package com.g0818.Util;

/*
 * 订阅管理的工具类
 * */
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.SubDeviceDataInDTO;
import com.iotplatform.client.dto.SubDeviceManagementDataInDTO;
import com.iotplatform.client.dto.SubscriptionDTO;
import com.iotplatform.client.invokeapi.SubscriptionManagement;

public class SM {

	 public static SubscriptionDTO subDeviceData(SubscriptionManagement subscriptionManagement, 
	    		String notifyType, String callbackUrl, String accessToken) {
	    	SubDeviceDataInDTO sddInDTO = new SubDeviceDataInDTO();
	    	SubscriptionDTO subDTO=null;
	    	sddInDTO.setNotifyType(notifyType);
	    	sddInDTO.setCallbackUrl(callbackUrl);
	    	try {
	    		subDTO = subscriptionManagement.subDeviceData(sddInDTO, null, accessToken);
	    		} catch (NorthApiException e) {
				System.out.println(e.toString());
			}
	    	return subDTO;
	    }
	    
	    
	    public static void subDeviceManagementData(SubscriptionManagement subscriptionManagement, 
	    		String notifyType, String callbackUrl, String accessToken) {
	    	SubDeviceManagementDataInDTO sddInDTO = new SubDeviceManagementDataInDTO();
	    	sddInDTO.setNotifyType(notifyType);
	    	sddInDTO.setCallbackurl(callbackUrl);
	    	try {
				subscriptionManagement.subDeviceData(sddInDTO, accessToken);
				System.out.println("subscribe to device management data succeeds");
			} catch (NorthApiException e) {
				System.out.println(e.toString());
			}
	    	return;
	    }
}
