package com.cms.sys.mapper;

import com.cms.sys.entity.SysLogEntity;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysLogEntitySqlProvider {

    public String insertSelective(SysLogEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_log");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("UserId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("UserName", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIpaddress() != null) {
            sql.VALUES("IPAddress", "#{ipaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.VALUES("`Method`", "#{method,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodlocation() != null) {
            sql.VALUES("MethodLocation", "#{methodlocation,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            sql.VALUES("CreateDate", "#{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartdate() != null) {
            sql.VALUES("StartDate", "#{startdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnddate() != null) {
            sql.VALUES("EndDate", "#{enddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getParam() != null) {
            sql.VALUES("Param", "#{param,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("Remark", "#{remark,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysLogEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_log");
        
        if (record.getUserid() != null) {
            sql.SET("UserId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("UserName = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIpaddress() != null) {
            sql.SET("IPAddress = #{ipaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.SET("`Method` = #{method,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodlocation() != null) {
            sql.SET("MethodLocation = #{methodlocation,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            sql.SET("CreateDate = #{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartdate() != null) {
            sql.SET("StartDate = #{startdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnddate() != null) {
            sql.SET("EndDate = #{enddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getParam() != null) {
            sql.SET("Param = #{param,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{remark,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("Id, UserId, UserName, IPAddress, `Method`, MethodLocation, CreateDate, StartDate, EndDate, Param, Remark from sys_log");
        
        if (record.get("id") != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.get("userid") != null) {
            sql.WHERE("UserId=#{userid,jdbcType=INTEGER}");
        }

        if (record.get("username") != null) {
            sql.WHERE("UserName=#{username,jdbcType=VARCHAR}");
        }

        if (record.get("ipaddress") != null) {
            sql.WHERE("IPAddress=#{ipaddress,jdbcType=VARCHAR}");
        }

        if (record.get("method") != null) {
            sql.WHERE("`Method`=#{method,jdbcType=VARCHAR}");
        }

        if (record.get("methodlocation") != null) {
            sql.WHERE("MethodLocation=#{methodlocation,jdbcType=VARCHAR}");
        }

        if (record.get("createdate") != null) {
            sql.WHERE("CreateDate=#{createdate,jdbcType=TIMESTAMP}");
        }

        if (record.get("startdate") != null) {
            sql.WHERE("StartDate=#{startdate,jdbcType=TIMESTAMP}");
        }

        if (record.get("enddate") != null) {
            sql.WHERE("EndDate=#{enddate,jdbcType=TIMESTAMP}");
        }

        if (record.get("param") != null) {
            sql.WHERE("Param=#{param,jdbcType=VARCHAR}");
        }

        if (record.get("remark") != null) {
            sql.WHERE("Remark=#{remark,jdbcType=LONGVARCHAR}");
        }
        return sql.toString();
    }

    public String deleteByObject(SysLogEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_log");
        
        if (record.getId() != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.getUserid() != null) {
            sql.WHERE("UserId=#{userid,jdbcType=INTEGER}");
        }

        if (record.getUsername() != null) {
            sql.WHERE("UserName=#{username,jdbcType=VARCHAR}");
        }

        if (record.getIpaddress() != null) {
            sql.WHERE("IPAddress=#{ipaddress,jdbcType=VARCHAR}");
        }

        if (record.getMethod() != null) {
            sql.WHERE("`Method`=#{method,jdbcType=VARCHAR}");
        }

        if (record.getMethodlocation() != null) {
            sql.WHERE("MethodLocation=#{methodlocation,jdbcType=VARCHAR}");
        }

        if (record.getCreatedate() != null) {
            sql.WHERE("CreateDate=#{createdate,jdbcType=TIMESTAMP}");
        }

        if (record.getStartdate() != null) {
            sql.WHERE("StartDate=#{startdate,jdbcType=TIMESTAMP}");
        }

        if (record.getEnddate() != null) {
            sql.WHERE("EndDate=#{enddate,jdbcType=TIMESTAMP}");
        }

        if (record.getParam() != null) {
            sql.WHERE("Param=#{param,jdbcType=VARCHAR}");
        }

        if (record.getRemark() != null) {
            sql.WHERE("Remark=#{remark,jdbcType=LONGVARCHAR}");
        }
        return sql.toString();
    }
}