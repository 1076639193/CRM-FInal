package com.hjcrm.system.controller.yunying;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.contstants.ReturnConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.IResourceService;
import com.hjcrm.system.service.IUserService;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResourceController {
    @Autowired
    IResourceService resourceService;
    @Autowired
    IUserService userService;
    @RequestMapping("/resource/resourcesMang.do")
    public String resourcesMang(){
        return JumpViewConstants.RESOURCE_RESOURCESMANG;
    }

    @RequestMapping("/resource/queryResource.do")
    public @ResponseBody String queryResource(Resource resource,Integer roleid){
        List<Resource> list=resourceService.queryResource(resource);
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(resource.getPageSize());
        pageBean.setCountResult(5);
        pageBean.setCurrentPage((resource.getCurrentPage()-1)*resource.getPageSize());
        System.out.println("PageSize"+resource.getPageSize());
        System.out.println("CurrentPage"+(resource.getCurrentPage()-1)*resource.getPageSize());
        String jsionResource=PageBean.jsonToPage(list,pageBean);
        return jsionResource;
    }
    @RequestMapping("/resource/addResource.do")
    public @ResponseBody String addResource(Resource resource){
        if(resource.getResourceId()>0){
            if(resource.getAddress()!=null){
                System.out.println("asdsadsadsad:++"+resource);
                if(resourceService.updateById(resource)>0){
                    System.out.println("修改成功ss");
                    return  ReturnConstants.SUCCESS;
                }else{
                    System.out.println("修改失败ss");
                }
            }else{
                //修改分配
                if(resourceService.updateResource(resource)>0){
                    System.out.println("修改成功");
                    return  ReturnConstants.SUCCESS;
                }else{
                    System.out.println("修改失败");
                }
            }
        }else{
            System.out.println("添加的信息："+resource);
            if(resourceService.addResource(resource)>0){
                System.out.println("添加成功");
                return  ReturnConstants.SUCCESS;
            }else{
                System.out.println("添加失败");
            }
        }
       return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/resource/queryAllCreatePerson.do")
    public @ResponseBody String queryAllCreatePerson(Resource resource){
        System.out.println("resource :::++"+resource);
        if(resource.getUserid()!=0){
            List<User> list=userService.queryAllUser();
            for (User u:list) {
                System.out.println("u:"+u);
            }
            return PageBean.jsonToPage(list,null);
        }else{
            System.out.println("无参");

            List<User> list=userService.queryAllUser();
            return PageBean.jsonToPage(list,null);
        }
    }
    @RequestMapping("/resource/deleteResources.do")
    public @ResponseBody String deleteResources(String resourceId){
        System.out.println("resourceId:---------"+resourceId);
        if(resourceService.deleteResources(resourceId)>0){
            System.out.println("删除成功");
            return  ReturnConstants.SUCCESS;
        }else{
            System.out.println("删除失败");
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/resource/queryResourceCount.do")
    public @ResponseBody String queryResourceCount(Resource resource){
        System.out.println("resourceId:---------"+resource.getUserid());
        int i=resourceService.queryResourceCount(resource);
        PageBean pageBean=new PageBean();
        pageBean.setCountResult(i);
        return PageBean.jsonToPage(null,pageBean);
    }
    @RequestMapping("/resource/queryAllXiaoShou.do")
    public @ResponseBody String queryAllXiaoShou(){
        List<User> list=userService.queryAllUser();
        return PageBean.jsonToPage(list,null);
    }

    @RequestMapping("/resource/assigntoResource.do")
    public @ResponseBody String assigntoResource(String belongid, String resourceIds, String states) {
        if (UserContext.getLoginUser() != null) {
            int i = 0;
            Resource r = new Resource();
            for (String resourceId : resourceIds.split(",")) {
                r.setResourceId(Integer.parseInt(resourceId));
                for (String state:states.split(",")) {
                    r.setState(Integer.parseInt(state));
                    i = resourceService.assigntoResource(r);
                }
            }
            if(i > 0){
                return ReturnConstants.SUCCESS;
            }else{
                return  "16";
            }
        }
        return JumpViewConstants.SYSTEM_LOGIN;
    }

    @RequestMapping("/resource/queryResourceBySceen.do")
    public @ResponseBody String queryResourceBySceen(Resource resource){
        List<Resource> list=resourceService.queryResource(resource);
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(resource.getPageSize());
        pageBean.setCountResult(5);
        pageBean.setCurrentPage((resource.getCurrentPage()-1)*resource.getPageSize());
        System.out.println("PageSize"+resource.getPageSize());
        System.out.println("CurrentPage"+(resource.getCurrentPage()-1)*resource.getPageSize());
        String jsionResource=PageBean.jsonToPage(list,pageBean);
        return jsionResource;
    }
}
