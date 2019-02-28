package com.cms.sys.service;

import com.cms.sys.entity.SysLogLoginEntity;

public abstract interface SysLogLoginService{

    public int saveLoginLog(SysLogLoginEntity sysLogLoginEntity);
}
