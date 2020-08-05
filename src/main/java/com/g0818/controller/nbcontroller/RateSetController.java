package com.g0818.controller.nbcontroller;

import com.g0818.mapper.ChargingStandardMapper;
import com.g0818.pojo.ChargingStandard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RateSetController {

    @Autowired
    ChargingStandardMapper chargingStandardMapper;

    @RequestMapping("/setRate")
    public String setRate(@RequestParam(value = "day")int day,
                          @RequestParam(value = "hour")int hour){
        ChargingStandard chargingStandard = new ChargingStandard(1,15,30,20,30,60);
        chargingStandardMapper.updateById(chargingStandard);
        return "费率设置成功";
    }
}
