package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Transferrecord;

import java.util.List;

public interface TransferrecordDao {
    public List<Transferrecord> queryTransferrecord(PageBean pageBean);

    public int queryTransferrecordCount();
}
