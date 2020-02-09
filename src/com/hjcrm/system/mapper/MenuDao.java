package com.hjcrm.system.mapper;


import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role_menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MenuDao {
	public List<Menu> queryMenuByRoleId(HashMap<String,String> hashMap);

	public int addOrUpdateMenu(Menu menu);

	public int deleteMenu(List<String> list);

	public int updateMenu(Menu menu);
	/**
	 * 查询所有菜单
	 * @param hashMap
	 * @return
	 */
	public List<Menu> queryAllMenu(HashMap<String,String> hashMap);

	/**
	 * 是否存在下一级菜单
	 * @param id
	 * @return
	 */
	List<Menu> hasSecondaryChild(int id);

	/**
	 * 是否被分配
	 * @param id
	 * @return
	 */
	List<Role_menu> hasRoles(int id);

	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	int deleteMenuById(int id);
}
