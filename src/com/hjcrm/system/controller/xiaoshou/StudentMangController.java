package com.hjcrm.system.controller.xiaoshou;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentMangController {
    @Autowired
    IStudentService studentService;
    @RequestMapping("/sales/studentMang.do")
    public String studentMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SALES_STUDENTMANG;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/student/studentDetails.do")
    public String studentDetails(Student student, Model model){
        List<Student> list=studentService.queryStudentById(student);
        for (Student s:list) {
            System.out.println("sssssss"+s);
        }
        model.addAttribute("student",list);
        return JumpViewConstants.SYSTEM_SALE_STUDENTDETAILS;
    }

}
