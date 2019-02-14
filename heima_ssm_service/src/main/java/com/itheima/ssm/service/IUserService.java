package com.itheima.ssm.service;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface IUserService extends UserDetailsService{


    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id) throws Exception;

    void addRoleToUser(String userId, String[] ids);
}
