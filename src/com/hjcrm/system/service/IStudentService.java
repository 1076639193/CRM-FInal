package com.hjcrm.system.service;

import com.hjcrm.publics.util.PageBean;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Matchinfo;
import com.hjcrm.system.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> queryStudent();

    public List<Student> queryStudnetMatchs(Student student);

    public List<Student> queryPassStudents(Student student);

    public List<Student> queryOnLineStudents(Student student);

    public List<Student> queryStudentById(Student student);

    public int addDealrecord(Dealrecord dealrecord);

    //提交修改  1
    public int commit_caiwu(int studentIds);

    public int addstudent(Dealrecord dealrecord);

    public int returnStudent(Student student);

    public int studentCommit(int studentId);

    //总表学员
   public   List<Student> queryStudentscaiwu();

   //网络培训费(财务部)
    List<Student> queryNetworkEduMoneyBycaiwu(PageBean pageBean);

    int queryAllNetworkInfoCount();
}
