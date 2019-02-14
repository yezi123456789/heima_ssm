package com.itheima.ssm.dao;

import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {


    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId")) })
    public UserInfo findById(String  id) throws Exception;

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId")) })
    public UserInfo findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users (email,username,password,phoneNum,status) values(#{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    public void save(UserInfo userInfo);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String ids);
}
