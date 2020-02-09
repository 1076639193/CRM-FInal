package com.hjcrm.system.controller.yonghu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.IUserService;
import com.hjcrm.system.service.impl.MenuServiceImpl;
import com.hjcrm.system.service.impl.RoleService;
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
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuServiceImpl menuService;
    /**
     * 获取角色页面
     * @return
     */
    @RequestMapping("/system/roleMang.do")
    public String roleManger(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_ROLE_MANAGER;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    /*@RequestMapping("/role/queryAllRole.do")
    public @ResponseBody
    String queryAllRole(Integer currentPage, Integer pageSize){
        //封装分页查询实体类
        System.out.println("请求角色 信息:"+pageSize+"/"+currentPage);
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        List<Role> list=roleService.queryAllRole(pageBean);
        for (Role role:list) {
            System.out.println("查询到的角色信息:"+role);
        }
        pageBean.setCurrentPage(currentPage);
        pageBean.setCountPage(pageSize);
        //总数
        pageBean.setCountResult(roleService.queryAllRoleInfoCount());
        String roleJoin=PageBean.jsonUserInfoToPage(list,pageSize,currentPage);
        System.out.println("roleJoin:"+roleJoin);
        return roleJoin;
    }*/
    @RequestMapping("/role/queryAllRole.do")
    public @ResponseBody
    String queryAllRole(Integer currentPage,Integer pageSize) {
        //封装分页查询实体类
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询数据
        List<Role> roleList = roleService.queryAllRole(pageBean);

        //设置返回分页数据的json字符串（三个key:  countResult,total,rows）

        String roleJson = PageBean.jsonUserInfoToPage(roleList,55,currentPage);

        System.out.println("角色信息："+roleJson);
        return roleJson;
    }
    @RequestMapping("/role/deleteRole.do")
    public @ResponseBody String deleteRole(String ids){
        System.out.println("deleteRole  userid:"+ids);

        if(roleService.deleteRole(ids)>0){
            System.out.println("deleteRole删除成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("deleteRole删除失败");

        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/role/addOrUpdateRole.do")
    public @ResponseBody String addOrUpdateRole(Role role){
        System.out.println("Role  :"+role);
        if(role!=null){
            if(role.getRoleid()!=0){
                if(roleService.updateRole(role)>0){
                    System.out.println("UpdateRole修改成功");
                    return ReturnConstants.SUCCESS;
                }else{
                    System.out.println("UpdateRole修改失败");

                }
            }else{
                if(roleService.addOrUpdateRole(role)>0){
                    System.out.println("addOrUpdateRole添加成功");
                    return ReturnConstants.SUCCESS;
                }else{
                    System.out.println("addOrUpdateRole添加失败");

                }
            }
        }
        return ReturnConstants.PARAM_NULL;
    }

    /**
     *
     */
    @RequestMapping("/rolemenu/queryAllMenuAndSelected.do")
    public @ResponseBody String queryAllMenuAndSelected(String roleid){
        //1. 查询所有菜单（按照等级划分：children）
        List<Menu> listMenu = menuService.queryAllMenu();

        //2. 查询所有用户角色拥有的菜单
        List<Menu> listMenuRole = menuService.queryRoleMenu(roleid);
        //变量菜单设置选中状态
        if(listMenuRole!=null && listMenuRole.size()>0){
            for (int i = 0; i < listMenu.size(); i++) {
                //遍历所有菜单

                for (int j = 0; j < listMenuRole.size(); j++) {
                    //遍历所有用户选择的菜单
                    if (listMenuRole.get(j) != null) {
                        if (listMenuRole.get(j).getMenuid() == listMenu.get(i).getMenuid()) {
                            //定位到用户已经拥有的菜单
                            listMenu.get(i).setSelected(true);
                            break;
                        }
                    }

                }
            }
            //循环遍历二级菜单，设置选中状态
            for (int i = 0; i < listMenu.size(); i++) {
                List<Menu> secondaryMenuList = listMenu.get(i).getChildren();
                if (secondaryMenuList != null && secondaryMenuList.size() > 0) {
                    //遍历二级
                    for (int j = 0; j < secondaryMenuList.size(); j++) {
                        for (int z = 0; z < listMenuRole.size(); z++) {
                            //遍历所有用户选择的菜单
                            if (listMenuRole.get(z) != null) {
                                if (listMenuRole.get(z).getMenuid() == secondaryMenuList.get(j).getMenuid()) {
                                    //定位到用户已经拥有的菜单
                                    secondaryMenuList.get(j).setSelected(true);//设置二级菜单
                                    break;
                                }
                            }

                        }
                    }
                }
            }
           /* for (int i=0;i<listMenu.size();i++){
                List<Menu> secondaryMenuList=listMenu.get(i).getChildren();
                for (int j=0;j<secondaryMenuList.size();j++){
                    for (int z=0;z<listMenuRole.size();z++){
                        if(listMenuRole.get(z).getMenuid()==secondaryMenuList.get(j).getMenuid()){
                            secondaryMenuList.get(j).setSelected(true);
                            break;
                        }
                    }
                }
            }*/
        }
        return PageBean.jsonToPage(listMenu,null);
    }
}
