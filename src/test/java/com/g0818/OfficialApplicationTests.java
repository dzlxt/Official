package com.g0818;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.g0818.mapper.UserMapper;
import com.g0818.pojo.admin.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafTemplateAvailabilityProvider;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class OfficialApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void testBcrypt(){
        String pwd = BCrypt.hashpw("654321",BCrypt.gensalt());
        //QueryWrapper qe = new QueryWrapper();
        //qe.eq("username","lxt");
        Users user = new Users();
        user.setUsername("admin");
        user.setPassword(pwd);
        user.setMoblephone("18081516663");
        userMapper.insert(user);
        System.out.println(pwd);
    }



}
