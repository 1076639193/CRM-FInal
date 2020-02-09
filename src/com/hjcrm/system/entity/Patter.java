package com.hjcrm.system.entity;

import java.sql.Timestamp;
import java.util.List;

public class Patter {

    private int patterid;//` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '话术主键',
    private int userid;//` bigint(20) DEFAULT NULL COMMENT '用户id,话术创建人',
    private int roleid;//` bigint(20) DEFAULT NULL COMMENT '用户角色ID',
    private int courseid;//` int(10) DEFAULT NULL COMMENT '课程id',
    private int patterTypeId;//` bigint(20) DEFAULT NULL COMMENT '话术场景类别',
    private int contentTypeId;//` bigint(20) DEFAULT NULL COMMENT '话术内容类别',
    private String shortTitle;//` varchar(200) DEFAULT NULL COMMENT '话术内容短标题',
    private String content;//` text COMMENT '话术内容',
    private Timestamp create_time;//` timestamp NULL DEFAULT NULL COMMENT '创建时间',
    private Timestamp update_time;//` timestamp NULL DEFAULT NULL COMMENT '修改时间',
    private int update_id;//` bigint(20) DEFAULT NULL COMMENT '修改人',
    private int isshare;//` int(1) DEFAULT '0' COMMENT '是否共享 0不共享  1共享',
    private String note;//` varchar(200) DEFAULT NULL COMMENT '备注',
    private int dr;//` int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',


    public Patter() {
        super();
    }

    @Override
    public String toString() {
        return "Patter{" +
                "patterid=" + patterid +
                ", userid=" + userid +
                ", roleid=" + roleid +
                ", courseid=" + courseid +
                ", patterTypeId=" + patterTypeId +
                ", contentTypeId=" + contentTypeId +
                ", shortTitle='" + shortTitle + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                ", isshare=" + isshare +
                ", note='" + note + '\'' +
                ", dr=" + dr +
                '}';
    }

    public void setPatterid(int patterid) {
        this.patterid = patterid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public void setPatterTypeId(int patterTypeId) {
        this.patterTypeId = patterTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public void setIsshare(int isshare) {
        this.isshare = isshare;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getPatterid() {
        return patterid;
    }

    public int getUserid() {
        return userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public int getCourseid() {
        return courseid;
    }

    public int getPatterTypeId() {
        return patterTypeId;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public int getIsshare() {
        return isshare;
    }

    public String getNote() {
        return note;
    }

    public int getDr() {
        return dr;
    }

    public Patter(int patterid, int userid, int roleid, int courseid, int patterTypeId, int contentTypeId, String shortTitle, String content, Timestamp create_time, Timestamp update_time, int update_id, int isshare, String note, int dr) {
        this.patterid = patterid;
        this.userid = userid;
        this.roleid = roleid;
        this.courseid = courseid;
        this.patterTypeId = patterTypeId;
        this.contentTypeId = contentTypeId;
        this.shortTitle = shortTitle;
        this.content = content;
        this.create_time = create_time;
        this.update_time = update_time;
        this.update_id = update_id;
        this.isshare = isshare;
        this.note = note;
        this.dr = dr;
    }
}
