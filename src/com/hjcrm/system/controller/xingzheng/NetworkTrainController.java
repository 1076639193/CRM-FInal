package com.hjcrm.system.controller.xingzheng;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NetworkTrainController {
    @Autowired
    IStudentService studentService;
    @RequestMapping("/executive/networkTrain.do")
    public String networkTrain(){

        return JumpViewConstants.EXECUTIVE_NETWORKTRAIN;
    }
    @RequestMapping("/student/commit_caiwu.do")
    public String commit_caiwu(Integer studentIds){
        if(studentService.commit_caiwu(studentIds)>0){
            System.out.println("提交成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("提交失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/student/queryNetworkEduMoney.do")
    public @ResponseBody
    String queryNetworkEduMoney(Integer pageSize, Integer currentPage,Student student){
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        List<Student> list=studentService.queryStudnetMatchs(student);
        int i=list.size();
        return PageBean.jsonUserInfoToPage(list,i,currentPage);
    }

}
