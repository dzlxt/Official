package com.g0818.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminPage {

    @RequestMapping("/login")
    public String login(){
        System.out.println("login***");
         return "login";
    }

    @RequestMapping("/")
    public String index(){
        System.out.println("hello,,,,,");
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        System.out.println("index*********");
        return "admin";
    }

    @RequestMapping("/fail")
    @ResponseBody
    public String fail(){
        return "登录失败了*****/////";
    }

    @RequestMapping("/sign")
    public String sign(){ return "sign-up";}
}
