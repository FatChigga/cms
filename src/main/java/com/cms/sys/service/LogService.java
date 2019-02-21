package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.Map;

public abstract interface LogService
        extends BaseService {
    public abstract KendoResult getLogPaged(Map paramMap);

    public abstract void deleteLogById(Map paramMap)
            throws BizException;

    public abstract void deleteLogAll()
            throws BizException;
}