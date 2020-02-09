package com.hjcrm.system.service.impl;

import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.mapper.DealrecordDao;
import com.hjcrm.system.mapper.MatchInfoDao;
import com.hjcrm.system.mapper.StudentDao;
import com.hjcrm.system.service.IMatchInfoService;
import com.hjcrm.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("matchinfo")
public class MatchInfoService implements IMatchInfoService {
   @Autowired
    MatchInfoDao matchInfoDao;

    //到账信息
    @Override
    public List<Matchinfo> queryMatchinfo() {
        return matchInfoDao.queryMatchinfo();
    }


}
