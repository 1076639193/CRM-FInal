package com.hjcrm.system.controller.caiwu;


import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NetWorkTrain {
    @Autowired
    IStudentService studentService;

    //网络培训费
    @RequestMapping("/matchinfo/networkTrain.do")
    public String  networkTrain(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_FINANCE_NETWORKTRAIN;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;

    }

    @RequestMapping("/matchinfo/queryNetworkEduMoneyBycaiwu.do")
    public @ResponseBody String queryNetworkEduMoneyBycaiwu(Student student,Integer currentPage,Integer pageSize ){
  /*      //封装分页查询实体类
        System.out.println("请求角色 信息:"+pageSize+"/"+currentPage);
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        List<Student> list=studentService.queryStudnetMatchs(pageBean);
        for (Student s:list) {
            System.out.println("查询到的角色信息:"+s);
        }
        pageBean.setCurrentPage(currentPage);
        pageBean.setCountPage(pageSize);
        //总数
        pageBean.setCountResult(studentService.queryAllNetworkInfoCount());
        String roleJoin=PageBean.jsonUserInfoToPage(list,pageSize,currentPage);
        System.out.println("roleJoin:"+roleJoin);
        return roleJoin;*/


        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        List<Student> list=studentService.queryStudnetMatchs(student);
        int i=list.size();
        return PageBean.jsonUserInfoToPage(list,i,currentPage);

    }

}
