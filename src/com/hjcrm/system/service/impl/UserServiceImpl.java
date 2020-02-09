package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.mapper.MenuDao;
import com.hjcrm.system.mapper.UserDao;
import com.hjcrm.system.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Autowired
    MenuDao menuDao;

    @Override
    public User queryUserInfoByEmail(String email) {
        try {
            User user =  userDao.queryUserInfoByEmail(email);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User queryPasswordIsExis(User user) {
        try {
            User user2 = userDao.queryPasswordIsExis(user);
            return user2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> queryAllUserInfo(PageBean pb) {
        return userDao.queryAllUserInfo(pb);
    }

    @Override
    public int saveOrUpdateUserInfo(User user) {
        if(user!=null){
            if (user.getUserid()!=0){
                System.out.println("修改");
                userDao.queryRoleByDeptid(user);
            }else{
                System.out.println("添加");
                return userDao.saveOrUpdateUserInfo(user);
            }
        }
        return 0;
    }

    @Override
    public int deleteUser(String ids) {
        /**

         */
        List<String> list=new ArrayList<>();
        if(StringUtils.isNotBlank(ids)){

            for (String id: ids.split(",")) {
                list.add(id);
            }
        }
        return userDao.deleteUser(list);
    }




    @Override
    public int queryAllUSerInfoCount() {
        return userDao.queryAllUSerInfoCount();
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }


}
