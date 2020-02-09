package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Course;

import java.util.List;

public interface ICourseService {
    public List<Course> queryCourse(PageBean pageBean);
    public List<Course> queryCourseByid();
    public int queryAllCourseInfoCount();

    public int addCourse(Course course);

    public int deleteCourse(String deleteCourse);
    public int updateCourse(Course course);
}
