package com.g0818.service;

import com.g0818.mapper.UserMapper;
import com.g0818.pojo.admin.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(" 用户名是"+s);
        Users u = userMapper.findByUsername(s);
        if(null != u) {
            String name = u.getUsername();
            String pwd = u.getPassword();
            System.out.println(u.getUsername()+u.getAuthorities());
            UserDetails user = User.withUsername(name).password(pwd).roles("admin").build();
            return user;
        }
        return null;
    }

    /**
     * 认证  用户登入会先被拦截到这个页面
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */


}