package com.cms.sys.entity;

import java.util.Date;

public class SysPermissionEntity {
    private Integer id;

    private String code;

    private String name;

    private String iconcss;

    private Byte isenable;

    private Byte type;

    private String shiromark;

    private Date createtime;

    private Date updatetime;

    private String createid;

    private String updateid;

    private String parentid;

    private Byte level;

    private String pageurl;

    private Integer ordernum;

    private Byte isshortcut;

    private String btnstyle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIconcss() {
        return iconcss;
    }

    public void setIconcss(String iconcss) {
        this.iconcss = iconcss == null ? null : iconcss.trim();
    }

    public Byte getIsenable() {
        return isenable;
    }

    public void setIsenable(Byte isenable) {
        this.isenable = isenable;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getShiromark() {
        return shiromark;
    }

    public void setShiromark(String shiromark) {
        this.shiromark = shiromark == null ? null : shiromark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateid() {
        return createid;
    }

    public void setCreateid(String createid) {
        this.createid = createid == null ? null : createid.trim();
    }

    public String getUpdateid() {
        return updateid;
    }

    public void setUpdateid(String updateid) {
        this.updateid = updateid == null ? null : updateid.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl == null ? null : pageurl.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Byte getIsshortcut() {
        return isshortcut;
    }

    public void setIsshortcut(Byte isshortcut) {
        this.isshortcut = isshortcut;
    }

    public String getBtnstyle() {
        return btnstyle;
    }

    public void setBtnstyle(String btnstyle) {
        this.btnstyle = btnstyle == null ? null : btnstyle.trim();
    }
}