package com.hjcrm.system.service;

import com.hjcrm.system.entity.Menu;

import java.util.List;

public interface IMenuService {
    public int deleteMenu(String ids);
    /**
     * 菜单
     * @param menu
     * @return
     */
    public int addOrUpdateMenu(Menu menu);
    /**
     * 查询当前角色匹配的菜单列表
     * @param
     * @return
     */
    public List<Menu> queryMenuRoleId(String roleId);

    public int updateMenu(Menu menu);

    public List<Menu> queryAllMenu();

    public List<Menu> queryRoleMenu(String roleid);

    boolean hasSecondaryChild(String id);

    boolean hasRoles(String id);

    int deleteMenuById(String id);
}
