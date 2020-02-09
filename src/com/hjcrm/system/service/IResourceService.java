package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Resource;

import java.util.List;

public interface IResourceService {
    public List<Resource> queryResource(Resource resource);
    public List<Resource> queryAllCreatePerson();
    public List<Resource> queryAllCreatePersons(Resource resource);
    public int addResource(Resource resource);
    public int assigntoResource(Resource resource);
    public int updateResource(Resource resource);
    public int queryResourceCount(Resource resource);
    public int deleteResources(String resourceIds);
    public Resource queryResourceById(Resource resource);
    public int updateById(Resource resource);
    public int updateByIdResource(Resource resource);
    public int updateByresorceIdState(Dealrecord dealrecord);
}
