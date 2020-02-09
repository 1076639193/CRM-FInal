package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.mapper.DeptDao;
import com.hjcrm.system.mapper.RoleDao;
import com.hjcrm.system.service.IDeptService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("deptService")
public class DeptServiceImpl implements IDeptService {
    @Autowired
    DeptDao deptDao;
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Dept> queryAllDeptByid() {
        return deptDao.queryAllDeptByid();
    }

    @Override
    public List<Role> queryRoleByDeptId(String deptId) {
        System.out.println("===================================");
        System.out.println("deptId"+deptId);
        return roleDao.queryRoleByDeptId(deptId);
    }

    @Override
    public List<Dept> queryAllDept(PageBean pageBean) {
        return deptDao.queryAllDept(pageBean);
    }

    @Override
    public int queryAllDeptInfoCount() {
        return deptDao.queryAllDeptInfoCount();
    }

    @Override
    public int addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public int deleteDept(String deptids) {
        List<String> list=new ArrayList<>();
        if(StringUtils.isNotBlank(deptids)){

            for (String id:deptids.split(",")) {
                list.add(id);
            }
        }
        return deptDao.deleteDept(list);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }


}
