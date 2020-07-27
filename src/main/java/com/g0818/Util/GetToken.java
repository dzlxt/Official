package com.g0818.Util;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.invokeapi.SignalDelivery;
import org.springframework.stereotype.Component;

@Component
public  class GetToken {

    public static String gettoken(){
        NorthApiClient nac = AuthUtil.initApiClient();
        return AuthUtil.getaccessToken();
    }
}
