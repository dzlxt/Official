package com.g0818.Util;


import java.util.HashMap;
import java.util.Map;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.CommandDTOV4;
import com.iotplatform.client.dto.PostDeviceCommandInDTO2;
import com.iotplatform.client.dto.PostDeviceCommandOutDTO2;
import com.iotplatform.client.invokeapi.SignalDelivery;

public class SignalDeliveryUtil {

	public static PostDeviceCommandOutDTO2 postCommand(SignalDelivery signalDelivery, String deviceId, String accessToken) {
    	PostDeviceCommandInDTO2 pdcInDTO = new PostDeviceCommandInDTO2();
        String callbackUrl="https://www.g0818.com/cmdcallback";
    	pdcInDTO.setDeviceId(deviceId);
        pdcInDTO.setCallbackUrl(callbackUrl);
        CommandDTOV4 cmd = new CommandDTOV4();
        cmd.setServiceId("parkinglock");
        cmd.setMethod("switch_lock"); //"PUT" is the command name defined in the profile
        Map<String, Object> cmdParam = new HashMap();
        cmdParam.put("open_lock", "9");//"brightness" is the command parameter name defined in the profile
        
        cmd.setParas(cmdParam);
        pdcInDTO.setCommand(cmd);
        
        try {
			return signalDelivery.postDeviceCommand(pdcInDTO, null, accessToken);
		} catch (NorthApiException e) {
			System.out.println(e.toString());
		}
        return null;
    }
}
