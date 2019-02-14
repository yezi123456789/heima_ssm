package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    List<Role> findOtherRole(String id);

    Role findById(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);

    List<Permission> findOtherPermission(String roleId);
}
