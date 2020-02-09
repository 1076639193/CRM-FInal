package com.hjcrm.system.controller.caiwu;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.service.impl.MatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MatchInforController {
    @Autowired
    MatchInfoService matchInfoService;

    //到账信息
        @RequestMapping("/matchinfo/macthinfor.do")
        public String  macthinfor(){
            if(UserContext.getLoginUser()!=null){
                return JumpViewConstants.SYSTEM_FINANCE_MATCHINFOR;
            }
            return  JumpViewConstants.SYSTEM_LOGIN;

        }

        @RequestMapping("/matchinfo/queryMatchinfo.do")
    public @ResponseBody String queryMatchinfo(){
            PageBean pageBean =new PageBean();
            List<Matchinfo> list =matchInfoService.queryMatchinfo();
            String jsonResult =PageBean.jsonToPage(list,null);
            return jsonResult;
        }


}
