package com.cms.core.config;

import com.cms.core.exception.BizException;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/** 类名: RequestLimitContract
 * 包名: com.familyservice.config
 * 描述: 请求限制判断
 **/
@Aspect
@Component
public class RequestLimitContract {

    private static final Logger logger = LoggerFactory.getLogger("requestLimitLogger");
    private Map<String , Integer> redisTemplate = new HashMap<>();

    @Before("within(@org.springframework.stereotype.Controller *) && @annotation(limit)")
    public void requestLimit(final JoinPoint joinPoint , RequestLimit limit) throws BizException {
        try {
            Object[] args = joinPoint.getArgs();
            HttpServletRequest request = null;
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof HttpServletRequest) {
                    request = (HttpServletRequest) args[i];
                    break;
                }
            }
            if (request == null) {
                throw new BizException("方法中缺失HttpServletRequest参数");
            }
            String ip = request.getLocalAddr();
            String url = request.getRequestURL().toString();
            String key = "req_limit_".concat(url).concat(ip);
            if (redisTemplate.get(key) == null || redisTemplate.get(key) == 0) {
                redisTemplate.put(key, 1);
            } else {
                redisTemplate.put(key, redisTemplate.get(key) + 1);
            }
            int count = redisTemplate.get(key);
            if (count > 0) {
                //这个线程设定在time规定的时间之后会执行上面的remove方法，也就是说在这个时间后它可以重新访问
                ThreadFactory threadFactory =
                        new ThreadFactoryBuilder().setNameFormat("request-limit-pool-%d").build();
                ScheduledExecutorService scheduledExecutorService =
                        new ScheduledThreadPoolExecutor(1,threadFactory);
                scheduledExecutorService.schedule(() -> redisTemplate.remove(key),limit.time(), TimeUnit.MILLISECONDS);
            }
            if (count > limit.count()) {
                logger.info("用户IP[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + limit.count() + "]");
                throw new BizException("访问频繁，请一分钟后再试！");
            }
        }catch (BizException e){
            throw e;
        }catch (Exception e){
            logger.error("发生异常",e);
        }
    }

}
