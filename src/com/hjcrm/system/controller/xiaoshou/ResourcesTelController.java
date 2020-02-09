package com.hjcrm.system.controller.xiaoshou;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.IResourceService;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ResourcesTelController {
    @Autowired
    IResourceService service;
    @Autowired
    IStudentService studentService;
    @Autowired
    IResourceService resourceService;
    @RequestMapping("/sales/resourcesTelMang.do")
    public String resourcesTelMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_SALE_TELAMOUNT;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }

    @RequestMapping("/resource/details.do")
    public String details(Resource resource, Model model) {
        if (UserContext.getLoginUser() != null) {
            Resource resource1 = service.queryResourceById(resource);
            System.out.println("ssss"+resource1);
            List<Resource> list = new ArrayList<Resource>();
            list.add(resource1);
            model.addAttribute("resource", list);
            return JumpViewConstants.SYSTEM_SALE_DETAILS;
        }
        return JumpViewConstants.SYSTEM_LOGIN ;
    }
    @RequestMapping("/resource/addDealrecord.do")
    public @ResponseBody String addDealrecord(Dealrecord dealrecord) {
        if(studentService.addDealrecord(dealrecord)>0){
            if(studentService.addstudent(dealrecord)>0){
                System.out.println("学院添加成功");
            }else{
                System.out.println("学院添加失败");
            }
            if(resourceService.updateByresorceIdState(dealrecord)>0){
                System.out.println("修改状态成功");
            }else{
                System.out.println("修改状态失败");
            }
            System.out.println("sssssss"+dealrecord);
            System.out.println("添加成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("添加失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/student/returnStudent.do")
    public @ResponseBody String returnStudent(Student student,Integer studentIds) {
        student.setStudentId(studentIds);
        if(studentService.returnStudent(student)>0){
            System.out.println("退回成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("退回失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
   /* @RequestMapping("/student/returnStudent.do")
    public @ResponseBody String returnStudent(Student student,Integer studentIds) {
        student.setStudentId(studentIds);
        if(studentService.returnStudent(student)>0){
            System.out.println("退回成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("退回失败");
        }
        return ReturnConstants.PARAM_NULL;
    }*/
    @RequestMapping("/student/studentCommit.do")
    public @ResponseBody String studentCommit(Integer studentIds) {

        if(studentService.studentCommit(studentIds)>0){
            System.out.println("提交成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("提交失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
    /*public @ResponseBody
    String details(Integer userid, Integer deptid, Integer resourceId, Integer roleid, HttpSession session){
        Resource resource1=new Resource();
        resource1.setUserid(userid);
        resource1.setResourceId(resourceId);
        resource1.setDeptid(deptid);
        Resource resource=service.queryResourceById(resource1);
        System.out.println("sssssssssssss"+resource);
        session.setAttribute("resource",resource);

        //return PageBean.jsonToPage(resource1,null);
        return JumpViewConstants.SYSTEM_SALE_DETAILS;
    }*/
}
