package com.g0818.controller.nbcontroller;


import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.DeviceUpgrade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/eu")
public class EquipmentUpgrade {

    private DeviceUpgrade du = new DeviceUpgrade();
    private OperateDevices targets = new OperateDevices();
    private OperatePolicy policy = new OperatePolicy();
    private String rs;

    // 查询版本包列表
    public String queryUpgradePackageList(){
        QueryUpgradePackageListInDTO listInDTO =new QueryUpgradePackageListInDTO();
        listInDTO.setDeviceType("");
        listInDTO.setFileType("");

        try {
            rs = du.queryUpgradePackageList(listInDTO, null).toString();
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return rs ;
    }

    // 查询指定版本包
    public String  queryUpgradePackage(String fileId){
        try {
            rs = du.queryUpgradePackage(fileId, null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //删除指定版本包
    public String  deleteUpgradePackage(String fileId){
        try {
            du.deleteUpgradePackage(fileId,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //创建软件升级任务
    public String  createSoftwareUpgradeTask(String fileId){
        CreateUpgradeTaskInDTO taskInDTO = new CreateUpgradeTaskInDTO();
        policy.setExecuteType("now");
        List<String> deviceGroups = new LinkedList<>();
        deviceGroups.add("");
        targets.setDeviceGroups(deviceGroups);
        taskInDTO.setFileId(fileId);
        try {
            rs = du.createSoftwareUpgradeTask(taskInDTO, null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    // 创建固件升级任务
    public String  createFirmwareUpgradeTask(String fileid){
        CreateUpgradeTaskInDTO taskInDTO = new CreateUpgradeTaskInDTO();
        taskInDTO.setFileId(fileid);//要升级的目标版本包 ID
        policy.setExecuteType("");
        taskInDTO.setPolicy(policy);//要进行升级的目标
        try {
            rs = du.createFirmwareUpgradeTask(taskInDTO, null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //查询指定升级任务结果
    public String  queryUpgradeTask(String operationId){
        try {
            rs = du.queryUpgradeTask(operationId, null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //查询指定升级任务子任务详情
    public String  queryUpgradeSubTask(String operationId){
        QueryUpgradeSubTaskInDTO taskInDTO = new QueryUpgradeSubTaskInDTO();
        try {
            rs = du.queryUpgradeSubTask(taskInDTO, operationId, null).toString();
        } catch (NorthApiException e) {
            rs = e.toString();
        }
        return rs;
    }

    //查询升级任务列表
    public String queryUpgradeTaskList(){
        QueryUpgradeTaskListInDTO listInDTO = new QueryUpgradeTaskListInDTO();
        listInDTO.setDeviceId("");
        listInDTO.setOperationType("");//操作类型。
        try {
            du.queryUpgradeTaskList(listInDTO,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
