package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import com.itheima.ssm.utils.EncodingPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = iUserDao.findByUsername(username);
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> list = getAuthority(roles);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true, true, true, true, list);
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authoritys;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return iUserDao.findAll();
    }

    /**
     * 添加用户
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(EncodingPassword.encodePassword(userInfo.getPassword()));
        iUserDao.save(userInfo);
    }

    /**
     * 根据id查找用户的信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(String id) throws Exception {
        return iUserDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            iUserDao.addRoleToUser(userId,id);
        }

    }
}
