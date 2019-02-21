package com.cms.sys.mapper;

import com.cms.sys.entity.SysRolePermissionEntity;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysRolePermissionEntitySqlProvider {

    public String insertSelective(SysRolePermissionEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_role_permission");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getRoleid() != null) {
            sql.VALUES("RoleId", "#{roleid,jdbcType=BIGINT}");
        }
        
        if (record.getPermisionid() != null) {
            sql.VALUES("PermisionId", "#{permisionid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysRolePermissionEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role_permission");
        
        if (record.getRoleid() != null) {
            sql.SET("RoleId = #{roleid,jdbcType=BIGINT}");
        }
        
        if (record.getPermisionid() != null) {
            sql.SET("PermisionId = #{permisionid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("Id, RoleId, PermisionId from sys_role_permission");
        
        if (record.get("id") != null) {
            sql.WHERE("Id=#{id,jdbcType=BIGINT}");
        }

        if (record.get("roleid") != null) {
            sql.WHERE("RoleId=#{roleid,jdbcType=BIGINT}");
        }

        if (record.get("permisionid") != null) {
            sql.WHERE("PermisionId=#{permisionid,jdbcType=INTEGER}");
        }
        return sql.toString();
    }

    public String deleteByObject(SysRolePermissionEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_role_permission");
        
        if (record.getId() != null) {
            sql.WHERE("Id=#{id,jdbcType=BIGINT}");
        }

        if (record.getRoleid() != null) {
            sql.WHERE("RoleId=#{roleid,jdbcType=BIGINT}");
        }

        if (record.getPermisionid() != null) {
            sql.WHERE("PermisionId=#{permisionid,jdbcType=INTEGER}");
        }
        return sql.toString();
    }
}