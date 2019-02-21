package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysBizParamsService
        extends BaseService {
    public abstract KendoResult getBizParamsPaged(Map paramMap);

    public abstract Map findParam(Map paramMap);

    public abstract void update(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;

    public abstract List getBizParam(String paramString);

    public abstract List<Map> getAllBizParamsForNode();
}
