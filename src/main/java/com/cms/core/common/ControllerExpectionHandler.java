package com.cms.core.common;

import com.alibaba.fastjson.JSONObject;
import com.cms.core.exception.BizException;
import com.cms.core.exception.ServiceException;
import com.cms.core.exception.UploadException;
import com.cms.core.utils.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by songyuxiang on 2019/2/15.
 */

@ControllerAdvice
public class ControllerExpectionHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler
    public ResponseEntity<JSONObject> expHandler (Exception ex){
        JSONObject result = new JSONObject();
        if(ex instanceof ServiceException){
            result.put("code", NumberUtils.CODE_99);
            result.put("msg", ex.getMessage());
            logger.error("业务异常：" + ex.getMessage());
            StackTraceElement ste = ex.getStackTrace()[0];
            logger.error("类：" + ste.getClassName() + "方法：" + ste.getMethodName() + "行号：" + ste.getLineNumber());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else if(ex instanceof UploadException){
            result.put("code", NumberUtils.CODE_99);
            result.put("msg", ex.getMessage());
            logger.error("上传异常：" + ex.getMessage());
            StackTraceElement ste = ex.getStackTrace()[0];
            logger.error("类：" + ste.getClassName() + "方法：" + ste.getMethodName() + "行号：" + ste.getLineNumber());
            return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
        }else if(ex instanceof BizException){
            result.put("code",NumberUtils.CODE_99);
            result.put("msg", StringUtils.join(((BizException) ex).getMessages(),"</br>"));
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else if(ex instanceof UnauthorizedException){
            result.put("code", NumberUtils.CODE_999);
            result.put("msg", "权限不足");
            logger.error("权限不足：" + ex.getMessage());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            result.put("code", NumberUtils.CODE_999);
            result.put("msg", "系统繁忙");
            logger.error("系统异常：" + ex.getMessage());
            StackTraceElement[] stes = ex.getStackTrace();
            for (int i = 0; i < stes.length; i++) {
                if (i <= 10) {
                    StackTraceElement ste = stes[i];
                    logger.error("类：" + ste.getClassName() + " 方法：" + ste.getMethodName() + " 行号：" + ste.getLineNumber());
                }
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
