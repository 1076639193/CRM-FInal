package com.hjcrm.system.controller.xiaoshou;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SalesIndexController {
    @RequestMapping("/sales/companySalesIndex.do")
    public String companySalesIndex(){
        return JumpViewConstants.SALES_SALESINDEX;
    }
}
