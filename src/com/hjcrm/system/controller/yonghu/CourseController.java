package com.hjcrm.system.controller.yonghu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Subject;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.ICourseService;
import com.hjcrm.system.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    ICourseService courseService;
    @RequestMapping("/system/courseMang.do")
    public String courseMang(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_COURSE;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/course/queryCourse.do")
    public @ResponseBody
    String queryCourse(Integer currentPage, Integer pageSize){
        //封装分页查询实体类
        if(currentPage!=null && pageSize!=null){
            System.out.println("请求课程 信息:"+pageSize+"/"+currentPage);
            PageBean pageBean=new PageBean();
            pageBean.setPageSize(pageSize);
            pageBean.setCurrentPage((currentPage-1)*pageSize);
            List<Course> list=courseService.queryCourse(pageBean);
            for (Course course:list) {
                System.out.println("查询到的课程信息:"+course);
            }
            pageBean.setCurrentPage(currentPage);
            pageBean.setCountPage(pageSize);
            //总数
            pageBean.setCountResult(courseService.queryAllCourseInfoCount());
            String roleJoin=PageBean.jsonToPage(list,pageBean);
            System.out.println("roleJoin:"+roleJoin);
            return roleJoin;
        }else{
            System.out.println("=============================");
            List<Course> list=courseService.queryCourseByid();
            String josins=PageBean.jsonToPage(list,null);
            return josins;
        }

    }
    @RequestMapping("/course/addCourse.do")
    public @ResponseBody String addCourseaddCourse(Course course){
       if(course!=null){
           if(course.getCourseid()!=0){
               System.out.println("需要修改的 Course  :"+course);
               if( courseService.updateCourse(course)>0){
                   System.out.println("修改成功");
                   return ReturnConstants.SUCCESS;
               }else{
                   System.out.println("修改失败");
               }
           }else{
               System.out.println("需要添加的 Course  :"+course);
               if( courseService.addCourse(course)>0){
                   System.out.println("添加成功");
                   return ReturnConstants.SUCCESS;
               }else{
                   System.out.println("添加失败");
               }
           }
       }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/course/deleteCourse.do")
    public @ResponseBody String deleteCourse(String courseids){
        System.out.println("需要删除的 courseids  :"+courseids);
        if( courseService.deleteCourse(courseids)>0){
            System.out.println("删除成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("删除失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
}
