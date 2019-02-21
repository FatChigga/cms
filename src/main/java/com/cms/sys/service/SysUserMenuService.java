package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysUserMenuService
        extends BaseService {
    public abstract List<Map> getAllUserMenuForNode();

    public abstract void doSave(Map paramMap)
            throws BizException, BizException;

    public abstract List menuList(Map paramMap);
}
