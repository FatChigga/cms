package com.cms.sys.mapper;

import com.cms.core.mapper.BaseMapper;
import com.cms.sys.entity.SysRolePermissionEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysRolePermissionEntityMapper extends BaseMapper<SysRolePermissionEntity,String> {
    @Delete({
        "delete from sys_role_permission",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_role_permission (Id, RoleId, ",
        "PermisionId)",
        "values (#{id,jdbcType=BIGINT}, #{roleid,jdbcType=BIGINT}, ",
        "#{permisionid,jdbcType=INTEGER})"
    })
    int insert(SysRolePermissionEntity record);

    @InsertProvider(type=SysRolePermissionEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysRolePermissionEntity record);

    @Select({
        "select",
        "Id, RoleId, PermisionId",
        "from sys_role_permission",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="RoleId", property="roleid", jdbcType=JdbcType.BIGINT),
        @Result(column="PermisionId", property="permisionid", jdbcType=JdbcType.INTEGER)
    })
    SysRolePermissionEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysRolePermissionEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRolePermissionEntity record);

    @Update({
        "update sys_role_permission",
        "set RoleId = #{roleid,jdbcType=BIGINT},",
          "PermisionId = #{permisionid,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysRolePermissionEntity record);

    @SelectProvider(type=SysRolePermissionEntitySqlProvider.class, method="selectByObject")
    @Results(id = "sysrolepermissionentity", value= {
        @Result(column="Id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="RoleId", property="roleid", jdbcType=JdbcType.BIGINT),
        @Result(column="PermisionId", property="permisionid", jdbcType=JdbcType.INTEGER)
    })
    List<SysRolePermissionEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type=SysRolePermissionEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "sysrolepermissionentity")
    SysRolePermissionEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysRolePermissionEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysRolePermissionEntity record);
}