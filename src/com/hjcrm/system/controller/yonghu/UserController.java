package com.hjcrm.system.controller.yonghu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.JsonUtil;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.IDeptService;
import com.hjcrm.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IDeptService deptService;
    @RequestMapping("/system/userMang.do")
    public String userManger(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_USER_MANAGER;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/system/userlist.do")
    /**
     * 查询用户信息列表
     */
    public @ResponseBody String queryAllUserInfo(Integer pageSize, Integer currentPage){
        if(UserContext.getLoginUser()!=null){  //用户登陆状态
            //用户登陆状态
            //查询所有用户信息
            System.out.println("请求用户 信息:"+pageSize+"/"+currentPage);
            PageBean pb=new PageBean();
            pb.setCurrentPage((currentPage-1)*pageSize);
            pb.setPageSize(pageSize);
            List<User> userList=userService.queryAllUserInfo(pb);
            /*for (User user:userList) {
                System.out.println("查询到的用户信息:"+user);
            }*/
            pb.setCurrentPage(currentPage);
            pb.setCountPage(pageSize);
            pb.setCountResult(userService.queryAllUSerInfoCount());
            String userJsonResult=JsonUtil.jsonToPage(userList,pb);

            System.out.println("userJsonResult："+userJsonResult);
            return userJsonResult;
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/system/saveOrUpdate.do")
    public @ResponseBody String saveOrUpdate(User user){
        if(user!=null){
               System.out.println("需要添加或者的用户信息："+user);
               //请求userService实现用户添加
               if(userService.saveOrUpdateUserInfo(user)>0){
                   System.out.println("成功");
               }else{
                   System.out.println("失败");
               }
               return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }

    @RequestMapping("/system/deleteUser.do")
    public @ResponseBody String deleteUser(String ids){
        System.out.println("deleteUser  userid:"+ids);

        if(userService.deleteUser(ids)>0){
            System.out.println("删除成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("删除失败");

        }
        return ReturnConstants.PARAM_NULL;
    }

}
