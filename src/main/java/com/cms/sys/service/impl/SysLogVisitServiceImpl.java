package com.cms.sys.service.impl;

import java.util.Map;

import com.cms.core.common.KendoResult;
import com.cms.core.service.impl.BaseServiceImpl;
import com.cms.core.utils.QueryUtil;
import com.cms.sys.service.SysLogVisitService;
import org.springframework.stereotype.Service;


@Service
public class SysLogVisitServiceImpl
        extends BaseServiceImpl
        implements SysLogVisitService {
    public KendoResult getLogVisitPaged(Map map) {
        KendoResult data = QueryUtil.getRecordsPaged("sysLogVisit.getLogVisitPaged", map);
        return data;
    }
}
