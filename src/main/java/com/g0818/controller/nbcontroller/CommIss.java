package com.g0818.controller.nbcontroller;


import com.g0818.Util.AuthUtil;
import com.g0818.Util.SignalDeliveryUtil;
import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.dto.PostDeviceCommandOutDTO2;
import com.iotplatform.client.invokeapi.SignalDelivery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//命令下发类
@Controller
public class CommIss {

    @RequestMapping("/cmd")
    public String unlock(@RequestParam(name ="dev")String dev){
        NorthApiClient nac = AuthUtil.initApiClient();
        SignalDelivery sd = new SignalDelivery(nac);
        String token = AuthUtil.getaccessToken();
        System.out.println(token);
        PostDeviceCommandOutDTO2 post = SignalDeliveryUtil.postCommand(sd, dev, token);
        String status =post.getStatus();
        return status;
    }
}
