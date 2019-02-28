package com.cms.sys.mapper;

import com.cms.core.mapper.BaseMapper;
import com.cms.sys.entity.SysLogLoginEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysLogLoginEntityMapper extends BaseMapper<SysLogLoginEntity, String> {
    @Delete({
        "delete from sys_log_login",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_log_login (Id, UserCode, ",
        "UserName, IPAddress, ",
        "LoginDate, LoginStatus, ",
        "Remark)",
        "values (#{id,jdbcType=INTEGER}, #{usercode,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{ipaddress,jdbcType=VARCHAR}, ",
        "#{logindate,jdbcType=TIMESTAMP}, #{loginstatus,jdbcType=TINYINT}, ",
        "#{remark,jdbcType=LONGVARCHAR})"
    })
    int insert(SysLogLoginEntity record);

    @InsertProvider(type=SysLogLoginEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysLogLoginEntity record);

    @Select({
        "select",
        "Id, UserCode, UserName, IPAddress, LoginDate, LoginStatus, Remark",
        "from sys_log_login",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserCode", property="usercode", jdbcType=JdbcType.VARCHAR),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="IPAddress", property="ipaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="LoginDate", property="logindate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LoginStatus", property="loginstatus", jdbcType=JdbcType.TINYINT),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    SysLogLoginEntity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysLogLoginEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysLogLoginEntity record);

    @Update({
        "update sys_log_login",
        "set UserCode = #{usercode,jdbcType=VARCHAR},",
          "UserName = #{username,jdbcType=VARCHAR},",
          "IPAddress = #{ipaddress,jdbcType=VARCHAR},",
          "LoginDate = #{logindate,jdbcType=TIMESTAMP},",
          "LoginStatus = #{loginstatus,jdbcType=TINYINT},",
          "Remark = #{remark,jdbcType=LONGVARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SysLogLoginEntity record);

    @Update({
        "update sys_log_login",
        "set UserCode = #{usercode,jdbcType=VARCHAR},",
          "UserName = #{username,jdbcType=VARCHAR},",
          "IPAddress = #{ipaddress,jdbcType=VARCHAR},",
          "LoginDate = #{logindate,jdbcType=TIMESTAMP},",
          "LoginStatus = #{loginstatus,jdbcType=TINYINT}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysLogLoginEntity record);

    @SelectProvider(type=SysLogLoginEntitySqlProvider.class, method="selectByObject")
    @Results(id = "syslogloginentity", value= {
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserCode", property="usercode", jdbcType=JdbcType.VARCHAR),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="IPAddress", property="ipaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="LoginDate", property="logindate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LoginStatus", property="loginstatus", jdbcType=JdbcType.TINYINT),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<SysLogLoginEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type=SysLogLoginEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "syslogloginentity")
    SysLogLoginEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysLogLoginEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysLogLoginEntity record);
}