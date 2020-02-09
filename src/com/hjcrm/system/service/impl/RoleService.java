package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.Role_menu;
import com.hjcrm.system.mapper.RoleDao;
import com.hjcrm.system.service.IRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Service("roleService")
public class RoleService implements IRoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> queryAllRole(PageBean pageBean) {
        pageBean.setCurrentPage(pageBean.getPageSize()*(pageBean.getCurrentPage()-1));
        //pageBean.setCurrentPage( pageBean.getPageSize()*(pageBean.getCurrentPage()-1));//将页码变为分页起始位置
       // System.out.println(" queryAllRole  :"+pageBean);
        return roleDao.queryAllRole(pageBean);
    }

    @Override
    public int deleteRole(String ids) {
        List<String> list=new ArrayList<>();
        if(StringUtils.isNotBlank(ids)) {
            for (String id: ids.split(",")) {
                list.add(id);
            }
        }
        return roleDao.deleteRole(list);
    }

    @Override
    public int addOrUpdateRole(Role role) {
        return roleDao.addOrUpdateRole(role);
    }

    @Override
    public int queryAllRoleInfoCount() {
        return roleDao.queryAllRoleInfoCount();
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int addRoleAndMenu(Role_menu role_menu) {
        return 0;
    }
}
