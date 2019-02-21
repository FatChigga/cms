package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.Map;

public abstract interface SysPermisionComponentService
        extends BaseService {
    public abstract KendoResult getPermisionComponentPaged(Map paramMap);

    public abstract Map getPermisionComponentById(Map paramMap);

    public abstract void updatePermisionComponent(Map paramMap)
            throws BizException;

    public abstract void deletePermisionComponent(Map paramMap)
            throws BizException;
}


/* Location:              C:\Users\宋羽翔\Desktop\com.cms.core.jar!\com\cms\sys\service\SysPermisionComponentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */