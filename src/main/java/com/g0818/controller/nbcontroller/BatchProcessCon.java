package com.g0818.controller.nbcontroller;

import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.BatchProcess;
import org.springframework.stereotype.Controller;

//批量处理
@Controller
public class BatchProcessCon {

    BatchProcess bp= new BatchProcess();

    //创建批量任务
    public String  createBatchTask(){
        BatchTaskCreateOutDTO batchTask = null;
        BatchTaskCreateInDTO2 btc = new BatchTaskCreateInDTO2();
        btc.setAppId("");
        btc.setTimeout(2000);
        btc.setTaskName("");
        btc.setTaskType("DeviceReg");
        btc.setParam("");
        try {
            batchTask = bp.createBatchTask(btc, null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return batchTask.getTaskID();
    }

    //查询指定批量任务信息
    public String queryOneTask(){
        QueryOneTaskOutDTO qoto = null;
        try {
            qoto = bp.queryOneTask("", "", "", "");
        } catch (NorthApiException e) {
            e.printStackTrace();
        }

        return qoto.getStatus();
    }

    //查询批量任务的子任务信息

    public String queryTaskDetai(){
        QueryTaskDetailsOutDTO qtdl = null;
        QueryTaskDetailsInDTO qtdli = new QueryTaskDetailsInDTO();
        qtdli.setAppId("");
        qtdli.setTaskId("");
        qtdli.setStatus("");
        qtdli.setIndex(2);
        try {
            qtdl = bp.queryTaskDetails(qtdli,"");
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        long totalCount = qtdl.getTotalCount();
        return "";
    }

}
