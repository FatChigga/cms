package com.cms.core.service;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/* 类名: BaseService
 * 包名: com.sevenbo.service
 * 描述: 通用的baseService
 * 创建时间: 2018/6/11 20:48
 **/
public interface BaseService<T,ID extends Serializable> {

    void setBaseMapper();
    T selectByPrimaryKey(ID id);
    Page<T> selectPageListByObject(int pageNo, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
    List<T> selectListByObject(Object record) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
    T selectByObject(Map<String, Object> record);
}