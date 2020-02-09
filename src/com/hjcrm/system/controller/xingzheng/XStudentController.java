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
public class XStudentController {
    @Autowired
    IStudentService studentService;
    @RequestMapping("/executive/studentMang.do")
    public String studentMang(){
        return JumpViewConstants.EXECUTIVE_STUDENTMANG;
    }
    @RequestMapping("/student/queryStudents.do")
    public @ResponseBody
    String queryStudents(Student student,Integer currentPage, Integer pageSize){
        List<Student> list=studentService.queryStudnetMatchs(student);
        int i=list.size();
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        return PageBean.jsonUserInfoToPage(list,i,currentPage);
    }
}
