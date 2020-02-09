package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Transferrecord;
import com.hjcrm.system.mapper.TransferrecordDao;
import com.hjcrm.system.service.ITransferrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("transferrecordService")
public class TransferrecordService implements ITransferrecordService {
    @Autowired
    TransferrecordDao transferrecordDao;
    @Override
    public List<Transferrecord> queryTransferrecord(PageBean pageBean) {
        return transferrecordDao.queryTransferrecord(pageBean);
    }

    @Override
    public int queryTransferrecordCount() {
        return transferrecordDao.queryTransferrecordCount();
    }
}
