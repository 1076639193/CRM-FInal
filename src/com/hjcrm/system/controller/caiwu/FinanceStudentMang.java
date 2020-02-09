package com.hjcrm.system.controller.caiwu;


import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//总表成员
@Controller
public class FinanceStudentMang {
    @Autowired
    StudentService studentService;

    @RequestMapping("/finance/financeStudentMang.do ")
    public String  financeStudentMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_FINANCE_DINANCESTUDENTMANG;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;

    }

    @RequestMapping("/report/queryStudentscaiwu.do")
    public @ResponseBody String queryStudentscaiwu(){
        PageBean pageBean =new PageBean();
        List<Student> list =studentService.queryStudentscaiwu();
        String jsonResult =PageBean.jsonToPage(list,null);
        return jsonResult;
    }




}
