package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.mapper.ResourceDao;
import com.hjcrm.system.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("resourceService")
public class ResourceService implements IResourceService {
    @Autowired
    ResourceDao resourceDao;
    @Override
    public List<Resource> queryResource(Resource resource) {
        return resourceDao.queryResource(resource);
    }

    @Override
    public List<Resource> queryAllCreatePerson() {

        return resourceDao.queryAllCreatePerson();
    }

    @Override
    public List<Resource> queryAllCreatePersons(Resource resource) {
        return resourceDao.queryAllCreatePersons(resource);
    }

    @Override
    public int addResource(Resource resource) {
        return resourceDao.addResource(resource);
    }

    @Override
    public int assigntoResource(Resource resource) {
        if (resource.getState() != 0) {
            return -1;
        } else {
            return resourceDao.assigntoResource(resource);
        }
    }

    @Override
    public int updateResource(Resource resource) {
        return resourceDao.updateResource(resource);
    }

    @Override
    public int queryResourceCount(Resource resource) {
        return resourceDao.queryResourceCount(resource);
    }

    @Override
    public int deleteResources(String resourceIds) {
        List<String> list=new ArrayList<>();
        for (String id:resourceIds.split(",")) {
            list.add(id);
        }
        return resourceDao.deleteResource(list);
    }

    @Override
    public Resource queryResourceById(Resource resource) {
        return resourceDao.queryResourceById(resource);
    }

    @Override
    public int updateById(Resource resource) {
        return resourceDao.updateById(resource);
    }



    @Override
    public int updateByIdResource(Resource resource) {
        return resourceDao.updateByIdResource(resource);
    }

    @Override
    public int updateByresorceIdState(Dealrecord dealrecord) {

        return resourceDao.updateByresorceIdState(dealrecord);
    }
}
