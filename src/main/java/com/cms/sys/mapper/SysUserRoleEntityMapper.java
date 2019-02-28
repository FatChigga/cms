package com.cms.sys.mapper;

import com.cms.core.mapper.BaseMapper;
import com.cms.sys.entity.SysUserRoleEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserRoleEntityMapper  extends BaseMapper<SysUserRoleEntity, String> {
    @Delete({
        "delete from sys_user_role",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_user_role (Id, UserId, ",
        "RoleId)",
        "values (#{id,jdbcType=BIGINT}, #{userid,jdbcType=BIGINT}, ",
        "#{roleid,jdbcType=BIGINT})"
    })
    int insert(SysUserRoleEntity record);

    @InsertProvider(type=SysUserRoleEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysUserRoleEntity record);

    @Select({
        "select",
        "Id, UserId, RoleId",
        "from sys_user_role",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="RoleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    SysUserRoleEntity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysUserRoleEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUserRoleEntity record);

    @Update({
        "update sys_user_role",
        "set UserId = #{userid,jdbcType=BIGINT},",
          "RoleId = #{roleid,jdbcType=BIGINT}",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysUserRoleEntity record);

    @SelectProvider(type=SysUserRoleEntitySqlProvider.class, method="selectByObject")
    @Results(id = "sysuserroleentity", value= {
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="RoleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    List<SysUserRoleEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type=SysUserRoleEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "sysuserroleentity")
    SysUserRoleEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysUserRoleEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysUserRoleEntity record);
}