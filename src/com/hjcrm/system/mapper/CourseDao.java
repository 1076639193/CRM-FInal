package com.hjcrm.system.mapper;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Course;

import java.util.List;

public interface CourseDao {
    public List<Course> queryCourse(PageBean pageBean);
    public List<Course> queryCourseByid();
    public int queryAllCourseInfoCount();

    public int addCourse(Course course);

    public int deleteCourse(List<String> list);

    public int updateCourse(Course course);
}
