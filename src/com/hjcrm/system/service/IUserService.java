package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    public User queryUserInfoByEmail(String email);

    /**
     * 查询密码是否匹配
     * @param user
     * @return
     */
    public User queryPasswordIsExis(User user);



    public List<User> queryAllUserInfo(PageBean pb);

    public int saveOrUpdateUserInfo(User user);

    /**
     * 删除管理下的用户
     * @param userid
     * @return
     */
    public int deleteUser(String ids);



    public int queryAllUSerInfoCount();

    //public int saveOrUpdateUserInfo(User user);
    public List<User> queryAllUser();

}
