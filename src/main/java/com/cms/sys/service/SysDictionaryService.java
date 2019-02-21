package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.Map;

public abstract interface SysDictionaryService
        extends BaseService {
    public abstract KendoResult getDictionaryPaged(Map paramMap);

    public abstract Map findDictionary(Map paramMap);

    public abstract void update(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;
}


/* Location:              C:\Users\宋羽翔\Desktop\com.cms.core.jar!\com\cms\sys\service\SysDictionaryService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */