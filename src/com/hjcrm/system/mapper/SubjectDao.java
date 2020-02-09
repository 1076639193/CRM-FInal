package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Subject;

import java.util.List;

public interface SubjectDao {
    public List<Subject> querySubject(PageBean pb);

    public List<Subject> querySubjectById(int courseid);

    public int queryAllSubjectInfoCount();

    public int deleteSubject(List<String> list);

    public int updateSubject(Subject subject);
}
