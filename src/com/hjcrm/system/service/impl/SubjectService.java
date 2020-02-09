package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Subject;
import com.hjcrm.system.mapper.SubjectDao;
import com.hjcrm.system.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("subjectService")
public class SubjectService implements ISubjectService {
    @Autowired
    SubjectDao subjectDao;

    @Override
    public List<Subject> querySubject(PageBean pb) {
        return subjectDao.querySubject(pb);
    }

    @Override
    public int queryAllSubjectInfoCount() {
        return subjectDao.queryAllSubjectInfoCount();
    }

    @Override
    public int deleteSubject(String subjectids) {
        List<String> list=new ArrayList<>();
        for (String id:subjectids.split(",")) {
            list.add(id);
        }
        return subjectDao.deleteSubject(list);
    }

    @Override
    public int updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    @Override
    public List<Subject> querySubjectById(int courseid) {
        return subjectDao.querySubjectById(courseid);
    }

}
