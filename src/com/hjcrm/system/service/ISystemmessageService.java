package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Systemmessage;

import java.util.List;

public interface ISystemmessageService {
    public List<Systemmessage> querySystemmessage(PageBean pageBean);

    public int queryAllSystemmessageCount();

    public int addSystemmessage(Systemmessage systemmessage);

    public int deleteSystemmessage(String ids);

    public int updateSystemmessage(Systemmessage systemmessage);

    public int updateSystemmessageByid(Systemmessage systemmessage);
}
