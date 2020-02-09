package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.Pattertype;

import java.util.List;

public interface IPatterService {
    public List<Patter> queryPatter(int userid,int courseid);
    public List<Patter> queryPatters(int userid,int courseid,int patterTypeId);

    public int queryAllPatterInfoCount();

    public int deletePatter(String ids);

    public int addPatter(Patter patter);

    public int updatePatter(Patter patter);

    public List<Pattertype> queryPattertype();
}
