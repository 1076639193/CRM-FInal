package com.hjcrm.system.service.impl;

import com.hjcrm.system.entity.Pattertype;
import com.hjcrm.system.mapper.PattertypeDao;
import com.hjcrm.system.service.IPattertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pattertypeService")
public class PattertypeService implements IPattertypeService {
    @Autowired
    PattertypeDao pattertypeDao;
    @Override
    public List<Pattertype> queryPattertype() {
        return pattertypeDao.queryPattertype();
    }

    @Override
    public int addpattertype(Pattertype pattertype) {
        return pattertypeDao.addpattertype(pattertype);
    }

    @Override
    public int deletepatterType(String patterTypeIds) {
        List<String> list=new ArrayList<>();
        for (String id:patterTypeIds.split(",")) {
            list.add(",");
        }
        return pattertypeDao.deletepatterType(list);
    }

    @Override
    public int updatepattertype(Pattertype pattertype) {
        return pattertypeDao.updatepattertype(pattertype);
    }
}
