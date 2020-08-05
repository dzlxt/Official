package com.g0818.controller.nbcontroller;

import com.g0818.pojo.nbiot.Nbiotauth;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.DeviceGroupManagement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//设备管理组
@Controller
@RequestMapping("dgm")
public class myDeviceGroupManagemen {

    DeviceGroupManagement dgm = new DeviceGroupManagement();
    List<String> deviceid = new LinkedList<>();
    String rs;

    // 创建设备组
    @RequestMapping("/cdg")
    @ResponseBody
    public String createDeviceGroup(){
        List<String> dis = null;
        dis.add("");
        dis.add("");
        CreateDeviceGroupInDTO groupInDTO = new CreateDeviceGroupInDTO();
        groupInDTO.setAppId(Nbiotauth.getAppid()); //如果是本应用的设备，此参数值可以填写 null，否则填写授权应用的appId
        groupInDTO.setDescription("");//设备组的描述信息。
        groupInDTO.setDeviceIds(dis);//添加到设备组的设备 ID 列表。
        groupInDTO.setMaxDevNum(0);
        groupInDTO.setName("");//设备组名称，仅限大小写字母和数字
        try {
            rs = dgm.createDeviceGroup(groupInDTO,null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //删除设备组
    public String deleteDeviceGroup(String devGroupId){
        try {
            dgm.deleteDeviceGroup(devGroupId,null,null);
        } catch (NorthApiException e) {
            rs =e.toString();
        }
        return rs="";
    }

    //修改设备组
    public String modifyDeviceGroup(String devGroupId){
        ModifyDeviceGroupInDTO groupInDTO = new ModifyDeviceGroupInDTO();
        groupInDTO.setName(""); //设备组名称，仅限大小写字母和数字
        groupInDTO.setDescription(""); //设备组的描述信息。
        groupInDTO.setMaxDevNum(0);//设备组设备最大数量，默认值为0。
        try {
            rs = dgm.modifyDeviceGroup(groupInDTO,devGroupId,null,null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }

        return rs;
    }

    //查询设备组详情
    public String queryDeviceGroups(String name){
        QueryDeviceGroupsInDTO groupsInDTO = new QueryDeviceGroupsInDTO();
        groupsInDTO.setName(name);
        groupsInDTO.setAccessAppId(null);
        try {
           rs = dgm.queryDeviceGroups(groupsInDTO,null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //查询指定设备组
    public String  querySingleDeviceGroup(String devGroupId){
        try {
           rs = dgm.querySingleDeviceGroup(devGroupId,null,null).toString();
        } catch (NorthApiException e) {
           rs = e.toString();
        }
        return rs;
    }

    //查询指定设备组成员
    public String queryDeviceGroupMembers(){
        QueryDeviceGroupMembersInDTO membersInDTO = new QueryDeviceGroupMembersInDTO();
        membersInDTO.setDevGroupId("");//设备组ID，在增加设备组后由物联网平台返回获得
        membersInDTO.setAccessAppId(null);
        try {
            rs = dgm.queryDeviceGroupMembers(membersInDTO, null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //增加设备组成员
    public String  addDevicesToGroup(){
        DeviceGroupWithDeviceListDTO listDTO = new DeviceGroupWithDeviceListDTO();
        deviceid.add("");
        listDTO.setDevGroupId("");
        listDTO.setDeviceIds(deviceid);
        try {
            rs = dgm.addDevicesToGroup(listDTO, null, null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }
    //删除设备组成员
    public String deleteDevicesFromGroup(){
        DeviceGroupWithDeviceListDTO listDTO = new DeviceGroupWithDeviceListDTO();
        deviceid.add("");
        listDTO.setDevGroupId("");
        listDTO.setDeviceIds(deviceid);
        try {
            dgm.deleteDevicesFromGroup(listDTO,null,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return "";
    }

}
