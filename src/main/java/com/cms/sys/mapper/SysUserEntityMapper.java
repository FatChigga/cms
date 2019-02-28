package com.cms.sys.mapper;

import com.cms.core.mapper.BaseMapper;
import com.cms.sys.entity.SysUserEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserEntityMapper extends BaseMapper<SysUserEntity,String>{
    @Delete({
        "delete from sys_user",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_user (Id, LoginName, ",
        "UserName, OrganizationId, ",
        "Gender, Tel, Email, ",
        "`Password`, CreateTime, ",
        "UpdateTime, RoleId, ",
        "Code, IsLeader, ",
        "`Status`)",
        "values (#{id,jdbcType=BIGINT}, #{loginname,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{organizationid,jdbcType=BIGINT}, ",
        "#{gender,jdbcType=TINYINT}, #{tel,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{roleid,jdbcType=BIGINT}, ",
        "#{code,jdbcType=VARCHAR}, #{isleader,jdbcType=TINYINT}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(SysUserEntity record);

    @InsertProvider(type=SysUserEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysUserEntity record);

    @Select({
        "select",
        "Id, LoginName, UserName, OrganizationId, Gender, Tel, Email, `Password`, CreateTime, ",
        "UpdateTime, RoleId, Code, IsLeader, `Status`",
        "from sys_user",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LoginName", property="loginname", jdbcType=JdbcType.VARCHAR),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="OrganizationId", property="organizationid", jdbcType=JdbcType.BIGINT),
        @Result(column="Gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="Tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="Email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="Password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UpdateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RoleId", property="roleid", jdbcType=JdbcType.BIGINT),
        @Result(column="Code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsLeader", property="isleader", jdbcType=JdbcType.TINYINT),
        @Result(column="Status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    SysUserEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysUserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUserEntity record);

    @Update({
        "update sys_user",
        "set LoginName = #{loginname,jdbcType=VARCHAR},",
          "UserName = #{username,jdbcType=VARCHAR},",
          "OrganizationId = #{organizationid,jdbcType=BIGINT},",
          "Gender = #{gender,jdbcType=TINYINT},",
          "Tel = #{tel,jdbcType=VARCHAR},",
          "Email = #{email,jdbcType=VARCHAR},",
          "`Password` = #{password,jdbcType=VARCHAR},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "UpdateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "RoleId = #{roleid,jdbcType=BIGINT},",
          "Code = #{code,jdbcType=VARCHAR},",
          "IsLeader = #{isleader,jdbcType=TINYINT},",
          "`Status` = #{status,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysUserEntity record);

    @SelectProvider(type=SysUserEntitySqlProvider.class, method="selectByObject")
    @Results(id = "sysuserentity", value= {
        @Result(column="Id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LoginName", property="loginname", jdbcType=JdbcType.VARCHAR),
        @Result(column="UserName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="OrganizationId", property="organizationid", jdbcType=JdbcType.BIGINT),
        @Result(column="Gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="Tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="Email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="Password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UpdateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RoleId", property="roleid", jdbcType=JdbcType.BIGINT),
        @Result(column="Code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsLeader", property="isleader", jdbcType=JdbcType.TINYINT),
        @Result(column="Status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<SysUserEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type=SysUserEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "sysuserentity")
    SysUserEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysUserEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysUserEntity record);
}