package com.g0818.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.g0818.pojo.admin.Permission;
import com.g0818.pojo.admin.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<Users> {

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    @Select(" select * from users where username = #{username}")
    Users findByUsername(@Param("username") String username);


    /**
     * 查询用户的权限
     * @param userName
     * @return
     */
    @Select(" select permission.* from sys_user user" + " inner join sys_user_role user_role"
            + " on user.id = user_role.user_id inner join "
            + "sys_role_permission role_permission on user_role.role_id = role_permission.role_id "
            + " inner join sys_permission permission on role_permission.perm_id = permission.id where user.username = #{userName};")
    List<Permission> findPermissionByUsername(@Param("userName") String userName);
}
