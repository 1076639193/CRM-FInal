package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {
	public User queryUserInfoByEmail(String email);
	public List<User> queryAllUser();
	public User queryPasswordIsExis(User user);
	/**
	 * 查询用户信息列表
	 * @param pb
	 * @return
	 */
	public List<User> queryAllUserInfo(PageBean pb);

	public int saveOrUpdateUserInfo(User user);

	public int deleteUser(List<String> list);
	public int queryRoleByDeptid(User user);
	public int queryAllUSerInfoCount();

}
