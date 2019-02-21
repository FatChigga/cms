package com.cms.core.service.impl;

import com.cms.core.dao.BasicDao;
import com.cms.core.service.BaseService;
import com.cms.core.utils.BaseUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BaseServiceImpl
        implements BaseService {
    public SqlSessionTemplate getDao() {
        BasicDao basicDao = (BasicDao) BaseUtil.getService("basicDao");
        SqlSessionTemplate sqlSession = basicDao.getSqlSessionTemplate();

        return sqlSession;
    }

    public Logger log = LoggerFactory.getLogger(getClass());
}