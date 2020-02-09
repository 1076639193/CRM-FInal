package com.hjcrm.system.entity;

import java.sql.Timestamp;

public class Role {

    private int    roleid;//` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    private String      rolename;//` varchar(50) DEFAULT NULL COMMENT '角色名称',
    private int   deptid;//` bigint(20) DEFAULT NULL COMMENT '所属部门ID',
    private int dr;//` int(1) NOT NULL DEFAULT '0' COMMENT '删除标志 0未删除 1已删除',
    private Timestamp create_time;//` timestamp NULL DEFAULT NULL COMMENT '创建时间',
    private int   create_id;//` bigint(20) DEFAULT NULL COMMENT '创建人',
    private Timestamp     update_time;//` timestamp NULL DEFAULT NULL COMMENT '修改时间',
    private int  update_id;//` bigint(20) DEFAULT NULL COMMENT '修改人',

    private String deptname;//部门名称
    private String menuname;//权限菜单（很多个功能菜单）

    public String getDeptname() {
        return deptname;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Role(int roleid, String rolename, int deptid, int dr, Timestamp create_time, int create_id, Timestamp update_time, int update_id, String deptname, String menuname) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.deptid = deptid;
        this.dr = dr;
        this.create_time = create_time;
        this.create_id = create_id;
        this.update_time = update_time;
        this.update_id = update_id;
        this.deptname = deptname;
        this.menuname = menuname;
    }

    public Role() {
        super();
    }

    public int getRoleid() {
        return roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public int getDeptid() {
        return deptid;
    }

    public int getDr() {
        return dr;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public int getCreate_id() {
        return create_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", deptid=" + deptid +
                ", dr=" + dr +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                ", deptname='" + deptname + '\'' +
                ", menuname='" + menuname + '\'' +
                '}';
    }
}

