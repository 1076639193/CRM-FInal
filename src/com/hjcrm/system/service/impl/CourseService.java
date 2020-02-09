package com.hjcrm.system.service.impl;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.mapper.CourseDao;
import com.hjcrm.system.service.ICourseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("courseService")
public class CourseService implements ICourseService {
    @Autowired
    CourseDao courseDao;
    @Override
    public List<Course> queryCourse(PageBean pageBean) {
        return courseDao.queryCourse(pageBean);
    }

    @Override
    public List<Course> queryCourseByid() {
        return courseDao.queryCourseByid();
    }

    @Override
    public int queryAllCourseInfoCount() {
        return courseDao.queryAllCourseInfoCount();
    }

    @Override
    public int addCourse(Course course) {
        System.out.println("addCourse Service:"+course);
        return courseDao.addCourse(course);
    }

    @Override
    public int deleteCourse(String courseids) {
        List<String> list=new ArrayList<>();
        if(StringUtils.isNotBlank(courseids)){
            for (String id:courseids.split(",")) {
                //String is=id.split(",");
                System.out.println("courseids courseids"+courseids);
                list.add(id);
            }
        }
        return courseDao.deleteCourse(list);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }
}
