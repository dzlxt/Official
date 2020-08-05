package com.g0818.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParkingFeePayment {

    @RequestMapping("/pay")
    public String payment(@RequestParam(name = "number")String number){

        return number;
    }
}
