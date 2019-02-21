package com.cms.sys.entity;

public class SysRolePermissionEntity {
    private Long id;

    private Long roleid;

    private Integer permisionid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Integer getPermisionid() {
        return permisionid;
    }

    public void setPermisionid(Integer permisionid) {
        this.permisionid = permisionid;
    }
}