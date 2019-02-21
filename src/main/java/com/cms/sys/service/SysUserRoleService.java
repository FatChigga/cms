package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysUserRoleService
        extends BaseService {
    public abstract List<Map> getAllUserRoleForNode();

    public abstract void doSave(Map paramMap)
            throws BizException;

    public abstract List roleList(Map paramMap);

    public List roleListByUserId(Integer userId);
}
