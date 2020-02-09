package com.hjcrm.system.controller.xiaoshou;

import com.hjcrm.publics.contstants.JumpViewConstants;
import com.hjcrm.publics.util.PageBean;
import com.hjcrm.publics.util.UserContext;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.entity.Transferrecord;
import com.hjcrm.system.service.ITransferrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TransferRecordController {
    @Autowired
    ITransferrecordService transferrecordService;
    @RequestMapping("/sales/transferRecord.do")
    public String transferRecord(){
        return JumpViewConstants.SYSTEM_SALE_TRANSFERRECORD;
    }
    @RequestMapping("/resource/queryTransferRecord.do")
    public @ResponseBody
    String queryTransferRecord(Integer pageSize, Integer currentPage){
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCountResult((currentPage-1)*pageSize);
        pageBean.setCountResult(transferrecordService.queryTransferrecordCount());
        List<Transferrecord> list=transferrecordService.queryTransferrecord(pageBean);
        return PageBean.jsonToPage(list,pageBean);
    }
}
