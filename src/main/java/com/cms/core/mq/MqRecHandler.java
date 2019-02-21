package com.cms.core.mq;

import com.cms.sys.entity.SysLogEntity;
import com.cms.sys.mapper.SysLogEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "operationLog", containerFactory = "pointTaskContainerFactory")
public class MqRecHandler{
    private static final Logger logger = LoggerFactory.getLogger(MqRecHandler.class);

    @Autowired
    SysLogEntityMapper sysLogEntityMapper;

    @RabbitHandler
    public void handleMessage(SysLogEntity sysLogEntity) throws Exception {
        try{
            sysLogEntityMapper.insertSelective(sysLogEntity);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
