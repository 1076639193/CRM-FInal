package com.hjcrm.system.controller.yonghu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.*;
import com.hjcrm.system.service.ISystemmessageService;
import com.hjcrm.system.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SystemMessageController {
    @Autowired
    ISystemmessageService systemmessageService;
    @RequestMapping("/system/systemMessage.do")
    public String systemMessage(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_MESSAGE;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/system/querySystemmessages.do")
    public @ResponseBody
    String queryCourse(Integer currentPage, Integer pageSize){
        //封装分页查询实体类
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        List<Systemmessage> depts=systemmessageService.querySystemmessage(pageBean);
        //2.将查询到的数据封装成json数据返回
        pageBean.setCurrentPage(currentPage);
        pageBean.setCountPage(pageSize);
        //总数
        pageBean.setCountResult(systemmessageService.queryAllSystemmessageCount());
        String roleJson = PageBean.jsonToPage(depts,pageBean);

        System.out.println("部门信息："+roleJson);
        return roleJson;
    }
    @RequestMapping("/system/saveOrUpdateMessage.do")
    public @ResponseBody
    String saveOrUpdateMessage(Systemmessage systemmessage){
       if(systemmessage.getSystemmessageId()!=0){
           //修改
           if(systemmessageService.updateSystemmessage(systemmessage)>0){
               System.out.println("成功");
               return ReturnConstants.SUCCESS;
           }else{
               System.out.println("失败");
           }
       }else{
            if(systemmessageService.addSystemmessage(systemmessage)>0){
                System.out.println("添加成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("添加失败");
            }
       }
       return ReturnConstants.PARAM_NULL;
    }

    /**
     * 修改发布信息   江1编程0
     * @param
     * @return
     */
    @RequestMapping("/system/sendMessage.do")
    public @ResponseBody
    String sendMessage(Systemmessage systemmessage){
        if(systemmessage.getSystemmessageId()!=0){
           if(systemmessageService.updateSystemmessageByid(systemmessage)>0){
               System.out.println("发布成功");
               return ReturnConstants.SUCCESS;
           }else{
               System.out.println("发布失败");
           }
        }else{
            return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }
}
