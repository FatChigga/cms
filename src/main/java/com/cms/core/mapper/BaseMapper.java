package com.cms.core.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/** 类名: BaseMapper
 * 包名: com.familyservice.mapper
 * 描述: 通用的baseMapper
 * 创建时间: 2018/7/23 18:10
 **/
public interface BaseMapper<T,ID extends Serializable> {
    int deleteByPrimaryKey(ID id);
    int deleteByObject(T record);
    int insert(T record);
    int insertSelective(T record);
    T selectByPrimaryKey(ID id);
    int updateByPrimaryKeySelective(T record);
    int updateByPrimaryKey(T record);
    List<T> selectListByObject(Map<String, Object> parameter);
    T selectByObject(Map<String, Object> record);
}
