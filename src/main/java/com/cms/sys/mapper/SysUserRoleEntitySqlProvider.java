package com.cms.sys.mapper;

import com.cms.sys.entity.SysUserRoleEntity;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysUserRoleEntitySqlProvider {

    public String insertSelective(SysUserRoleEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_user_role");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("UserId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getRoleid() != null) {
            sql.VALUES("RoleId", "#{roleid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysUserRoleEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_user_role");
        
        if (record.getUserid() != null) {
            sql.SET("UserId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getRoleid() != null) {
            sql.SET("RoleId = #{roleid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("Id, UserId, RoleId from sys_user_role");
        
        if (record.get("id") != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.get("userid") != null) {
            sql.WHERE("UserId=#{userid,jdbcType=INTEGER}");
        }

        if (record.get("roleid") != null) {
            sql.WHERE("RoleId=#{roleid,jdbcType=INTEGER}");
        }
        return sql.toString();
    }

    public String deleteByObject(SysUserRoleEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_user_role");
        
        if (record.getId() != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.getUserid() != null) {
            sql.WHERE("UserId=#{userid,jdbcType=INTEGER}");
        }

        if (record.getRoleid() != null) {
            sql.WHERE("RoleId=#{roleid,jdbcType=INTEGER}");
        }
        return sql.toString();
    }
}