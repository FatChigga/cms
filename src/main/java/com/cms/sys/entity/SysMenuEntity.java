package com.cms.sys.entity;

public class SysMenuEntity {
    private Long id;

    private String code;

    private String name;

    private Long parentid;

    private Integer level;

    private String pageurl;

    private String remark;

    private Integer enable;

    private Integer isvisiable;

    private Integer issystem;

    private String menuicon;

    private Integer ordernum;

    private Byte isshortcut;

    private String btnstyle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl == null ? null : pageurl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getIsvisiable() {
        return isvisiable;
    }

    public void setIsvisiable(Integer isvisiable) {
        this.isvisiable = isvisiable;
    }

    public Integer getIssystem() {
        return issystem;
    }

    public void setIssystem(Integer issystem) {
        this.issystem = issystem;
    }

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon == null ? null : menuicon.trim();
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