package com.hjcrm.system.service;

import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;

import java.util.List;

public interface IMatchInfoService {
    //到账信息
    public List<Matchinfo> queryMatchinfo();
}
