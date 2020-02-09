package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.Dealrecord;

import java.util.List;

public interface DealrecordDao {
    public int addDealrecord(Dealrecord dealrecord);

    public List<Dealrecord> queryDealrecord(Dealrecord dealrecord);
}
