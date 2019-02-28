package com.cms.sys.service.impl;

import com.cms.core.service.impl.BaseServiceImpl;
import com.cms.sys.entity.SysUserEntity;
import com.cms.sys.mapper.SysUserEntityMapper;
import com.cms.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songyuxiang
 */
@Service
public class SysUserServiceImpl
        extends BaseServiceImpl<SysUserEntity,String> implements SysUserService {

    @Autowired
    private SysUserEntityMapper sysUserEntityMapper;

    @Override
    public SysUserEntity getUserByAccount(String account) {
        Map param = new HashMap();
        param.put("loginname",account);
        SysUserEntity sysUserEntity = sysUserEntityMapper.selectByObject(param);
        return sysUserEntity;
    }

    @Override
    public void loginUpdateUser(SysUserEntity sysUserEntity){
        sysUserEntityMapper.updateByPrimaryKeySelective(sysUserEntity);
    }

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(sysUserEntityMapper);
    }
}

