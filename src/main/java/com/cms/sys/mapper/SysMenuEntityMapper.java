package com.cms.sys.mapper;

import com.cms.sys.entity.SysMenuEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysMenuEntityMapper {
    @Delete({
        "delete from sys_menu",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_menu (Id, Code, ",
        "`Name`, ParentId, `Level`, ",
        "PageUrl, Remark, ",
        "`Enable`, IsVisiable, ",
        "IsSystem, MenuIcon, ",
        "OrderNum, IsShortcut, ",
        "BtnStyle)",
        "values (#{id,jdbcType=BIGINT}, #{code,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{parentid,jdbcType=BIGINT}, #{level,jdbcType=INTEGER}, ",
        "#{pageurl,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{enable,jdbcType=INTEGER}, #{isvisiable,jdbcType=INTEGER}, ",
        "#{issystem,jdbcType=INTEGER}, #{menuicon,jdbcType=VARCHAR}, ",
        "#{ordernum,jdbcType=INTEGER}, #{isshortcut,jdbcType=TINYINT}, ",
        "#{btnstyle,jdbcType=VARCHAR})"
    })
    int insert(SysMenuEntity record);

    @InsertProvider(type=SysMenuEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysMenuEntity record);

    @Select({
        "select",
        "Id, Code, `Name`, ParentId, `Level`, PageUrl, Remark, `Enable`, IsVisiable, ",
        "IsSystem, MenuIcon, OrderNum, IsShortcut, BtnStyle",
        "from sys_menu",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="Code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ParentId", property="parentid", jdbcType=JdbcType.BIGINT),
        @Result(column="Level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="PageUrl", property="pageurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="Enable", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="IsVisiable", property="isvisiable", jdbcType=JdbcType.INTEGER),
        @Result(column="IsSystem", property="issystem", jdbcType=JdbcType.INTEGER),
        @Result(column="MenuIcon", property="menuicon", jdbcType=JdbcType.VARCHAR),
        @Result(column="OrderNum", property="ordernum", jdbcType=JdbcType.INTEGER),
        @Result(column="IsShortcut", property="isshortcut", jdbcType=JdbcType.TINYINT),
        @Result(column="BtnStyle", property="btnstyle", jdbcType=JdbcType.VARCHAR)
    })
    SysMenuEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysMenuEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMenuEntity record);

    @Update({
        "update sys_menu",
        "set Code = #{code,jdbcType=VARCHAR},",
          "`Name` = #{name,jdbcType=VARCHAR},",
          "ParentId = #{parentid,jdbcType=BIGINT},",
          "`Level` = #{level,jdbcType=INTEGER},",
          "PageUrl = #{pageurl,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "`Enable` = #{enable,jdbcType=INTEGER},",
          "IsVisiable = #{isvisiable,jdbcType=INTEGER},",
          "IsSystem = #{issystem,jdbcType=INTEGER},",
          "MenuIcon = #{menuicon,jdbcType=VARCHAR},",
          "OrderNum = #{ordernum,jdbcType=INTEGER},",
          "IsShortcut = #{isshortcut,jdbcType=TINYINT},",
          "BtnStyle = #{btnstyle,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysMenuEntity record);

    @SelectProvider(type=SysMenuEntitySqlProvider.class, method="selectByObject")
    @Results(id = "sysmenuentity", value= {
        @Result(column="Id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="Code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ParentId", property="parentid", jdbcType=JdbcType.BIGINT),
        @Result(column="Level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="PageUrl", property="pageurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="Enable", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="IsVisiable", property="isvisiable", jdbcType=JdbcType.INTEGER),
        @Result(column="IsSystem", property="issystem", jdbcType=JdbcType.INTEGER),
        @Result(column="MenuIcon", property="menuicon", jdbcType=JdbcType.VARCHAR),
        @Result(column="OrderNum", property="ordernum", jdbcType=JdbcType.INTEGER),
        @Result(column="IsShortcut", property="isshortcut", jdbcType=JdbcType.TINYINT),
        @Result(column="BtnStyle", property="btnstyle", jdbcType=JdbcType.VARCHAR)
    })
    List<SysMenuEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type=SysMenuEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "sysmenuentity")
    SysMenuEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysMenuEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysMenuEntity record);
}