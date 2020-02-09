package com.hjcrm.system.service;

import com.hjcrm.system.entity.Pattertype;

import java.util.List;

public interface IPattertypeService {
    public List<Pattertype> queryPattertype();

    public int addpattertype(Pattertype pattertype);

    public int deletepatterType(String patterTypeIds);

    public int updatepattertype(Pattertype pattertype);
}
