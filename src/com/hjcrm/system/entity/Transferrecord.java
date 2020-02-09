package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Transferrecord {

    private int  transferrecordId;//` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '转移记录ID',
    private int  resourceId;//` bigint(20) DEFAULT NULL COMMENT '资源ID',
    private String    phone;//` varchar(20) DEFAULT NULL COMMENT '手机号',
    private String      tel;//` varchar(20) DEFAULT NULL COMMENT '座机',
    private int   sourceId;//` bigint(20) DEFAULT NULL COMMENT '数据来源人ID',
    private String     sourceName;//` varchar(50) DEFAULT NULL COMMENT '数据来源人',
    private int    belongId;//` bigint(20) DEFAULT NULL COMMENT '归属者ID',
    private String    belongName;//` varchar(50) DEFAULT NULL COMMENT '归属者',
    private Timestamp create_time;//` timestamp NULL DEFAULT NULL COMMENT '转移时间',
    private int   state;//` int(1) DEFAULT NULL COMMENT '资源状态  0未分配 1已分配(未处理) 2已处理',
    private int    deptid;//` bigint(20) DEFAULT NULL COMMENT '部门ID',
    private int      source;//` int(3) DEFAULT NULL COMMENT '渠道: 0自建  1课程注册  2在线注册  3app下载注册   4电话咨询   5金考网注册用户   6线上渠道  7在线咨询  8大库资源 9 在线购买',
    private int      operationId;//` bigint(20) DEFAULT NULL COMMENT '操作人ID',
    private String    operationName;//` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
    private String   resourceLevelBefore;//` varchar(2) DEFAULT NULL COMMENT '转移前资源等级     A B C D',

    public int getTransferrecordId() {
        return transferrecordId;
    }

    public void setTransferrecordId(int transferrecordId) {
        this.transferrecordId = transferrecordId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public int getBelongId() {
        return belongId;
    }

    public void setBelongId(int belongId) {
        this.belongId = belongId;
    }

    public String getBelongName() {
        return belongName;
    }

    public void setBelongName(String belongName) {
        this.belongName = belongName;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getResourceLevelBefore() {
        return resourceLevelBefore;
    }

    public void setResourceLevelBefore(String resourceLevelBefore) {
        this.resourceLevelBefore = resourceLevelBefore;
    }

    public Transferrecord(int transferrecordId, int resourceId, String phone, String tel, int sourceId, String sourceName, int belongId, String belongName, Timestamp create_time, int state, int deptid, int source, int operationId, String operationName, String resourceLevelBefore) {
        this.transferrecordId = transferrecordId;
        this.resourceId = resourceId;
        this.phone = phone;
        this.tel = tel;
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.belongId = belongId;
        this.belongName = belongName;
        this.create_time = create_time;
        this.state = state;
        this.deptid = deptid;
        this.source = source;
        this.operationId = operationId;
        this.operationName = operationName;
        this.resourceLevelBefore = resourceLevelBefore;
    }

    public Transferrecord() {
        super();
    }

    @Override
    public String toString() {
        return "Transferrecord{" +
                "transferrecordId=" + transferrecordId +
                ", resourceId=" + resourceId +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", sourceId=" + sourceId +
                ", sourceName='" + sourceName + '\'' +
                ", belongId=" + belongId +
                ", belongName='" + belongName + '\'' +
                ", create_time=" + create_time +
                ", state=" + state +
                ", deptid=" + deptid +
                ", source=" + source +
                ", operationId=" + operationId +
                ", operationName='" + operationName + '\'' +
                ", resourceLevelBefore='" + resourceLevelBefore + '\'' +
                '}';
    }
}
