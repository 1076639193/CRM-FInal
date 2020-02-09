package com.hjcrm.system.controller.huihua;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Pattertype;
import com.hjcrm.system.service.IPatterService;
import com.hjcrm.system.service.IPattertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PatterTypeController {
    @Autowired
    IPattertypeService pattertypeService;
    @RequestMapping("/system/patterType.do")
    public String patterType(){
        if(UserContext.getLoginUser()!=null){
            return JumpViewConstants.SYSTEM_PATTERTYPE;
        }
        return  JumpViewConstants.SYSTEM_LOGIN;
    }
   @RequestMapping("/course/queryPattertype.do")
    public @ResponseBody String queryPattertype(){
        List<Pattertype> list=pattertypeService.queryPattertype();
        for (Pattertype p:list) {
            System.out.println("list sssssssssss:"+list);
        }
        return  PageBean.jsonToPage(list,null);
    }
    @RequestMapping("/course/addPattertype.do")
    public @ResponseBody String addPattertype(Pattertype pattertype){
        if(pattertype.getPatterTypeId()!=0){
            System.out.println("修改的 数据："+pattertype);
            if(pattertypeService.updatepattertype(pattertype)>0){
                System.out.println("修改成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("修改失败");
            }
        }else{
            if( pattertypeService.addpattertype(pattertype)>0){
                System.out.println("添加成功");
                return ReturnConstants.SUCCESS;
            }else{
                System.out.println("添加失败");
            }

        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/course/deletepatterType.do")
    public @ResponseBody String deletepatterType(String patterTypeIds){
        if(pattertypeService.deletepatterType(patterTypeIds)>0){
            System.out.println("删除成功");
            return ReturnConstants.SUCCESS;
        }else{
            System.out.println("删除失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
}
