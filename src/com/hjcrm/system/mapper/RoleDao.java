package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 角色
     * @param deptId
     * @return
     */
    public List<Role> queryRoleByDeptId(String deptId);

    public List<Role> queryAllRole(PageBean pageBean);

    public int deleteRole(List<String> list);

    /**
     * 查询角色总数，用于分页
     * @return
     */
    public int queryAllRoleInfoCount();

    public int addOrUpdateRole(Role role);

    public int updateRole(Role role);
}

