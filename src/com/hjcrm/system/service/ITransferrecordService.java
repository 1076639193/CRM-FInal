package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Transferrecord;

import java.util.List;

public interface ITransferrecordService {
    public List<Transferrecord> queryTransferrecord(PageBean pageBean);

    public int queryTransferrecordCount();
}
