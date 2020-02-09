package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Patter;

import java.util.List;

public interface PatterDao {
    public List<Patter> queryPatter(Patter patter);
    public List<Patter> queryPatters(Patter patter);
    public int queryAllPatterInfoCount();

    public int deletePatter(List<String> list);

    public int addPatter(Patter patter);

    public int updatePatter(Patter patter);
}
