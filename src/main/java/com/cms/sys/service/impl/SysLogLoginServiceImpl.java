package com.cms.sys.service.impl;

import com.cms.core.common.KendoResult;
import com.cms.core.service.impl.BaseServiceImpl;
import com.cms.core.utils.QueryUtil;
import com.cms.sys.entity.SysLogEntity;
import com.cms.sys.entity.SysLogLoginEntity;
import com.cms.sys.mapper.SysLogEntityMapper;
import com.cms.sys.mapper.SysLogLoginEntityMapper;
import com.cms.sys.service.SysLogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysLogLoginServiceImpl
        extends BaseServiceImpl
        implements SysLogLoginService {

    @Autowired
    SysLogLoginEntityMapper sysLogLoginEntityMapper;

    public KendoResult getLogLoginPaged(Map map) {
        KendoResult data = QueryUtil.getRecordsPaged("sysLogLogin.getLogLoginPaged", map);
        return data;
    }

    public List getLogLoginLatest() {
        List list = getDao().selectList("sysLogLogin.getLogLoginLatest");
        return list;
    }

    public int saveLoginLog(SysLogLoginEntity sysLogLoginEntity){
        return sysLogLoginEntityMapper.insertSelective(sysLogLoginEntity);
    }
}
