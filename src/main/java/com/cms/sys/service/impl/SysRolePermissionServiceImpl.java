package com.cms.sys.service.impl;

import com.cms.core.service.impl.BaseServiceImpl;
import com.cms.sys.entity.SysRolePermissionEntity;
import com.cms.sys.mapper.SysPermissionEntityMapper;
import com.cms.sys.mapper.SysRolePermissionEntityMapper;
import com.cms.sys.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songyuxiang
 */
@Service
public class SysRolePermissionServiceImpl
        extends BaseServiceImpl<SysRolePermissionEntity,String>
        implements SysRolePermissionService {

    @Autowired
    SysPermissionEntityMapper sysPermissionEntityMapper;

    @Autowired
    SysRolePermissionEntityMapper sysRolePermissionEntityMapper;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(sysRolePermissionEntityMapper);
    }

    @Override
    public List permissionList(String roleId) {
        List list = sysPermissionEntityMapper.getPermissionListByRoleId(roleId);
        return list;
    }
}
