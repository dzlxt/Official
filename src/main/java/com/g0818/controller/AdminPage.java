package com.g0818.controller;

import com.g0818.mapper.UserMapper;
import com.g0818.pojo.admin.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminPage {

    @Autowired
    UserMapper userMapper;


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

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(@RequestParam(value = "username")String name,
                      @RequestParam(value = "mobliephone")String mobliephone,
                      @RequestParam(value = "idcar")String idcar,
                      @RequestParam(value = "password")String password,
                      @RequestParam(value = "rpassword")String rpassword
    )
    {
        String a=null;
        if(password.equals(rpassword)) {
            String pwd = BCrypt.hashpw(password, BCrypt.gensalt());
            Users u = new Users();
            u.setUsername(name);
            u.setMoblephone(mobliephone);
            u.setIdcar(idcar);
            u.setPassword(pwd);
            userMapper.insert(u);
            a= "注册成功";
        }else {
            a= "两次密码不相符";
        }
        return a;
    }
}
