package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.Pattertype;
import com.hjcrm.system.entity.Resource;

import java.util.List;

public interface PattertypeDao {
    public List<Pattertype> queryPattertype();

    public int addpattertype(Pattertype pattertype);

    public int deletepatterType(List<String> list);


    public int updatepattertype(Pattertype pattertype);
}
