package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.entity.User;

import java.util.List;

public interface ResourceDao {
    public List<Resource> queryResource(Resource resource);
    public List<Resource> queryAllCreatePersons(Resource resource);
    public List<Resource> queryAllCreatePerson();
    public int queryResourceCount(Resource resource);
    public int addResource(Resource resource);
    //销售员下拉
    public List<User> queryAllXiaoShou();
    public int updateResource(Resource resource);
    //分配销售元
    public int assigntoResource(Resource resource);

    public int deleteResource(List<String> list);
    public int updateById(Resource resource);
    public Resource queryResourceById(Resource resource);
    public int updateByIdResource(Resource resource);
    public int updateByresorceIdState(Dealrecord dealrecord);
}
