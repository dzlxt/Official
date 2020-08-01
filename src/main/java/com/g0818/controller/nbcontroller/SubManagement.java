package com.g0818.controller.nbcontroller;


import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.SubscriptionManagement;


//订阅管理
public class SubManagement {

    SubscriptionManagement subscriptionManagement = new SubscriptionManagement();
    //订阅平台业务数据
    public String subData(){
        SubDeviceDataInDTO sddInDTO = new SubDeviceDataInDTO();
        sddInDTO.setCallbackUrl("");
        try {
            SubscriptionDTO subDTO = subscriptionManagement.subDeviceData(sddInDTO,null,null);
            subDTO.getNotifyType();
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        /*
        * 1. bindDevice（绑定设备）2. deviceAdded（添加新设备）3. deviceInfoChanged（设备信息变化）
          4. deviceDataChanged（设备数据变化）5. deviceDatasChanged（设备数据批量变化）
          6. deviceDeleted（删除设备）7. serviceInfoChanged（服务信息变化）8. ruleEvent（规则事件）
          9. deviceModelAdded（添加设备模型）10. deviceModelDeleted（删除设备模型）
        * */

        return "";
    }

    //订阅平台管理数据
    public String subManage(){

        SubDeviceManagementDataInDTO smdInDTO = new SubDeviceManagementDataInDTO();
        smdInDTO.setCallbackurl("");
        smdInDTO.setNotifyType("");
        try {
            subscriptionManagement.subDeviceData(smdInDTO,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return "";
    }

    //查询单个订阅
    public String querySingleSubscription(){
        SubscriptionDTO subscriptionDTO = null;
        try {
            subscriptionDTO = subscriptionManagement.querySingleSubscription(null, null, null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        subscriptionDTO.getSubscriptionId();
        return "";
    }

    //批量查询订阅
    public String queryBatch(){
        QueryBatchSubOutDTO outDTO = new QueryBatchSubOutDTO();
        QueryBatchSubInDTO inDTO =new QueryBatchSubInDTO();
        inDTO.setAppId("");
        inDTO.setNotifyType("");
        inDTO.setPageNo("");
        inDTO.setPageSize("");
        try {
            outDTO=subscriptionManagement.queryBatchSubscriptions(inDTO,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        outDTO.getSubscriptions();
        return "";
    }

    // 删除单个订阅
    public String deleteSingleSubscription(){

        try {
            subscriptionManagement.deleteSingleSubscription("",null,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return  "";
    }

    public String  deleteBatchSubscriptions(){
        DeleteBatchSubInDTO inDTO = new DeleteBatchSubInDTO();
        inDTO.setAppId("");
        inDTO.setNotifyType("");
        inDTO.setCallbackUrl("");
        try {
            subscriptionManagement.deleteBatchSubscriptions(inDTO,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return "";
    }
}
