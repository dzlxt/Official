package com.g0818.controller.nbcontroller;

import com.g0818.Util.AuthUtil;
import com.g0818.Util.SignalDeliveryUtil;
import com.g0818.pojo.nbiot.Nbiotauth;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.SignalDelivery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

//命令下发类
@Controller
@RequestMapping("/com")
public class CommIss {

    SignalDelivery sd = new SignalDelivery();
    String rs;
    //开锁命令
    @RequestMapping("/cmd")
    @ResponseBody
    public String postDeviceCommand(@RequestParam(name ="dev")String dev){
        System.out.println(dev+"*****"+AuthUtil.getaccessToken());
        String rs;
        try {
            PostDeviceCommandOutDTO2 outDTO2 = SignalDeliveryUtil.postCommand(dev);
            rs = outDTO2.getStatus();
        } catch (NorthApiException e) {
            rs = e.getError_code()+"*****"+e.getError_desc()+"*****"+e.getHttpMessage()+"*****"+e.getHttpReasonPhase()+"*****"+e.getHttpStatusCode();
        }
        return rs;
    }

    //查询设备下发命令状态
    @RequestMapping("/query")
    @ResponseBody
    public String queryDeviceCommand(){
        QueryDeviceCommandInDTO2 inDTO2 = new QueryDeviceCommandInDTO2();

        QueryDeviceCommandOutDTO2 outDTO2 = new QueryDeviceCommandOutDTO2();
        //inDTO2.setPageSize(50);
        //inDTO2.setPageNo(0);
        inDTO2.setAppId(null);
        inDTO2.setDeviceId("3812c45b-e11b-402c-a8ff-a392b43e7b2e");
        inDTO2.setStartTime("20180712T121212Z");
        inDTO2.setEndTime("20200712T121212Z");
        try {
            rs = sd.queryDeviceCommand(inDTO2,AuthUtil.getaccessToken()).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //修改设备命令
    @RequestMapping("/upcmd")
    @ResponseBody
    public String  updateDeviceCommand(@RequestParam(name="n")String deviceid){
        UpdateDeviceCommandInDTO inDTO = new UpdateDeviceCommandInDTO();
        inDTO.setStatus("CANCELED");
        try {
            sd.updateDeviceCommand(inDTO,"switch_lock",Nbiotauth.getAppid(),AuthUtil.getaccessToken());
        } catch (NorthApiException e) {
            rs =e.toString();
        }

        return rs;
    }
    //创建设备命令撤销任务
    @RequestMapping("/creatcmd")
    @ResponseBody
    public String createDeviceCmdCancelTask(){
        CreateDeviceCmdCancelTaskInDTO taskInDTO = new CreateDeviceCmdCancelTaskInDTO();
        taskInDTO.setDeviceId("aaaaaaa");
        try {
            sd.createDeviceCmdCancelTask(taskInDTO,Nbiotauth.getAppid(),AuthUtil.getaccessToken());
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //查询设备命令撤销任务
    public String queryDeviceCmdCancelTask(){
        QueryDeviceCmdCancelTaskInDTO2 taskInDTO2 =new QueryDeviceCmdCancelTaskInDTO2();
        taskInDTO2.setAppId("");
        try {
            rs = sd.queryDeviceCmdCancelTask(taskInDTO2,AuthUtil.getaccessToken()).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }
}
