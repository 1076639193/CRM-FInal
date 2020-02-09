package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Subject;

import java.util.List;

public interface ISubjectService {
    public List<Subject> querySubject(PageBean pb);

    public int queryAllSubjectInfoCount();

    public int deleteSubject(String subjectids);

    public int updateSubject(Subject subject);

    public List<Subject> querySubjectById(int courseid);
}
