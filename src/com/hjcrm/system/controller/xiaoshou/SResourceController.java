package com.hjcrm.system.controller.xiaoshou;

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
public class SResourceController {
    @Autowired
    IStudentService studentService;

    @RequestMapping("/sales/resourcesMang.do")
    public String sresourcesMang(){
        return JumpViewConstants.RESOURCE_SRESOURCESMANG;
    }



}
