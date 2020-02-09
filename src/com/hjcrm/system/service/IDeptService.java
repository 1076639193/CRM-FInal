package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Role;

import java.util.List;

public interface IDeptService {

    /**
     * 查询所有部门
     */
    public List<Dept> queryAllDeptByid();

    public List<Role> queryRoleByDeptId(String deptId);

    public List<Dept> queryAllDept(PageBean pageBean);

    public int queryAllDeptInfoCount();
    public int addDept(Dept dept);
    public int deleteDept(String deptids);
    public int updateDept(Dept dept);
}
