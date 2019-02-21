package com.cms.sys.service;

import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.Map;

public abstract interface SysLogVisitService
        extends BaseService {
    public abstract KendoResult getLogVisitPaged(Map paramMap);
}
