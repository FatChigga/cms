package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface SysOrganizationService
        extends BaseService {
    public abstract List<Map> getALlOrganizationsForNode();

    public abstract void save(Map paramMap)
            throws BizException;

    public abstract void delete(Map paramMap)
            throws BizException;

    public abstract KendoResult getOrgOptions(Map paramMap);
}


/* Location:              C:\Users\宋羽翔\Desktop\com.cms.core.jar!\com\cms\sys\service\SysOrganizationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */