package com.cms.sys.mapper;

import com.cms.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.cms.sys.entity.SysDictionaryEntity;
import com.cms.sys.entity.SysDictionaryEntityKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDictionaryEntityMapper extends BaseMapper<SysDictionaryEntity, String> {
    @Delete({
        "delete from sys_dictionary",
        "where KeyCode = #{keycode,jdbcType=VARCHAR}",
          "and KeyValue = #{keyvalue,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(SysDictionaryEntityKey key);

    @Insert({
        "insert into sys_dictionary (KeyCode, KeyValue, ",
        "`Text`, IsEnable, ",
        "IsVisible, OrderNum, ",
        "Remark)",
        "values (#{keycode,jdbcType=VARCHAR}, #{keyvalue,jdbcType=VARCHAR}, ",
        "#{text,jdbcType=VARCHAR}, #{isenable,jdbcType=TINYINT}, ",
        "#{isvisible,jdbcType=BIT}, #{ordernum,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(SysDictionaryEntity record);

    @InsertProvider(type=SysDictionaryEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SysDictionaryEntity record);

    @Select({
        "select",
        "KeyCode, KeyValue, `Text`, IsEnable, IsVisible, OrderNum, Remark",
        "from sys_dictionary",
        "where KeyCode = #{keycode,jdbcType=VARCHAR}",
          "and KeyValue = #{keyvalue,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="KeyCode", property="keycode", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="KeyValue", property="keyvalue", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="Text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsEnable", property="isenable", jdbcType=JdbcType.TINYINT),
        @Result(column="IsVisible", property="isvisible", jdbcType=JdbcType.BIT),
        @Result(column="OrderNum", property="ordernum", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    SysDictionaryEntity selectByPrimaryKey(SysDictionaryEntityKey key);

    @UpdateProvider(type=SysDictionaryEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDictionaryEntity record);

    @Update({
        "update sys_dictionary",
        "set `Text` = #{text,jdbcType=VARCHAR},",
          "IsEnable = #{isenable,jdbcType=TINYINT},",
          "IsVisible = #{isvisible,jdbcType=BIT},",
          "OrderNum = #{ordernum,jdbcType=INTEGER},",
          "Remark = #{remark,jdbcType=VARCHAR}",
        "where KeyCode = #{keycode,jdbcType=VARCHAR}",
          "and KeyValue = #{keyvalue,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysDictionaryEntity record);

    @SelectProvider(type=SysDictionaryEntitySqlProvider.class, method="selectByObject")
    @Results(id = "sysdictionaryentity", value= {
        @Result(column="KeyCode", property="keycode", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="KeyValue", property="keyvalue", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="Text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsEnable", property="isenable", jdbcType=JdbcType.TINYINT),
        @Result(column="IsVisible", property="isvisible", jdbcType=JdbcType.BIT),
        @Result(column="OrderNum", property="ordernum", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<SysDictionaryEntity> selectListByObject(Map<String, Object> record);

    @SelectProvider(type=SysDictionaryEntitySqlProvider.class, method="selectByObject")
    @ResultMap(value = "sysdictionaryentity")
    SysDictionaryEntity selectByObject(Map<String, Object> record);

    @DeleteProvider(type=SysDictionaryEntitySqlProvider.class, method="deleteByObject")
    int deleteByObject(SysDictionaryEntity record);

    @Select({
            "select",
            "KeyCode, KeyValue, `Text`, IsEnable, IsVisible, OrderNum, Remark",
            "from sys_dictionary",
            "where KeyCode = #{keycode,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="KeyCode", property="keycode", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="KeyValue", property="keyvalue", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="Text", property="text", jdbcType=JdbcType.VARCHAR),
            @Result(column="IsEnable", property="isenable", jdbcType=JdbcType.TINYINT),
            @Result(column="IsVisible", property="isvisible", jdbcType=JdbcType.BIT),
            @Result(column="OrderNum", property="ordernum", jdbcType=JdbcType.INTEGER),
            @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<SysDictionaryEntity> selectByKeyCode(String keyCode);
}