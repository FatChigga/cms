package com.cms.sys.mapper;

import java.util.Map;

import com.cms.sys.entity.SysDictionaryEntity;
import org.apache.ibatis.jdbc.SQL;

public class SysDictionaryEntitySqlProvider {

    public String insertSelective(SysDictionaryEntity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_dictionary");
        
        if (record.getKeycode() != null) {
            sql.VALUES("KeyCode", "#{keycode,jdbcType=VARCHAR}");
        }
        
        if (record.getKeyvalue() != null) {
            sql.VALUES("KeyValue", "#{keyvalue,jdbcType=VARCHAR}");
        }
        
        if (record.getText() != null) {
            sql.VALUES("`Text`", "#{text,jdbcType=VARCHAR}");
        }
        
        if (record.getIsenable() != null) {
            sql.VALUES("IsEnable", "#{isenable,jdbcType=TINYINT}");
        }
        
        if (record.getIsvisible() != null) {
            sql.VALUES("IsVisible", "#{isvisible,jdbcType=BIT}");
        }
        
        if (record.getOrdernum() != null) {
            sql.VALUES("OrderNum", "#{ordernum,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("Remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysDictionaryEntity record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_dictionary");
        
        if (record.getText() != null) {
            sql.SET("`Text` = #{text,jdbcType=VARCHAR}");
        }
        
        if (record.getIsenable() != null) {
            sql.SET("IsEnable = #{isenable,jdbcType=TINYINT}");
        }
        
        if (record.getIsvisible() != null) {
            sql.SET("IsVisible = #{isvisible,jdbcType=BIT}");
        }
        
        if (record.getOrdernum() != null) {
            sql.SET("OrderNum = #{ordernum,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{remark,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("KeyCode = #{keycode,jdbcType=VARCHAR}");
        sql.WHERE("KeyValue = #{keyvalue,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    public String selectByObject(Map<String, Object> record) {
        SQL sql = new SQL();
        sql.SELECT("KeyCode, KeyValue, `Text`, IsEnable, IsVisible, OrderNum, Remark from sys_dictionary");
        
        if (record.get("keycode") != null) {
            sql.WHERE("KeyCode=#{keycode,jdbcType=VARCHAR}");
        }

        if (record.get("keyvalue") != null) {
            sql.WHERE("KeyValue=#{keyvalue,jdbcType=VARCHAR}");
        }

        if (record.get("text") != null) {
            sql.WHERE("`Text`=#{text,jdbcType=VARCHAR}");
        }

        if (record.get("isenable") != null) {
            sql.WHERE("IsEnable=#{isenable,jdbcType=TINYINT}");
        }

        if (record.get("isvisible") != null) {
            sql.WHERE("IsVisible=#{isvisible,jdbcType=BIT}");
        }

        if (record.get("ordernum") != null) {
            sql.WHERE("OrderNum=#{ordernum,jdbcType=INTEGER}");
        }

        if (record.get("remark") != null) {
            sql.WHERE("Remark=#{remark,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    public String deleteByObject(SysDictionaryEntity record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_dictionary");
        
        if (record.getKeycode() != null) {
            sql.WHERE("KeyCode=#{keycode,jdbcType=VARCHAR}");
        }

        if (record.getKeyvalue() != null) {
            sql.WHERE("KeyValue=#{keyvalue,jdbcType=VARCHAR}");
        }

        if (record.getText() != null) {
            sql.WHERE("`Text`=#{text,jdbcType=VARCHAR}");
        }

        if (record.getIsenable() != null) {
            sql.WHERE("IsEnable=#{isenable,jdbcType=TINYINT}");
        }

        if (record.getIsvisible() != null) {
            sql.WHERE("IsVisible=#{isvisible,jdbcType=BIT}");
        }

        if (record.getOrdernum() != null) {
            sql.WHERE("OrderNum=#{ordernum,jdbcType=INTEGER}");
        }

        if (record.getRemark() != null) {
            sql.WHERE("Remark=#{remark,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }
}