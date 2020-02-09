package com.hjcrm.system.controller.yonghu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.JsonUtil;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.IDeptService;
import com.hjcrm.system.service.IUserService;
import com.hjcrm.system.service.impl.DeptServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Retention;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    IDeptService deptService;
    @RequestMapping("/system/deptMang.do")
    public String deptManger(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_DEPT_MANAGER;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }

    /**
     * 查询部门列表
     * @return
     */
    @RequestMapping("/dept/queryDept.do")
    public @ResponseBody String queryAllDept(Integer pageSize, Integer currentPage){
        if(pageSize!=null && currentPage!=null){
            //1.使用DEptService 查询实现部门查询业务操作
            PageBean pageBean = new PageBean();
            pageBean.setCurrentPage((currentPage-1)*pageSize);
            pageBean.setPageSize(pageSize);
            List<Dept> depts=deptService.queryAllDept(pageBean);
            pageBean.setCurrentPage(currentPage);
            pageBean.setCountPage(pageSize);
            //总数
            pageBean.setCountResult(deptService.queryAllDeptInfoCount());
            //2.将查询到的数据封装成json数据返回
            String roleJson = PageBean.jsonToPage(depts,pageBean);

            System.out.println("部门信息："+roleJson);
            return roleJson;
        }else{
            List<Dept> depts=deptService.queryAllDeptByid();
            String roleJson = PageBean.jsonToPage(depts,null);
            System.out.println("部门信息："+roleJson);
            return roleJson;
        }
    }
    /**
     * 查询部门下所有角色
     * @returnqueryAllDeptByid
     */
    @RequestMapping("/role/queryRoleByDeptid.do")
    public @ResponseBody String queryRoleByDeptId(String deptid,User user){
        if(StringUtils.isNotBlank(deptid)){
            //查询属于当前部门下的所有角色
            List<Role> roles=deptService.queryRoleByDeptId(deptid);
            String JosinRole=PageBean.jsonToPage(roles,null);
            return JosinRole;
        }
        return ReturnConstants.PARAM_NULL;

    }
    @RequestMapping("/dept/saveOrUpdate.do")
    public @ResponseBody String saveOrUpdate(Dept dept){
            //根据id 判断添加还是修改
               if(dept.getDeptid()>0){
                   if(deptService.updateDept(dept)>0){
                       System.out.println("修改成功");
                      return ReturnConstants.SUCCESS;
                   }else{
                       System.out.println("修改失败");
                   }
               }else {
                   if (deptService.addDept(dept) > 0) {
                       System.out.println("添加成功");
                       return ReturnConstants.SUCCESS;
                   } else {
                       System.out.println("添加失败");
                   }
               }

        return ReturnConstants.SUCCESS;
       // return ReturnConstants.PARAM_NULL;
    }
    /**
     * 删除部门
     * @returnqueryAllDeptByid
     */
    @RequestMapping("/dept/delete.do")
    public @ResponseBody String deleteDept(String ids){
        if(ids!=null){
            if (deptService.deleteDept(ids)> 0) {
                System.out.println("删除成功");
                return ReturnConstants.SUCCESS;
            } else {
                System.out.println("添加失败");
            }
        }
        return ReturnConstants.PARAM_NULL;

    }
}
