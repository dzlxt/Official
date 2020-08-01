package com.g0818.controller.nbcontroller;

import com.g0818.Util.AuthUtil;
import com.g0818.pojo.nbiot.Nbiotauth;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.QueryBatchDevicesInfoInDTO;
import com.iotplatform.client.dto.QueryDeviceCapabilitiesInDTO;
import com.iotplatform.client.dto.QueryDeviceDataHistoryInDTO;
import com.iotplatform.client.invokeapi.DataCollection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



/*
*数据采集
* 物联网平台支持第三方应用查询设备的基本信息，同时还支持查看设备上报的历史数
据，能按时、天，月等维度查看设备上报的历史数据
* */
@Controller
@RequestMapping("/data")
public class DataAcquisition {
    DataCollection dc = new DataCollection();
    String rs;

    //查询单个设备信息
    public String  querySingleDeviceInfo(@RequestParam(name = "dev")String dev,@RequestParam(name = "select")String select){
        try {
            rs = dc.querySingleDeviceInfo(dev,select,Nbiotauth.getAppid(), AuthUtil.getaccessToken()).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //批量查询设备信息列表
    public String queryBatchDevicesInfo(){
        QueryBatchDevicesInfoInDTO infoInDTO = new QueryBatchDevicesInfoInDTO();
        infoInDTO.setDeviceType("");
        try {
            rs = dc.queryBatchDevicesInfo(infoInDTO,AuthUtil.getaccessToken()).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //查询设备服务能力
    public String queryDeviceDataHistory(){

        QueryDeviceDataHistoryInDTO historyInDTO = new QueryDeviceDataHistoryInDTO();
        historyInDTO.setAppId("");
        try {
           rs = dc.queryDeviceDataHistory(historyInDTO,AuthUtil.getaccessToken()).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    // 查询设备服务能力
    public String  queryDeviceCapabilities(){
        QueryDeviceCapabilitiesInDTO capabilitiesInDTO = new QueryDeviceCapabilitiesInDTO();
        capabilitiesInDTO.setAppId("");
        capabilitiesInDTO.setDeviceId("");
        capabilitiesInDTO.setGatewayId("");
        try {
            rs = dc.queryDeviceCapabilities(capabilitiesInDTO,null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

}
