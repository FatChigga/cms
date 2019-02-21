package com.cms.sys.mapper;

import com.cms.sys.entity.SysLogLoginEntity;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysLogLoginEntitySqlProvider {

    public String insertSelective(SysLogLoginEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_log_login");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUsercode() != null) {
            sql.VALUES("UserCode", "#{usercode,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("UserName", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIpaddress() != null) {
            sql.VALUES("IPAddress", "#{ipaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getLogindate() != null) {
            sql.VALUES("LoginDate", "#{logindate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoginstatus() != null) {
            sql.VALUES("LoginStatus", "#{loginstatus,jdbcType=TINYINT}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("Remark", "#{remark,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysLogLoginEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_log_login");
        
        if (record.getUsercode() != null) {
            sql.SET("UserCode = #{usercode,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("UserName = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIpaddress() != null) {
            sql.SET("IPAddress = #{ipaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getLogindate() != null) {
            sql.SET("LoginDate = #{logindate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoginstatus() != null) {
            sql.SET("LoginStatus = #{loginstatus,jdbcType=TINYINT}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{remark,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("Id, UserCode, UserName, IPAddress, LoginDate, LoginStatus, Remark from sys_log_login");
        
        if (record.get("id") != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.get("usercode") != null) {
            sql.WHERE("UserCode=#{usercode,jdbcType=VARCHAR}");
        }

        if (record.get("username") != null) {
            sql.WHERE("UserName=#{username,jdbcType=VARCHAR}");
        }

        if (record.get("ipaddress") != null) {
            sql.WHERE("IPAddress=#{ipaddress,jdbcType=VARCHAR}");
        }

        if (record.get("logindate") != null) {
            sql.WHERE("LoginDate=#{logindate,jdbcType=TIMESTAMP}");
        }

        if (record.get("loginstatus") != null) {
            sql.WHERE("LoginStatus=#{loginstatus,jdbcType=TINYINT}");
        }

        if (record.get("remark") != null) {
            sql.WHERE("Remark=#{remark,jdbcType=LONGVARCHAR}");
        }
        return sql.toString();
    }

    public String deleteByObject(SysLogLoginEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_log_login");
        
        if (record.getId() != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.getUsercode() != null) {
            sql.WHERE("UserCode=#{usercode,jdbcType=VARCHAR}");
        }

        if (record.getUsername() != null) {
            sql.WHERE("UserName=#{username,jdbcType=VARCHAR}");
        }

        if (record.getIpaddress() != null) {
            sql.WHERE("IPAddress=#{ipaddress,jdbcType=VARCHAR}");
        }

        if (record.getLogindate() != null) {
            sql.WHERE("LoginDate=#{logindate,jdbcType=TIMESTAMP}");
        }

        if (record.getLoginstatus() != null) {
            sql.WHERE("LoginStatus=#{loginstatus,jdbcType=TINYINT}");
        }

        if (record.getRemark() != null) {
            sql.WHERE("Remark=#{remark,jdbcType=LONGVARCHAR}");
        }
        return sql.toString();
    }
}