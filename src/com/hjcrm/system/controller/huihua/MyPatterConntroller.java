package com.hjcrm.system.controller.huihua;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.service.IPatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyPatterConntroller {
    @Autowired
    IPatterService patterService;
    @RequestMapping("/patter/myPatter.do")
    public String myPatter(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.PATTER_MYPATTER;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
    @RequestMapping("/patter/queryPattertype.do")
    public @ResponseBody String queryPattertype(Patter patter){
        if(patter.getUserid()!=0){
            System.out.println("userid"+patter.getUserid());
            System.out.println("courseid"+patter.getCourseid());
            List<Patter> list=patterService.queryPatter(patter.getUserid(),patter.getCourseid());
            System.out.println("size:"+list.size());
            //String roleJson = PageBean.jsonToPage(list,null);

            return  PageBean.jsonToPage(list,null);
        }else {
            System.out.println("==========================");
            return ReturnConstants.SUCCESS;
        }
    }
    @RequestMapping("/patter/queryPatter.do")
    public @ResponseBody String queryPatter(Patter patter){
        if(patter.getUserid()!=0){
            List<Patter> list=patterService.queryPatters(patter.getUserid(),patter.getCourseid(),patter.getPatterTypeId());

            return  PageBean.jsonToPage(list,null);
        }else {

            return ReturnConstants.SUCCESS;
        }
    }
    @RequestMapping("/patter/saveOrUpdatePatter.do")
    public @ResponseBody String saveOrUpdatePatter(Patter patter){
        if(patter.getPatterid()!=0){
            if(patterService.updatePatter(patter)>0){
                System.out.println("修改成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("修改失败");
            }

        }else {
          //  System.out.println("添加的信息:"+patter);
            if(patterService.addPatter(patter)>0){
                System.out.println("添加成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("添加失败");
            }
        }
        return ReturnConstants.PARAM_NULL;
    }
    /*@RequestMapping("/patter/deletePatter.do")
    public @ResponseBody String deletePatter(String patterids){
        System.out.println("patterids :"+patterids);
            if(patterService.deletePatter(patterids)>0){
                System.out.println("删除成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("删除失败");
            }
        return ReturnConstants.PARAM_NULL;
    }*/
}
