package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysRoleService
        extends BaseService {
    public abstract KendoResult getRolePaged(Map paramMap);

    public abstract Map findUserById(Map paramMap);

    public abstract void update(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;

    public abstract List getRoleList();
}
