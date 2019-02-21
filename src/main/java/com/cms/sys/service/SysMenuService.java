package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysMenuService
        extends BaseService {
    public abstract List<Map> getAllMenus();

    public abstract List<Map> getALlMenusForNode();

    public abstract void save(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;

    public abstract List<Map> getUserMenus(Integer paramInteger);

    public abstract List<Map> getCurrentPermisions(Integer paramInteger1, Integer paramInteger2);

    public abstract List<Map> getCurrentPermisionsComponent(Integer paramInteger1, Integer paramInteger2);
}
