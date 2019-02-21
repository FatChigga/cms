package com.cms.sys.service;


import com.cms.core.exception.BizException;
import com.cms.core.common.KendoResult;
import com.cms.core.service.BaseService;
import com.cms.sys.entity.SysUserEntity;

import java.util.Map;

public abstract interface SysUserService
  extends BaseService
{
  public abstract KendoResult getUserPaged(Map paramMap);
  
  public abstract Map findUserById(Map paramMap);
  
  public abstract void save(Map paramMap)
    throws Exception;
  
  public abstract void delete(Map paramMap)
    throws BizException;
  
  public abstract void passwordModiy(Map paramMap)
    throws Exception;
  
  public abstract KendoResult findAllUser(Map paramMap);

  public SysUserEntity getUserByAccount(String account);

  public void loginUpdateUser(SysUserEntity sysUserEntity);
}
