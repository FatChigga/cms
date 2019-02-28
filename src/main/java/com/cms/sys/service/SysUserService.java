package com.cms.sys.service;


import com.cms.sys.entity.SysUserEntity;

public abstract interface SysUserService {

  public SysUserEntity getUserByAccount(String account);

  public void loginUpdateUser(SysUserEntity sysUserEntity);
}
