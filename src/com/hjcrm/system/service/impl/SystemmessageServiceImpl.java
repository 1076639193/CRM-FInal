package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Systemmessage;
import com.hjcrm.system.mapper.SystemmessageDao;
import com.hjcrm.system.service.ISystemmessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("systemmessageService")
public class SystemmessageServiceImpl implements ISystemmessageService {
    @Autowired
    SystemmessageDao systemmessageDao;
    @Override
    public List<Systemmessage> querySystemmessage(PageBean pageBean) {
        return systemmessageDao.querySystemmessage(pageBean);
    }

    @Override
    public int queryAllSystemmessageCount() {
        return systemmessageDao.queryAllSystemmessageCount();
    }

    @Override
    public int addSystemmessage(Systemmessage systemmessage) {
        return systemmessageDao.addSystemmessage(systemmessage);
    }

    @Override
    public int deleteSystemmessage(String ids) {
        List<String> list=new ArrayList<>();
        for (String id:ids.split(",")) {
            list.add(id);
        }
        return systemmessageDao.deleteSystemmessage(list);
    }

    @Override
    public int updateSystemmessage(Systemmessage systemmessage) {
        return systemmessageDao.updateSystemmessage(systemmessage);
    }

    @Override
    public int updateSystemmessageByid(Systemmessage systemmessage) {
        return systemmessageDao.updateSystemmessageByid(systemmessage);
    }


}
