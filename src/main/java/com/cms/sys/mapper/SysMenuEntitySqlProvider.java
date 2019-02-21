package com.cms.sys.mapper;

import com.cms.sys.entity.SysMenuEntity;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysMenuEntitySqlProvider {

    public String insertSelective(SysMenuEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_menu");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("Code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`Name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            sql.VALUES("ParentId", "#{parentid,jdbcType=BIGINT}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("`Level`", "#{level,jdbcType=INTEGER}");
        }
        
        if (record.getPageurl() != null) {
            sql.VALUES("PageUrl", "#{pageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("Remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getEnable() != null) {
            sql.VALUES("`Enable`", "#{enable,jdbcType=INTEGER}");
        }
        
        if (record.getIsvisiable() != null) {
            sql.VALUES("IsVisiable", "#{isvisiable,jdbcType=INTEGER}");
        }
        
        if (record.getIssystem() != null) {
            sql.VALUES("IsSystem", "#{issystem,jdbcType=INTEGER}");
        }
        
        if (record.getMenuicon() != null) {
            sql.VALUES("MenuIcon", "#{menuicon,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(SysMenuEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");
        
        if (record.getCode() != null) {
            sql.SET("Code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("`Name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            sql.SET("ParentId = #{parentid,jdbcType=BIGINT}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`Level` = #{level,jdbcType=INTEGER}");
        }
        
        if (record.getPageurl() != null) {
            sql.SET("PageUrl = #{pageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getEnable() != null) {
            sql.SET("`Enable` = #{enable,jdbcType=INTEGER}");
        }
        
        if (record.getIsvisiable() != null) {
            sql.SET("IsVisiable = #{isvisiable,jdbcType=INTEGER}");
        }
        
        if (record.getIssystem() != null) {
            sql.SET("IsSystem = #{issystem,jdbcType=INTEGER}");
        }
        
        if (record.getMenuicon() != null) {
            sql.SET("MenuIcon = #{menuicon,jdbcType=VARCHAR}");
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
        
        sql.WHERE("Id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("Id, Code, `Name`, ParentId, `Level`, PageUrl, Remark, `Enable`, IsVisiable, IsSystem, MenuIcon, OrderNum, IsShortcut, BtnStyle from sys_menu");
        
        if (record.get("id") != null) {
            sql.WHERE("Id=#{id,jdbcType=BIGINT}");
        }

        if (record.get("code") != null) {
            sql.WHERE("Code=#{code,jdbcType=VARCHAR}");
        }

        if (record.get("name") != null) {
            sql.WHERE("`Name`=#{name,jdbcType=VARCHAR}");
        }

        if (record.get("parentid") != null) {
            sql.WHERE("ParentId=#{parentid,jdbcType=BIGINT}");
        }

        if (record.get("level") != null) {
            sql.WHERE("`Level`=#{level,jdbcType=INTEGER}");
        }

        if (record.get("pageurl") != null) {
            sql.WHERE("PageUrl=#{pageurl,jdbcType=VARCHAR}");
        }

        if (record.get("remark") != null) {
            sql.WHERE("Remark=#{remark,jdbcType=VARCHAR}");
        }

        if (record.get("enable") != null) {
            sql.WHERE("`Enable`=#{enable,jdbcType=INTEGER}");
        }

        if (record.get("isvisiable") != null) {
            sql.WHERE("IsVisiable=#{isvisiable,jdbcType=INTEGER}");
        }

        if (record.get("issystem") != null) {
            sql.WHERE("IsSystem=#{issystem,jdbcType=INTEGER}");
        }

        if (record.get("menuicon") != null) {
            sql.WHERE("MenuIcon=#{menuicon,jdbcType=VARCHAR}");
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

    public String deleteByObject(SysMenuEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_menu");
        
        if (record.getId() != null) {
            sql.WHERE("Id=#{id,jdbcType=BIGINT}");
        }

        if (record.getCode() != null) {
            sql.WHERE("Code=#{code,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            sql.WHERE("`Name`=#{name,jdbcType=VARCHAR}");
        }

        if (record.getParentid() != null) {
            sql.WHERE("ParentId=#{parentid,jdbcType=BIGINT}");
        }

        if (record.getLevel() != null) {
            sql.WHERE("`Level`=#{level,jdbcType=INTEGER}");
        }

        if (record.getPageurl() != null) {
            sql.WHERE("PageUrl=#{pageurl,jdbcType=VARCHAR}");
        }

        if (record.getRemark() != null) {
            sql.WHERE("Remark=#{remark,jdbcType=VARCHAR}");
        }

        if (record.getEnable() != null) {
            sql.WHERE("`Enable`=#{enable,jdbcType=INTEGER}");
        }

        if (record.getIsvisiable() != null) {
            sql.WHERE("IsVisiable=#{isvisiable,jdbcType=INTEGER}");
        }

        if (record.getIssystem() != null) {
            sql.WHERE("IsSystem=#{issystem,jdbcType=INTEGER}");
        }

        if (record.getMenuicon() != null) {
            sql.WHERE("MenuIcon=#{menuicon,jdbcType=VARCHAR}");
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