package com.cms.core.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 82448 on 2019/1/11.
 */
@Component
public class HostInterceptor implements HandlerInterceptor {


    private final static Logger loger = LoggerFactory.getLogger(HostInterceptor.class);

    @Value("${hostWhites}")
    private String hostWhites;

    public List<String> getHostWhiteList(){
        List<String> hostWhiteList = new ArrayList<>();
        String[] hosts = hostWhites.split(",");
        for (int i = 0; i < hosts.length; i++) {
            hostWhiteList.add(hosts[i]);
        }
        return hostWhiteList;
    }
    public boolean whiteHost(String host) throws Exception{
        List<String> hostWhite = getHostWhiteList();
        if(!hostWhite.contains(host)){
            return false;
        }
        return true;
    }

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        String host =  httpServletRequest.getHeader("host");
        //loger.error(host);
        //System.out.println(host);
        if(StringUtils.isNotBlank(host) && StringUtils.isNotEmpty(host)){
            return whiteHost(host);
        }else{
            return true;
        }
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
