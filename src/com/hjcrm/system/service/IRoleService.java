package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.Role_menu;

import java.util.List;

public interface IRoleService {
    public List<Role> queryAllRole(PageBean pageBean);
    public int deleteRole(String ids);
    public int addOrUpdateRole(Role role);
    public int queryAllRoleInfoCount();
    public int updateRole(Role role);
    public int addRoleAndMenu(Role_menu role_menu);
}
