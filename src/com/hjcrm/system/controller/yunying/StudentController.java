package com.hjcrm.system.controller.yunying;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/student/studentMang.do")
    public String studentMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.STUDENT_STUDENTMANG;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/student/excelExportStudent.do")
    public String excelExportStudent(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.STUDENT_EMAIL;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
}
