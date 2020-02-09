package com.hjcrm.system.test;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.*;
import com.hjcrm.system.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
       IStudentService studentService=app.getBean("studentService",IStudentService.class);
        Student student=new Student();
        student.setStudentId(4);
        student.setReturnNote("sssss");

      if( studentService.returnStudent(student)>0){
           System.out.println("|\\\\\\");
        }else{
           System.out.println("sssssssssssssss");
           System.out.println(student.getStudentId());
       }

      /* Student s=new Student();
       s.setUserid(42);
       s.setDeptid(0);
       s.setRoleid(42);
       s.setPageSize(5);
       s.setCurrentPage(0);
       List<Student> list=studentService.queryOnLineStudents(s);
        for (Student ss:list) {
            System.out.println("=="+ss);
        }*/
        IResourceService resourceService=app.getBean("resourceService",IResourceService.class);
       /* Resource resource=new Resource(37,42,1);
       if( resourceService.assigntoResource(resource)>0){
           System.out.println("1111111111111");
       }else {
           System.out.println("22222222222222");
       }*/


        /* Resource r=new Resource();
       r.setUserid(1);
       r.setDeptid(0);
        PageBean pb=new PageBean();
        r.setPageSize(5);
        r.setCurrentPage(1);
       List<Resource> list=resourceService.queryResource(r);
        for (Resource m : list ) {
            System.out.println("m:"+m);
        }*/
        //IUserService userService =  app.getBean("userService",IUserService.class);
        //ISystemmessageService systemmessageService=app.getBean("systemmessageService",ISystemmessageService.class);;
        //IPatterService patterService=app.getBean("patterService",IPatterService.class);
       /* IPattertypeService s=app.getBean("pattertypeService",IPattertypeService.class);
        List<Pattertype> list=s.queryPattertype();
        System.out.println("数量："+list.size());
        for (Pattertype m : list ) {
            System.out.println("m:"+m);
        }*/
        /* PageBean pb=new PageBean();
        pb.setPageSize(15);
        pb.setCurrentPage(1);*/
        /*List<Systemmessage> menuList = systemmessageService.querySystemmessage(pb);
        for (Systemmessage m : menuList ) {
            System.out.println("m:"+m);
        }*/

        /*  User user = userService.queryUserInfoByEmail("123@qq.com");
        if(user==null){
            System.out.println("账号不存在");
            return;
        }

        if(userService.queryPasswordIsExis(new User(user.getUserid(),"123123"))==null){
            System.out.println("密码不正确");
            return;
        }
        System.out.println("user:"+"登陆成功");*/

        //测试菜单
       /* IUserService userService = app.getBean("userService", IUserService.class);
        List<Menu> menuList = userService.queryMenuRoleId("35");
        for (Menu m : menuList ) {
            System.out.println("m:"+m);
        }*/
       /* PageBean pb=new PageBean();
        pb.setPageSize(5);
        pb.setCurrentPage(1);*/
        //IDeptService deptService=app.getBean("deptService",IDeptService.class);
        /*List<Dept> list=deptService.queryAllDept(pb);
        for (Dept dept:list) {
            System.out.println("dept:"+dept);
        }*/
        /*Dept dept=new Dept(0,1,"hahha","asdasd",0,null,1,null,1);
        if(deptService.addDept(dept)>0){
            System.out.println("成功");
        }else{
            System.out.println("shibai ");
        }*/
        //角色
        /*List<Role> roles=deptService.queryRoleByDeptId("2");
        for (Role s:roles) {
            System.out.println("roles:"+s);
        }*/
       //测试删除用户
        /*if(userService.deleteUser(94)>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }*/
        //测试修改用户信息
        /*User user=new User(26,"张三","123456","123456",1,1,0,1,"asdsadasdasd");
        if(userService.queryRoleByDeptid(user)>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }*/
       //System.out.println(userService.queryAllUSerInfoCount());
        //userService.addOrUpdateMenu(new Menu(-1,1,"去你的","systemManage","/system/userMang.do","glyphicon glyphicon-cog"));

//        IRoleService roleService =  app.getBean("roleService",IRoleService.class);
//        roleService.queryAllRole("pd");

      /* ISubjectService subjectService =  app.getBean("subjectService",ISubjectService.class);
        int i=subjectService.queryAllSubjectInfoCount();
        System.out.println(i);
        PageBean pb=new PageBean();
        pb.setPageSize(5);
        pb.setCurrentPage(1);
      List<Subject> list=subjectService.querySubject(pb);
        for (Subject subject: list) {
            System.out.println("subject:"+subject);
        }*/
       /* IRoleService roleService=app.getBean("roleService",IRoleService.class);
        PageBean pb=new PageBean();
        pb.setPageSize(15);
        pb.setCurrentPage(1);
        List<Role> list=roleService.queryAllRole(pb);
        for (Role role: list) {
            System.out.println("role:"+role);
        }*/
        /*ICourseService courseService =  app.getBean("courseService",ICourseService.class);
        Course course=new Course(0,"aa","aa","aa","Aa",5,"",5,null,5,null,"",5);
       if( courseService.addCourse(course)>0){
           System.out.println("添加成功");
       }else{
           System.out.println("添加失败");
       }*/
    }
}
