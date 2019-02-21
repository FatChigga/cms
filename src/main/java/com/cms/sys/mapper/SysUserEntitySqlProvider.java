package com.cms.sys.mapper;

import com.cms.sys.entity.SysUserEntity;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysUserEntitySqlProvider {

    public String insertSelective(SysUserEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_user");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLoginname() != null) {
            sql.VALUES("LoginName", "#{loginname,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("UserName", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getOrganizationid() != null) {
            sql.VALUES("OrganizationId", "#{organizationid,jdbcType=BIGINT}");
        }
        
        if (record.getGender() != null) {
            sql.VALUES("Gender", "#{gender,jdbcType=TINYINT}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("Tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("Email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("`Password`", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("CreateTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.VALUES("UpdateTime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRoleid() != null) {
            sql.VALUES("RoleId", "#{roleid,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("Code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getIsleader() != null) {
            sql.VALUES("IsLeader", "#{isleader,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("`Status`", "#{status,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysUserEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_user");
        
        if (record.getLoginname() != null) {
            sql.SET("LoginName = #{loginname,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("UserName = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getOrganizationid() != null) {
            sql.SET("OrganizationId = #{organizationid,jdbcType=BIGINT}");
        }
        
        if (record.getGender() != null) {
            sql.SET("Gender = #{gender,jdbcType=TINYINT}");
        }
        
        if (record.getTel() != null) {
            sql.SET("Tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("Email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("`Password` = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.SET("UpdateTime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRoleid() != null) {
            sql.SET("RoleId = #{roleid,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            sql.SET("Code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getIsleader() != null) {
            sql.SET("IsLeader = #{isleader,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`Status` = #{status,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("Id, LoginName, UserName, OrganizationId, Gender, Tel, Email, `Password`, CreateTime, UpdateTime, RoleId, Code, IsLeader, `Status` from sys_user");
        
        if (record.get("id") != null) {
            sql.WHERE("Id=#{id,jdbcType=BIGINT}");
        }

        if (record.get("loginname") != null) {
            sql.WHERE("LoginName=#{loginname,jdbcType=VARCHAR}");
        }

        if (record.get("username") != null) {
            sql.WHERE("UserName=#{username,jdbcType=VARCHAR}");
        }

        if (record.get("organizationid") != null) {
            sql.WHERE("OrganizationId=#{organizationid,jdbcType=BIGINT}");
        }

        if (record.get("gender") != null) {
            sql.WHERE("Gender=#{gender,jdbcType=TINYINT}");
        }

        if (record.get("tel") != null) {
            sql.WHERE("Tel=#{tel,jdbcType=VARCHAR}");
        }

        if (record.get("email") != null) {
            sql.WHERE("Email=#{email,jdbcType=VARCHAR}");
        }

        if (record.get("password") != null) {
            sql.WHERE("`Password`=#{password,jdbcType=VARCHAR}");
        }

        if (record.get("createtime") != null) {
            sql.WHERE("CreateTime=#{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.get("updatetime") != null) {
            sql.WHERE("UpdateTime=#{updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.get("roleid") != null) {
            sql.WHERE("RoleId=#{roleid,jdbcType=BIGINT}");
        }

        if (record.get("code") != null) {
            sql.WHERE("Code=#{code,jdbcType=VARCHAR}");
        }

        if (record.get("isleader") != null) {
            sql.WHERE("IsLeader=#{isleader,jdbcType=TINYINT}");
        }

        if (record.get("status") != null) {
            sql.WHERE("`Status`=#{status,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    public String deleteByObject(SysUserEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_user");
        
        if (record.getId() != null) {
            sql.WHERE("Id=#{id,jdbcType=BIGINT}");
        }

        if (record.getLoginname() != null) {
            sql.WHERE("LoginName=#{loginname,jdbcType=VARCHAR}");
        }

        if (record.getUsername() != null) {
            sql.WHERE("UserName=#{username,jdbcType=VARCHAR}");
        }

        if (record.getOrganizationid() != null) {
            sql.WHERE("OrganizationId=#{organizationid,jdbcType=BIGINT}");
        }

        if (record.getGender() != null) {
            sql.WHERE("Gender=#{gender,jdbcType=TINYINT}");
        }

        if (record.getTel() != null) {
            sql.WHERE("Tel=#{tel,jdbcType=VARCHAR}");
        }

        if (record.getEmail() != null) {
            sql.WHERE("Email=#{email,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.WHERE("`Password`=#{password,jdbcType=VARCHAR}");
        }

        if (record.getCreatetime() != null) {
            sql.WHERE("CreateTime=#{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatetime() != null) {
            sql.WHERE("UpdateTime=#{updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.getRoleid() != null) {
            sql.WHERE("RoleId=#{roleid,jdbcType=BIGINT}");
        }

        if (record.getCode() != null) {
            sql.WHERE("Code=#{code,jdbcType=VARCHAR}");
        }

        if (record.getIsleader() != null) {
            sql.WHERE("IsLeader=#{isleader,jdbcType=TINYINT}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("`Status`=#{status,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }
}