package com.g0818.controller.nbcontroller;

import com.g0818.pojo.nbiot.Nbiotauth;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.CreateDeviceGroupInDTO;
import com.iotplatform.client.invokeapi.DeviceGroupManagement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//设备管理组
@Controller
@RequestMapping("dgm")
public class myDeviceGroupManagemen {

    DeviceGroupManagement dgm = new DeviceGroupManagement();
    String rs;

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

}
