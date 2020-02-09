package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.Pattertype;
import com.hjcrm.system.mapper.PatterDao;
import com.hjcrm.system.mapper.PattertypeDao;
import com.hjcrm.system.service.IPatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("patterService")
public class PatterServiceImpl implements IPatterService {
    @Autowired
    PatterDao patterDao;
    @Autowired
    PattertypeDao pattertypeDao;
    @Override
    public List<Patter> queryPatter(int userid,int courseid) {

        Patter patter = new Patter();
        patter.setCourseid(courseid);
        patter.setUserid(userid);
        return patterDao.queryPatter(patter);
    }

    @Override
    public List<Patter> queryPatters(int userid, int courseid, int patterTypeId) {
        Patter patter = new Patter();
        patter.setCourseid(courseid);
        patter.setUserid(userid);
        patter.setPatterTypeId(patterTypeId);
        return patterDao.queryPatters(patter);
    }

    @Override
    public int queryAllPatterInfoCount() {
        return patterDao.queryAllPatterInfoCount();
    }

    @Override
    public int deletePatter(String patterids) {

        List<String> list=new ArrayList<>();
        for (String id:patterids.split(",")) {
            list.add(id);
        }
        return patterDao.deletePatter(list);
    }

    @Override
    public int addPatter(Patter patter) {
        return patterDao.addPatter(patter);
    }

    @Override
    public int updatePatter(Patter patter) {
        return patterDao.updatePatter(patter);
    }

    @Override
    public List<Pattertype> queryPattertype() {
        return pattertypeDao.queryPattertype();
    }

}
