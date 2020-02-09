package com.hjcrm.system.controller.yonghu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.JsonUtil;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.service.IMenuService;
import com.hjcrm.system.service.IUserService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    IMenuService menuService;
    @Autowired
    IUserService userService;
    @RequestMapping("/system/menuMang.do")
    public String menuManger(){
        if(UserContext.getLoginUser()!=null){
            //用户登陆状态
            return JumpViewConstants.SYSTEM_MEUN_MANAGER; //handlermapping ---> /web-inf/jsp/system/courseMang.jsp
        }
        //跳回登陆页面
        return JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/menu/queryAllMenu.do")
    public @ResponseBody String queryAllMenu(Model model){
        List<Menu> menus = menuService.queryMenuRoleId(UserContext.getLoginUser().getRoleid()+"");
        String josins=PageBean.jsonToPage(menus,null);
        return josins;
    }
    @RequestMapping("/menu/addOrUpdateMenu.do")
    public @ResponseBody String addOrUpdateMenu(Menu menu){
        if(menu!=null){
            if(menu.getMenuid()!=0){
                System.out.println("修改菜单数据:"+menu);
                if (menuService.updateMenu(menu)>0){
                    System.out.println("菜单数据修改成功");
                    return ReturnConstants.SUCCESS;
                }else{
                    System.out.println("菜单数据修改失败");
                }
            }else{
                System.out.println("添加菜单数据:"+menu);
                if (menuService.addOrUpdateMenu(menu)>0){
                    System.out.println("菜单数据添加成功");
                    return ReturnConstants.SUCCESS;
                }else{
                    System.out.println("菜单数据添加失败");
                }
            }

        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/menu/delete.do")
    public @ResponseBody String deleteMenu(String ids){
        /*if(menuService.deleteMenu(ids)>0){
            System.out.println("删除成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("删除失败");
        }
        return ReturnConstants.PARAM_NULL;*/
        System.out.println("删除菜单："+ids);
        StringBuilder sb = new StringBuilder();//封装结果数据
        boolean isDelete = false;
        //1. 判断菜单是否是一级菜单
        for (String id: ids.split(",")) {
            if(menuService.hasSecondaryChild(id)){
                sb.append("当前菜单是一级菜单，存在二级菜单");
                continue;
            }
            //2. 判断菜单是否被分配
            if(menuService.hasRoles(id)){
                sb.append("此菜单已经被分配角色");
                continue;
            }
            //3. 删除菜单
            isDelete = true;
            menuService.deleteMenuById(id);
        }
        if(isDelete){
            return ReturnConstants.SUCCESS;
        }else{
            return sb.toString();
        }

    }
}
