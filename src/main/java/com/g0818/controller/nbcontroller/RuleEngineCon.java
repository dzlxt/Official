package com.g0818.controller.nbcontroller;


import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.RuleEngine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
*  规则管理
* 第三方应用根据具体的业务需要，制定规则的条件和动作，当设备的状态满足设定条
件后，触发相应的操作
* */
@Controller
public class RuleEngineCon {

   RuleEngine re = new RuleEngine();
   RuleDTO2 ruleDTO = new RuleDTO2();
   public String  createRule(){

       RuleCreateOrUpdateOutDTO rule;
       ruleDTO.setRuleId("");
       ruleDTO.setName("");
       ruleDTO.setAuthor("");
       //ruleDTO.setActions();
       try {
           rule = re.createRule(ruleDTO,null,null);
       } catch (NorthApiException e) {
           e.printStackTrace();
       }
       return "";
   }

   public String updateRule(){

       RuleCreateOrUpdateOutDTO rCOUO = null;
       ruleDTO.setRuleId("");
       ruleDTO.setName("");
       ruleDTO.setAuthor("");
       //ruleDTO.setActions();
       try {
           rCOUO = re.updateRule(ruleDTO,null,null);
       } catch (NorthApiException e) {
           e.printStackTrace();
       }
       return rCOUO.getRuleId();
   }

    // 删除规则
   public String deleteRule(){
       try {
           re.deleteRule("","","");
       } catch (NorthApiException e) {
           e.printStackTrace();
       }
       return "";
   }


    // 查找规则
   public String  queryRules(){
       List<RuleDTO2> rlist;
       QueryRulesInDTO2 qrInDTO = new QueryRulesInDTO2();
       qrInDTO.setAuthor("");
       try {
           rlist=re.queryRules(qrInDTO,null);
       } catch (NorthApiException e) {
           e.printStackTrace();
       }
       return "";
   }

   /*修改规则状态
   * 第三方应用通过“创建规则”接口在物联网平台创建规则时，可设置规则的状态为
    active（启用）或 inactive（停用），后续若需要启用或者停用某个规则，可调用此接
    口修改规则的激活状态。
   *
   * */
    public String updateRuleStatus(){
        UpdateRuleStatusInDTO ursindto =new UpdateRuleStatusInDTO();
        ursindto.setRuleId("");
        ursindto.setStatus("");
        try {
            re.updateRuleStatus(ursindto,null,null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
    * 批量修改规则状态
    *第三方应用通过“创建规则”接口在物联网平台创建规则时，可设置规则的状态为
    *active（启用）或 inactive（停用），后续若需要同时启用或者停用多个规则，可调用
    *此接口批量修改规则的激活状态。
    * */
    @RequestMapping
    public String  updateBatchRuleStatus(Model model){
        UpdateBatchRuleStatusInDTO ubrsi = new UpdateBatchRuleStatusInDTO();
        List<UpdateRuleStatusInDTO> urlsi = null;
        UpdateRuleStatusInDTO url = new UpdateRuleStatusInDTO();
        url.setStatus("");
        url.setRuleId("");
        urlsi.add(url);
        url.setStatus("");
        url.setRuleId("");
        urlsi.add(url);
        ubrsi.setRequests(urlsi);
        UpdateBatchRuleStatusOutDTO sOutDTO = null;
        try {
            sOutDTO = re.updateBatchRuleStatus(ubrsi, null, null);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        List<RuleResponseBodyDTO> responses = sOutDTO.getResponses();
        for (RuleResponseBodyDTO dto:responses){
            model.addAttribute(dto);
        };
        return "";
    }
}
