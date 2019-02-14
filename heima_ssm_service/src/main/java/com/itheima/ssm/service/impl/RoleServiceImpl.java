package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }

    /**
     * 调用IRoleService的findOtherRole方法用于获取可以添加的角色信息
     * @param id
     * @return
     */
    @Override
    public List<Role> findOtherRole(String id) {
        return iRoleDao.findOtherRole(id);
    }

    @Override
    public Role findById(String roleId) {
        return iRoleDao.findById(roleId);
    }


    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return iRoleDao.findOtherPermission(roleId);
    }
}
