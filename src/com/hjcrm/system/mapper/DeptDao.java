package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dept;

import java.util.List;

public interface DeptDao {
    public List<Dept> queryAllDeptByid();
    public List<Dept> queryAllDept(PageBean pageBean);
    public int queryAllDeptInfoCount();
    public int addDept(Dept dept);
    public int deleteDept(List<String> list);
    public int updateDept(Dept dept);
}

