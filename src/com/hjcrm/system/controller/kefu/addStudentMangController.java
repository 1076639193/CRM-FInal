package com.hjcrm.system.controller.kefu;


import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addStudentMangController {
    @RequestMapping("/custom/addStudentMang.do")
    public String addStudentMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_CUSTOM_ADDSTUDENTMANG;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }

}
