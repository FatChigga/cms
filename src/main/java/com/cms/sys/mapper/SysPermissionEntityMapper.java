package com.cms.sys.mapper;

import com.cms.sys.entity.SysPermissionEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SysPermissionEntityMapper{
    @Delete({
        "delete from sys_permission",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_permission (Id, Code, ",
        "`Name`, IconCss, IsEnable, ",
        "`Type`, ShiroMark, ",
        "CreateTime, UpdateTime, ",
        "CreateId, UpdateId, ",
        "ParentId, `Level`, ",
        "PageUrl, OrderNum, ",
        "IsShortcut, BtnStyle)",
        "values (#{id,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{iconcss,jdbcType=VARCHAR}, #{isenable,jdbcType=TINYINT}, ",
        "#{type,jdbcType=TINYINT}, #{shiromark,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{updatetime,jdbcType=TIMESTAMP}, ",
        "#{createid,jdbcType=VARCHAR}, #{updateid,jdbcType=VARCHAR}, ",
        "#{parentid,jdbcType=VARCHAR}, #{level,jdbcType=TINYINT}, ",
        "#{pageurl,jdbcType=VARCHAR}, #{ordernum,jdbcType=INTEGER}, ",
        "#{isshortcut,jdbcType=TINYINT}, #{btnstyle,jdbcType=VARCHAR})"
    })
    int insert(SysPermissionEntity record);

    @InsertProvider(type= SysPermissionEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysPermissionEntity record);

    @Select({
        "select",
        "Id, Code, `Name`, IconCss, IsEnable, `Type`, ShiroMark, CreateTime, UpdateTime, ",
        "CreateId, UpdateId, ParentId, `Level`, PageUrl, OrderNum, IsShortcut, BtnStyle",
        "from sys_permission",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="IconCss", property="iconcss", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsEnable", property="isenable", jdbcType=JdbcType.TINYINT),
        @Result(column="Type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="ShiroMark", property="shiromark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UpdateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CreateId", property="createid", jdbcType=JdbcType.VARCHAR),
        @Result(column="UpdateId", property="updateid", jdbcType=JdbcType.VARCHAR),
        @Result(column="ParentId", property="parentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="PageUrl", property="pageurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="OrderNum", property="ordernum", jdbcType=JdbcType.INTEGER),
        @Result(column="IsShortcut", property="isshortcut", jdbcType=JdbcType.TINYINT),
        @Result(column="BtnStyle", property="btnstyle", jdbcType=JdbcType.VARCHAR)
    })
    SysPermissionEntity selectByPrimaryKey(Integer id);

    @UpdateProvider(type= SysPermissionEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysPermissionEntity record);

    @Update({
        "update sys_permission",
        "set Code = #{code,jdbcType=VARCHAR},",
          "`Name` = #{name,jdbcType=VARCHAR},",
          "IconCss = #{iconcss,jdbcType=VARCHAR},",
          "IsEnable = #{isenable,jdbcType=TINYINT},",
          "`Type` = #{type,jdbcType=TINYINT},",
          "ShiroMark = #{shiromark,jdbcType=VARCHAR},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "UpdateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "CreateId = #{createid,jdbcType=VARCHAR},",
          "UpdateId = #{updateid,jdbcType=VARCHAR},",
          "ParentId = #{parentid,jdbcType=VARCHAR},",
          "`Level` = #{level,jdbcType=TINYINT},",
          "PageUrl = #{pageurl,jdbcType=VARCHAR},",
          "OrderNum = #{ordernum,jdbcType=INTEGER},",
          "IsShortcut = #{isshortcut,jdbcType=TINYINT},",
          "BtnStyle = #{btnstyle,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysPermissionEntity record);

    @SelectProvider(type= SysPermissionEntitySqlProvider.class, method="selectByObject")
    @Results(id = "syspermissionentity", value= {
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="IconCss", property="iconcss", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsEnable", property="isenable", jdbcType=JdbcType.TINYINT),
        @Result(column="Type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="ShiroMark", property="shiromark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UpdateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CreateId", property="createid", jdbcType=JdbcType.VARCHAR),
        @Result(column="UpdateId", property="updateid", jdbcType=JdbcType.VARCHAR),
        @Result(column="ParentId", property="parentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="PageUrl", property="pageurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="OrderNum", property="ordernum", jdbcType=JdbcType.INTEGER),
        @Result(column="IsShortcut", property="isshortcut", jdbcType=JdbcType.TINYINT),
        @Result(column="BtnStyle", property="btnstyle", jdbcType=JdbcType.VARCHAR)
    })
    List<SysPermissionEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type= SysPermissionEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "syspermissionentity")
    SysPermissionEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysPermissionEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysPermissionEntity record);

    @Select({
            "SELECT b.*",
                    "FROM sys_role_permission a",
                    "LEFT JOIN sys_permission b ON a.PermisionId = b.Id",
                    "WHERE a.RoleId = #{roleId,jdbcType=INTEGER}"
    })
    @ResultType(java.util.HashMap.class)
    List<Map> getPermissionListByRoleId(String roleId);
}