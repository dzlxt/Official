package com.g0818.pojo.admin;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Users implements UserDetails, Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String username;
    private String password;
    private String moblephone;
    private String ID_number;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private List<Role> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoblephone(String moblephone) {
        this.moblephone = moblephone;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMoblephone() {
        return moblephone;
    }

    public String getID_number() {
        return ID_number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
