package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.entity.Systemmessage;

import java.util.List;

public interface SystemmessageDao {
    public List<Systemmessage> querySystemmessage(PageBean pageBean);

    public int queryAllSystemmessageCount();

    public int addSystemmessage(Systemmessage systemmessage);

    public int deleteSystemmessage(List<String> list);

    public int updateSystemmessage(Systemmessage systemmessage);

    public int updateSystemmessageByid(Systemmessage systemmessage);
}
