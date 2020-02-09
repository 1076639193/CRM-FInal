package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Dealrecord {
    private int dealrecordId;//` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '成交记录主键ID',
    private int  resourceId;//` bigint(20) DEFAULT NULL COMMENT '资源ID',
    private int  studentId;//` bigint(20) DEFAULT NULL COMMENT '学员ID',
    private int   courseid;//` bigint(20) DEFAULT NULL COMMENT '课程ID',
    private int    subjectid;//` bigint(20) DEFAULT NULL COMMENT '科目ID',
    private int     userid;//` bigint(20) DEFAULT NULL COMMENT '创建人',
    private Timestamp create_time;//` timestamp NULL DEFAULT NULL COMMENT '创建日期',
    private int    update_id;//` bigint(20) DEFAULT NULL COMMENT '修改人',
    private Timestamp     update_time;//` timestamp NULL DEFAULT NULL COMMENT '修改日期',
    private String      note;//` varchar(200) DEFAULT NULL COMMENT '备注',
    private int     dr;//` int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',
    private Timestamp  scoretime;//` timestamp NULL DEFAULT NULL COMMENT '考试时间',
    private String    score;//` varchar(20) DEFAULT NULL COMMENT '考试成绩',
    private int     ispass;//` int(1) DEFAULT '0' COMMENT '是否通过 0未通过 1通过 2缺考',
    private Timestamp dealtime;
    private int ishavenetedu;
    private int isOnlineBuy;
    private int netedumoney;
    private String remituser;
    private String preferinfo;
    private String dealprice;

    public String getDealprice() {
        return dealprice;
    }

    public void setDealprice(String dealprice) {
        this.dealprice = dealprice;
    }

    public String getRemituser() {
        return remituser;
    }

    public void setRemituser(String remituser) {
        this.remituser = remituser;
    }

    public String getPreferinfo() {
        return preferinfo;
    }

    public void setPreferinfo(String preferinfo) {
        this.preferinfo = preferinfo;
    }

    public int getIshavenetedu() {
        return ishavenetedu;
    }

    public void setIshavenetedu(int ishavenetedu) {
        this.ishavenetedu = ishavenetedu;
    }

    public int getIsOnlineBuy() {
        return isOnlineBuy;
    }

    public void setIsOnlineBuy(int isOnlineBuy) {
        this.isOnlineBuy = isOnlineBuy;
    }

    public int getNetedumoney() {
        return netedumoney;
    }

    public void setNetedumoney(int netedumoney) {
        this.netedumoney = netedumoney;
    }

    public Timestamp getDealtime() {
        return dealtime;
    }

    public void setDealtime(Timestamp dealtime) {
        this.dealtime = dealtime;
    }

    public Dealrecord(int dealrecordId, int resourceId, int studentId, int courseid, int subjectid, int userid, Timestamp create_time, int update_id, Timestamp update_time, String note, int dr, Timestamp scoretime, String score, int ispass) {
        this.dealrecordId = dealrecordId;
        this.resourceId = resourceId;
        this.studentId = studentId;
        this.courseid = courseid;
        this.subjectid = subjectid;
        this.userid = userid;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.note = note;
        this.dr = dr;
        this.scoretime = scoretime;
        this.score = score;
        this.ispass = ispass;
    }

    public int getDealrecordId() {
        return dealrecordId;
    }

    public void setDealrecordId(int dealrecordId) {
        this.dealrecordId = dealrecordId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public Timestamp getScoretime() {
        return scoretime;
    }

    public void setScoretime(Timestamp scoretime) {
        this.scoretime = scoretime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getIspass() {
        return ispass;
    }

    public void setIspass(int ispass) {
        this.ispass = ispass;
    }

    public Dealrecord() {
        super();
    }

    @Override
    public String toString() {
        return "Dealrecord{" +
                "dealrecordId=" + dealrecordId +
                ", resourceId=" + resourceId +
                ", studentId=" + studentId +
                ", courseid=" + courseid +
                ", subjectid=" + subjectid +
                ", userid=" + userid +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", note='" + note + '\'' +
                ", dr=" + dr +
                ", scoretime=" + scoretime +
                ", score='" + score + '\'' +
                ", ispass=" + ispass +
                '}';
    }
}
