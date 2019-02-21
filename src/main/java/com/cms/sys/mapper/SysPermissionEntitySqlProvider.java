package com.cms.sys.mapper;

import com.cms.sys.entity.SysPermissionEntity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SysPermissionEntitySqlProvider {

    public String insertSelective(SysPermissionEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_permission");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("Code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`Name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIconcss() != null) {
            sql.VALUES("IconCss", "#{iconcss,jdbcType=VARCHAR}");
        }
        
        if (record.getIsenable() != null) {
            sql.VALUES("IsEnable", "#{isenable,jdbcType=TINYINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`Type`", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getShiromark() != null) {
            sql.VALUES("ShiroMark", "#{shiromark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("CreateTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.VALUES("UpdateTime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateid() != null) {
            sql.VALUES("CreateId", "#{createid,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateid() != null) {
            sql.VALUES("UpdateId", "#{updateid,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            sql.VALUES("ParentId", "#{parentid,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("`Level`", "#{level,jdbcType=TINYINT}");
        }
        
        if (record.getPageurl() != null) {
            sql.VALUES("PageUrl", "#{pageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getOrdernum() != null) {
            sql.VALUES("OrderNum", "#{ordernum,jdbcType=INTEGER}");
        }
        
        if (record.getIsshortcut() != null) {
            sql.VALUES("IsShortcut", "#{isshortcut,jdbcType=TINYINT}");
        }
        
        if (record.getBtnstyle() != null) {
            sql.VALUES("BtnStyle", "#{btnstyle,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysPermissionEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_permission");
        
        if (record.getCode() != null) {
            sql.SET("Code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`Name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIconcss() != null) {
            sql.SET("IconCss = #{iconcss,jdbcType=VARCHAR}");
        }
        
        if (record.getIsenable() != null) {
            sql.SET("IsEnable = #{isenable,jdbcType=TINYINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("`Type` = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getShiromark() != null) {
            sql.SET("ShiroMark = #{shiromark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.SET("UpdateTime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateid() != null) {
            sql.SET("CreateId = #{createid,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateid() != null) {
            sql.SET("UpdateId = #{updateid,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            sql.SET("ParentId = #{parentid,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`Level` = #{level,jdbcType=TINYINT}");
        }
        
        if (record.getPageurl() != null) {
            sql.SET("PageUrl = #{pageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getOrdernum() != null) {
            sql.SET("OrderNum = #{ordernum,jdbcType=INTEGER}");
        }
        
        if (record.getIsshortcut() != null) {
            sql.SET("IsShortcut = #{isshortcut,jdbcType=TINYINT}");
        }
        
        if (record.getBtnstyle() != null) {
            sql.SET("BtnStyle = #{btnstyle,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("Id, Code, `Name`, IconCss, IsEnable, `Type`, ShiroMark, CreateTime, UpdateTime, CreateId, UpdateId, ParentId, `Level`, PageUrl, OrderNum, IsShortcut, BtnStyle from sys_permission");
        
        if (record.get("id") != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.get("code") != null) {
            sql.WHERE("Code=#{code,jdbcType=VARCHAR}");
        }

        if (record.get("name") != null) {
            sql.WHERE("`Name`=#{name,jdbcType=VARCHAR}");
        }

        if (record.get("iconcss") != null) {
            sql.WHERE("IconCss=#{iconcss,jdbcType=VARCHAR}");
        }

        if (record.get("isenable") != null) {
            sql.WHERE("IsEnable=#{isenable,jdbcType=TINYINT}");
        }

        if (record.get("type") != null) {
            sql.WHERE("`Type`=#{type,jdbcType=TINYINT}");
        }

        if (record.get("shiromark") != null) {
            sql.WHERE("ShiroMark=#{shiromark,jdbcType=VARCHAR}");
        }

        if (record.get("createtime") != null) {
            sql.WHERE("CreateTime=#{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.get("updatetime") != null) {
            sql.WHERE("UpdateTime=#{updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.get("createid") != null) {
            sql.WHERE("CreateId=#{createid,jdbcType=VARCHAR}");
        }

        if (record.get("updateid") != null) {
            sql.WHERE("UpdateId=#{updateid,jdbcType=VARCHAR}");
        }

        if (record.get("parentid") != null) {
            sql.WHERE("ParentId=#{parentid,jdbcType=VARCHAR}");
        }

        if (record.get("level") != null) {
            sql.WHERE("`Level`=#{level,jdbcType=TINYINT}");
        }

        if (record.get("pageurl") != null) {
            sql.WHERE("PageUrl=#{pageurl,jdbcType=VARCHAR}");
        }

        if (record.get("ordernum") != null) {
            sql.WHERE("OrderNum=#{ordernum,jdbcType=INTEGER}");
        }

        if (record.get("isshortcut") != null) {
            sql.WHERE("IsShortcut=#{isshortcut,jdbcType=TINYINT}");
        }

        if (record.get("btnstyle") != null) {
            sql.WHERE("BtnStyle=#{btnstyle,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    public String deleteByObject(SysPermissionEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_permission");
        
        if (record.getId() != null) {
            sql.WHERE("Id=#{id,jdbcType=INTEGER}");
        }

        if (record.getCode() != null) {
            sql.WHERE("Code=#{code,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            sql.WHERE("`Name`=#{name,jdbcType=VARCHAR}");
        }

        if (record.getIconcss() != null) {
            sql.WHERE("IconCss=#{iconcss,jdbcType=VARCHAR}");
        }

        if (record.getIsenable() != null) {
            sql.WHERE("IsEnable=#{isenable,jdbcType=TINYINT}");
        }

        if (record.getType() != null) {
            sql.WHERE("`Type`=#{type,jdbcType=TINYINT}");
        }

        if (record.getShiromark() != null) {
            sql.WHERE("ShiroMark=#{shiromark,jdbcType=VARCHAR}");
        }

        if (record.getCreatetime() != null) {
            sql.WHERE("CreateTime=#{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatetime() != null) {
            sql.WHERE("UpdateTime=#{updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreateid() != null) {
            sql.WHERE("CreateId=#{createid,jdbcType=VARCHAR}");
        }

        if (record.getUpdateid() != null) {
            sql.WHERE("UpdateId=#{updateid,jdbcType=VARCHAR}");
        }

        if (record.getParentid() != null) {
            sql.WHERE("ParentId=#{parentid,jdbcType=VARCHAR}");
        }

        if (record.getLevel() != null) {
            sql.WHERE("`Level`=#{level,jdbcType=TINYINT}");
        }

        if (record.getPageurl() != null) {
            sql.WHERE("PageUrl=#{pageurl,jdbcType=VARCHAR}");
        }

        if (record.getOrdernum() != null) {
            sql.WHERE("OrderNum=#{ordernum,jdbcType=INTEGER}");
        }

        if (record.getIsshortcut() != null) {
            sql.WHERE("IsShortcut=#{isshortcut,jdbcType=TINYINT}");
        }

        if (record.getBtnstyle() != null) {
            sql.WHERE("BtnStyle=#{btnstyle,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }
}