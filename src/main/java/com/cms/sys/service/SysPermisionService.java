package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.Map;

public abstract interface SysPermisionService
        extends BaseService {
    public abstract KendoResult getPermisionPaged(Map paramMap);

    public abstract Map findPermisionById(Map paramMap);

    public abstract void update(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;
}
