package com.hjcrm.system.service.impl;

import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.mapper.MenuDao;
import com.hjcrm.system.service.IMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Autowired
    MenuDao menuDao;
    @Override
    public int deleteMenu(String ids) {
        List<String> list=new ArrayList<>();
        if(StringUtils.isNotBlank(ids)){

            for (String id: ids.split(",")) {
                list.add(id);
            }
        }
        return menuDao.deleteMenu(list);
    }
    @Override
    public int addOrUpdateMenu(Menu menu) {
        return menuDao.addOrUpdateMenu(menu);
    }
    @Override
    public List<Menu> queryMenuRoleId(String roleId) {
        //1.查询当前用户的角色所具有的所有一级菜单
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("roleid",roleId);
        hashMap.put("menuparaid","-1");
        List<Menu> menus = menuDao.queryMenuByRoleId(hashMap);
        System.out.println("list menus"+menus);
        //2.查询当前一级菜单的二级菜单
        for (Menu  m: menus) {
            HashMap<String,String> hashMap2 = new HashMap<String,String>();
            hashMap2.put("roleid",roleId);
            hashMap2.put("menuparaid",m.getMenuid()+"");

            //hashMap.put("menuparaid",m.getMenuid()+"");
            //List<Menu> sonMenu = menuDao.queryAllMenu(hashMap);
            List<Menu> menusSecondary = menuDao.queryMenuByRoleId(hashMap2);
            m.setChildren(menusSecondary);  // 将查询到的二级菜单添加到一级菜单上
        }
        return menus;
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

    @Override
    public List<Menu> queryAllMenu() {
        HashMap<String,String> paramMap=new HashMap<>();
        paramMap.put("menuparaid","-1");
        List<Menu> paramMenu=menuDao.queryMenuByRoleId(paramMap);
        for (Menu menu:paramMenu) {
            paramMap.put("menuparaid",menu.getMenuid()+"");
            List<Menu>  sonMenu=menuDao.queryMenuByRoleId(paramMap);
            menu.setChildren(sonMenu);
        }
        return paramMenu;
    }

    @Override
    public List<Menu> queryRoleMenu(String roleid) {
        HashMap<String,String> paramMap=new HashMap<>();
        paramMap.put("roleid",roleid);
        List<Menu> menus=menuDao.queryMenuByRoleId(paramMap);
        return menus;
    }

    @Override
    public boolean hasSecondaryChild(String id) {
        return menuDao.hasSecondaryChild(Integer.parseInt(id)).size()>0?true:false;
    }

    @Override
    public boolean hasRoles(String id) {
        return menuDao.hasRoles(Integer.parseInt(id)).size()>0?true:false;
    }

    @Override
    public int deleteMenuById(String id) {
        return menuDao.deleteMenuById(Integer.parseInt(id));
    }
}
