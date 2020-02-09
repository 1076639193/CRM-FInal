package com.hjcrm.system.controller.xingzheng;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.IMatchInfoService;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MatchMoney {
    @Autowired
    IStudentService studentService;

    @Autowired
    IMatchInfoService matchInfoService;
    @RequestMapping("/executive/matchMoney.do")
    public String matchMoney(){
        return JumpViewConstants.EXECUTIVE_MATCHMONEY;
    }
    @RequestMapping("/student/queryStudnetMatchs.do")
    public @ResponseBody
    String queryStudnetMatchs(){
       List<Student> list=studentService.queryStudent();
       return PageBean.jsonToPage(list,null);
    }
    @RequestMapping("/student/queryMatchinfo.do")
    public @ResponseBody
    String queryMatchinfo(){
        List<Matchinfo> list=matchInfoService.queryMatchinfo();
        return PageBean.jsonToPage(list,null);
    }
}
