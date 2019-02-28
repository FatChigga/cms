package com.cms.core.service.impl;

import com.cms.core.mapper.BaseMapper;
import com.cms.core.shiro.MyShiroRealm;
import com.cms.core.service.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseMapper<T, ID> baseMapper;

    @Autowired
    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    /** 方法名称: setParams
     * 参数: [parameter]
     * 返回类型: java.util.Map        
     * 描述: 参数转换 封装
     * 创建时间: 2018/7/16 11:23
     **/
    public Map setParams(Object parameter)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Map params = new HashMap();
        if (parameter != null) {
            if (parameter instanceof Map) {
                params.putAll((Map) parameter);
            } else {
                Map parameterObject = PropertyUtils.describe(parameter);
                params.putAll(parameterObject);
            }
        }
        return params;
    }

    @Override
    public Page<T> selectPageListByObject(int pageNo,int pageSize,Object parameter)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Map params = setParams(parameter);
        //分页插件: 查询第1页，每页10行
        Page<T> page =PageHelper.startPage(pageNo, pageSize);
        baseMapper.selectListByObject(params);
        return page;
    }

    @Override
    public List<T> selectListByObject(Object parameter)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Map params = setParams(parameter);
        return baseMapper.selectListByObject(params);
    }

    @Override
    public T selectByObject(Map<String, Object> record) {
        return baseMapper.selectByObject(record);
    }

    /** 方法名称: createId
     * 参数: []
     * 返回类型: java.lang.String        
     * 描述: 创建主键ID
     * 创建时间: 2018/7/16 11:11
     **/
    public String createId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 获取当前登录用户信息.
     */
    public static MyShiroRealm.ShiroUser getCurrentUser() {
        return (MyShiroRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 取出Shiro中的当前用户Id.
     */
    public static String getCurrentUserId() {
        MyShiroRealm.ShiroUser user = (MyShiroRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        if (null != user) {
            return user.getId();
        }
        return null;
    }
}
