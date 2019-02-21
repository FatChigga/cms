package com.cms.core.common;


import com.cms.core.shiro.MyShiroRealm;
import com.cms.core.utils.DateUtil;
import com.cms.core.utils.IpGet;
import com.cms.core.utils.JsonUtil;
import com.cms.sys.entity.SysLogEntity;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Order(2)
@Aspect
@Component
public class LoggerAspect {

    @Autowired
    AmqpTemplate amqpTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Pointcut("execution(* com.cms.sys.controller.*.*(..))")
    public void logPoint() {
    }

    private Date startTime; // 开始时间
    private Date endTime; // 结束时间

    @Before("logPoint()")
    public void doBeforeInServiceLayer(JoinPoint joinPoint){
        if(SecurityUtils.getSubject().getPrincipal() != null){
            SysLogEntity sysLogEntity = new SysLogEntity();

            sysLogEntity.setMethod(joinPoint.getSignature().getName());

            sysLogEntity.setMethodlocation(joinPoint.getTarget().getClass().toString());

            sysLogEntity.setParam(JsonUtil.getJson(joinPoint.getArgs()));

            RequestMapping requestMapping =
                    ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(RequestMapping.class);

            sysLogEntity.setRemark(requestMapping.name());

            sysLogEntity.setUserid(Integer.parseInt(((MyShiroRealm.ShiroUser) SecurityUtils.getSubject().
                    getPrincipal()).getId()));

            sysLogEntity.setUsername(((MyShiroRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal()).getRealName());

            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes)ra;
            HttpServletRequest request = sra.getRequest();

            sysLogEntity.setIpaddress(IpGet.getIpAddress(request));

            sysLogEntity.setCreatedate(new Date());

            amqpTemplate.convertAndSend("operationLog",sysLogEntity);
        }
    }

    @AfterReturning("logPoint()")
    public void afterRunningAdvice(JoinPoint joinPoint) throws ParseException {

    }
}