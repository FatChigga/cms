package com.cms.sys.service;

import java.util.Map;

public abstract interface SysParamService{

    public abstract Map getSysParam(String paramString, Boolean paramBoolean);
}