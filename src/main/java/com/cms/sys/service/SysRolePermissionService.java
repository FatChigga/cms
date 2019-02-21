package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysRolePermissionService
        extends BaseService {
    public abstract List<Map> getAllRoleMenuForNode();

    public abstract void doSave(Map paramMap)
            throws BizException;

    public abstract List permissionList(String roleId);
}
