package com.hjcrm.system.controller.xingzheng;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BuyOnlineController {
    @Autowired
    IStudentService studentService;
    @RequestMapping("/executive/buyOnline.do")
    public String buyOnline(){

        return JumpViewConstants.EXECUTIVE_BYONLINE;
    }
    @RequestMapping("/student/queryOnLineStudents.do")
    public @ResponseBody
    String queryOnLineStudents(Student student,Integer deptid,Integer roleid,Integer currentPage, Integer pageSize){
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*pageSize);

        student.setRoleid(roleid);
        student.setDeptid(deptid);
        student.setCurrentPage(currentPage);
        student.setPageSize(pageSize);
        List<Student> list=studentService.queryOnLineStudents(student);
        return PageBean.jsonUserInfoToPage(list,5,currentPage);
    }
}
