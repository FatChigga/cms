package com.cms.sys.service.impl;

import com.cms.core.service.impl.BaseServiceImpl;
import com.cms.sys.entity.SysLogLoginEntity;
import com.cms.sys.mapper.SysLogLoginEntityMapper;
import com.cms.sys.service.SysLogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author songyuxiang
 */
@Service
public class SysLogLoginServiceImpl
        extends BaseServiceImpl<SysLogLoginEntity,String>
        implements SysLogLoginService {

    @Autowired
    SysLogLoginEntityMapper sysLogLoginEntityMapper;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(sysLogLoginEntityMapper);
    }

    @Override
    public int saveLoginLog(SysLogLoginEntity sysLogLoginEntity){
        return sysLogLoginEntityMapper.insertSelective(sysLogLoginEntity);
    }
}
