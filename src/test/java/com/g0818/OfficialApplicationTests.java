package com.g0818;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.g0818.mapper.UserMapper;
import com.g0818.pojo.admin.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
        String pwd = BCrypt.hashpw("123456",BCrypt.gensalt());
        QueryWrapper qe = new QueryWrapper();
        qe.eq("username","lxt");
        Users user = new Users();
        user.setUsername("lxt");
        user.setPassword(pwd);
        userMapper.update(user,qe);
        System.out.println(pwd);
    }

}
