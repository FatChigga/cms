package com.cms.sys.service;

import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;
import com.cms.sys.entity.SysLogEntity;
import com.cms.sys.entity.SysLogLoginEntity;

import java.util.List;
import java.util.Map;

public abstract interface SysLogLoginService
        extends BaseService {
    public abstract KendoResult getLogLoginPaged(Map paramMap);

    public abstract List getLogLoginLatest();

    public int saveLoginLog(SysLogLoginEntity sysLogLoginEntity);
}
