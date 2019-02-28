package com.cms.sys.service.impl;

import com.cms.core.service.impl.BaseServiceImpl;
import com.cms.sys.service.SysParamService;
import com.cms.sys.entity.SysDictionaryEntity;
import com.cms.sys.mapper.SysDictionaryEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author songyuxiang
 */
@Service
public class SysParamServiceImpl
        extends BaseServiceImpl<SysDictionaryEntity,String>
        implements SysParamService {

    @Autowired
    SysDictionaryEntityMapper sysDictionaryEntityMapper;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(sysDictionaryEntityMapper);
    }

    @Override
    public Map getSysParam(String key, Boolean isAll) {
        List<SysDictionaryEntity> dictionaryList = sysDictionaryEntityMapper.selectByKeyCode(key);
        Map<String,String> dictionaryEntityMap =
            dictionaryList.stream().collect(Collectors.toMap(x -> x.getKeyvalue(),x -> x.getText()));
        return dictionaryEntityMap;
    }
}
