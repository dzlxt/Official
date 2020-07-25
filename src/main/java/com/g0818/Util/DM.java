package com.g0818.Util;
//设备管理工具类
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.ModifyDeviceInforInDTO;
import com.iotplatform.client.dto.ModifyDeviceShadowInDTO;
import com.iotplatform.client.dto.QueryDeviceRealtimeLocationInDTO;
import com.iotplatform.client.dto.QueryDeviceRealtimeLocationOutDTO;
import com.iotplatform.client.dto.RefreshDeviceKeyInDTO;
import com.iotplatform.client.dto.RefreshDeviceKeyOutDTO;
import com.iotplatform.client.dto.RegDirectDeviceInDTO2;
import com.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.iotplatform.client.dto.ServiceDesiredDTO;
import com.iotplatform.client.invokeapi.DeviceManagement;

public  class DM {

	public static RegDirectDeviceOutDTO registerDevice(DeviceManagement deviceManagement,String accessToken,String nodeid) {
		
		String verifyCode = nodeid;
    	int timeout = 300;
    	RegDirectDeviceInDTO2 rddid = new RegDirectDeviceInDTO2();
    	rddid.setNodeId(nodeid);
    	rddid.setVerifyCode(verifyCode);
    	rddid.setTimeout(timeout);
    	RegDirectDeviceOutDTO rddod = new RegDirectDeviceOutDTO();
    	try {
			rddod = deviceManagement.regDirectDevice(rddid, null, accessToken);
			return rddod;
		} catch (NorthApiException e) {
			e.printStackTrace();
		}
    	return null;  
	}
    
    public static void modifyDeviceInfo(DeviceManagement deviceManagement, String accessToken, String deviceId, String deviceName) {
    	ModifyDeviceInforInDTO mdiInDTO = new ModifyDeviceInforInDTO();
        mdiInDTO.setName(deviceName);
        mdiInDTO.setDeviceType("Bulb");
        mdiInDTO.setManufacturerId("AAAA");
        mdiInDTO.setManufacturerName("AAAA");
        mdiInDTO.setModel("AAAA");
        mdiInDTO.setProtocolType("CoAP");
        try {
			deviceManagement.modifyDeviceInfo(mdiInDTO, deviceId, null, accessToken);
			System.out.println("modify device info succeeded");
		} catch (NorthApiException e) {
			System.out.println(e.toString());
		}
    }
    
    public static QueryDeviceRealtimeLocationOutDTO queryDeviceLocation(DeviceManagement deviceManagement, String accessToken, String deviceId) {
    	QueryDeviceRealtimeLocationInDTO qdrlInDTO = new QueryDeviceRealtimeLocationInDTO();
        qdrlInDTO.setDeviceId(deviceId);
        qdrlInDTO.setHorAcc(1000);
        QueryDeviceRealtimeLocationOutDTO qdrlOutDTO;
		try {
			qdrlOutDTO = deviceManagement.queryDeviceRealtimeLocation(qdrlInDTO, null, accessToken);
			return qdrlOutDTO;
		} catch (NorthApiException e) {
			System.out.println(e.toString());
		}
        
        return null;
    }
    
    private static void modifyDeviceShadow(DeviceManagement deviceManagement, String accessToken, String deviceId) {
    	ModifyDeviceShadowInDTO mdsInDTO = new ModifyDeviceShadowInDTO();
        
        ServiceDesiredDTO sdDTO = new ServiceDesiredDTO();
        sdDTO.setServiceId("Brightness");        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("brightness", 100);
        sdDTO.setDesired(map);
        
        List<ServiceDesiredDTO> serviceDesireds = new ArrayList<ServiceDesiredDTO>();
        serviceDesireds.add(sdDTO);        
        mdsInDTO.setServiceDesireds(serviceDesireds);        
        
        try {
			deviceManagement.modifyDeviceShadow(mdsInDTO, deviceId, null, accessToken);
			System.out.println("modify device shadow succeeded");
		} catch (NorthApiException e) {
			System.out.println(e.toString());
		}
    }
    
    public static RefreshDeviceKeyOutDTO refreshDeviceKey(DeviceManagement deviceManagement, String accessToken, String nodeid,String deviceId) {
    	RefreshDeviceKeyInDTO rdkInDTO = new RefreshDeviceKeyInDTO();
    	RefreshDeviceKeyOutDTO rdkOutDTO =null;
		rdkInDTO.setNodeId(nodeid);
		rdkInDTO.setVerifyCode(nodeid);
    	rdkInDTO.setTimeout(3600);
    	
    	try {
    		rdkOutDTO = deviceManagement.refreshDeviceKey(rdkInDTO, deviceId, null, accessToken);
    	} catch (NorthApiException e) {
			System.out.println(e.toString());
		}
    	return rdkOutDTO;
    }
}
