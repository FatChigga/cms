package com.cms.sys.service;

import com.cms.core.exception.BizException;
import com.cms.core.service.BaseService;

import java.util.Map;

public abstract interface LoginService
        extends BaseService {
    public abstract Map Login(Map paramMap)
            throws BizException;
}
