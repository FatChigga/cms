package com.cms.core.utils;

import com.cms.core.exception.BizException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class IpGet {

    public static List<String> getIpWhiteList(){
        List<String> ipWhiteList = new ArrayList<>();
        String yl = "110.185.168.6";
        String node = "114.215.69.1";
        ipWhiteList.add(yl);
        ipWhiteList.add(node);
        return ipWhiteList;
    }

    public static void whiteIp(HttpServletRequest request) throws Exception{
        String ip = getIpAddress(request);
        List<String> ipWhite = getIpWhiteList();
        if(!ipWhite.contains(ip)){
            throw new BizException("白名单限制");
        }
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
