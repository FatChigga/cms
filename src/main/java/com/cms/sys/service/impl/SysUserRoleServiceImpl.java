package com.cms.sys.service.impl;

import com.cms.core.service.impl.BaseServiceImpl;
import com.cms.sys.entity.SysUserRoleEntity;
import com.cms.sys.mapper.SysUserRoleEntityMapper;
import com.cms.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songyuxiang
 */
@Service
public class SysUserRoleServiceImpl
        extends BaseServiceImpl<SysUserRoleEntity,String>
        implements SysUserRoleService {

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(sysUserRoleEntityMapper);
    }

    @Autowired
    private SysUserRoleEntityMapper sysUserRoleEntityMapper;

    @Override
    public List<SysUserRoleEntity> roleListByUserId(Integer userId){
        Map param = new HashMap();
        param.put("userid",userId);
        List<SysUserRoleEntity> list = sysUserRoleEntityMapper.selectListByObject(param);
        return list;
    }
}
