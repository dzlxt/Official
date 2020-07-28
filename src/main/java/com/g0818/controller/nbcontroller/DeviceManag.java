package com.g0818.controller.nbcontroller;


import com.g0818.Util.AuthUtil;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.ModifyDeviceInforInDTO;
import com.iotplatform.client.dto.QueryDeviceStatusOutDTO;
import com.iotplatform.client.dto.RegDirectDeviceInDTO2;
import com.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.iotplatform.client.invokeapi.DeviceManagement;
import org.springframework.stereotype.Controller;

@Controller
public class DeviceManag {

    DeviceManagement dm = new DeviceManagement();

    //设备向物联平台注册
    public String regDevice(){

        RegDirectDeviceInDTO2 rdd2 = new RegDirectDeviceInDTO2();
        rdd2.setVerifyCode(""); //在 NB-IoT 方案中，verifyCode为必填参数，且必须与 nodeId设置成相同值。
        rdd2.setNodeId(""); //设备的唯一标识，必须与设备上报的设备标识一致。通常使用MAC 地址，Serial No 或 IMEI作为 nodeId。
        rdd2.setTimeout(3300);
        RegDirectDeviceOutDTO rddo = null;
        try {
            rddo = dm.regDirectDevice(rdd2, null, AuthUtil.getaccessToken());
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return rddo.getDeviceId()+rddo.getVerifyCode();
    }

    //修改设备信息
    public String modifyDevice(){
        ModifyDeviceInforInDTO mdii = new ModifyDeviceInforInDTO();
        mdii.setDeviceType("");
        try {
            dm.modifyDeviceInfo(mdii,"","","");
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return "";
    }

    //删除设备
    public String delDevice(){
        try {
            dm.deleteDirectDevice("",true,"","");
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return "";
    }

    //查询设备激活状态
    public String queryDeviceStatus(String deviceId, String appId, String accessToken){
        QueryDeviceStatusOutDTO qdso=null;
        try {
            qdso = dm.queryDeviceStatus(deviceId,appId, accessToken);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }

        return qdso.isActivated()+qdso.getName();
    }

}
