package com.cms.sys.mapper;

import com.cms.sys.entity.SysLogEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysLogEntityMapper {
    @Delete({
        "delete from sys_log",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_log (Id, UserId, ",
        "UserName, IPAddress, ",
        "`Method`, MethodLocation, ",
        "CreateDate, StartDate, ",
        "EndDate, Param, ",
        "Remark)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{username,jdbcType=VARCHAR}, #{ipaddress,jdbcType=VARCHAR}, ",
        "#{method,jdbcType=VARCHAR}, #{methodlocation,jdbcType=VARCHAR}, ",
        "#{createdate,jdbcType=TIMESTAMP}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP}, #{param,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=LONGVARCHAR})"
    })
    int insert(SysLogEntity record);

    @InsertProvider(type=SysLogEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysLogEntity record);

    @Select({
        "select",
        "Id, UserId, UserName, IPAddress, `Method`, MethodLocation, CreateDate, StartDate, ",
        "EndDate, Param, Remark",
        "from sys_log",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="IPAddress", property="ipaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="Method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="MethodLocation", property="methodlocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="StartDate", property="startdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EndDate", property="enddate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Param", property="param", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    SysLogEntity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysLogEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysLogEntity record);

    @Update({
        "update sys_log",
        "set UserId = #{userid,jdbcType=INTEGER},",
          "UserName = #{username,jdbcType=VARCHAR},",
          "IPAddress = #{ipaddress,jdbcType=VARCHAR},",
          "`Method` = #{method,jdbcType=VARCHAR},",
          "MethodLocation = #{methodlocation,jdbcType=VARCHAR},",
          "CreateDate = #{createdate,jdbcType=TIMESTAMP},",
          "StartDate = #{startdate,jdbcType=TIMESTAMP},",
          "EndDate = #{enddate,jdbcType=TIMESTAMP},",
          "Param = #{param,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=LONGVARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SysLogEntity record);

    @Update({
        "update sys_log",
        "set UserId = #{userid,jdbcType=INTEGER},",
          "UserName = #{username,jdbcType=VARCHAR},",
          "IPAddress = #{ipaddress,jdbcType=VARCHAR},",
          "`Method` = #{method,jdbcType=VARCHAR},",
          "MethodLocation = #{methodlocation,jdbcType=VARCHAR},",
          "CreateDate = #{createdate,jdbcType=TIMESTAMP},",
          "StartDate = #{startdate,jdbcType=TIMESTAMP},",
          "EndDate = #{enddate,jdbcType=TIMESTAMP},",
          "Param = #{param,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysLogEntity record);

    @SelectProvider(type=SysLogEntitySqlProvider.class, method="selectByObject")
    @Results(id = "syslogentity", value= {
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="IPAddress", property="ipaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="Method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="MethodLocation", property="methodlocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="StartDate", property="startdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EndDate", property="enddate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Param", property="param", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<SysLogEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type=SysLogEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "syslogentity")
    SysLogEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysLogEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysLogEntity record);
}