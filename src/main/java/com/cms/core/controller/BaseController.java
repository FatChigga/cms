package com.cms.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.cms.core.utils.MessageUtils;
import com.cms.core.utils.NumberUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/** 类名: BaseController
 * 包名: com.familyservice.base
 * 描述: 所有controller公用继承类
 **/
public class BaseController<T> {

    public JSONObject commonReturn(Integer code, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject;
    }

    public JSONObject commonReturn(Integer code, String msg, List<T> rows) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        jsonObject.put("rows", rows);
        return jsonObject;
    }

    public JSONObject commonReturn(Integer code, String msg, List<T> rows, long total) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        jsonObject.put("rows", rows);
        jsonObject.put("total", total);
        return jsonObject;
    }

    public JSONObject commonReturn(Integer code, String msg, T object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        jsonObject.put("data", object);
        return jsonObject;
    }

    public ResponseEntity<JSONObject> success(Object data) {
        JSONObject result = commonReturn(NumberUtils.CODE_200, MessageUtils.SUCCESS);
        if (data != null) {
            if (data instanceof List) {
                result.put("rows", data);
            } else {
                result.put("data", data);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<JSONObject> success(List<T> data,long total){
        JSONObject result = commonReturn(NumberUtils.CODE_200, MessageUtils.SUCCESS);
        result.put("rows", data);
        result.put("total",total);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    public ResponseEntity<JSONObject> error(){
        JSONObject result = commonReturn(NumberUtils.CODE_999, MessageUtils.FAIL);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<JSONObject> error(String message) {
        JSONObject result = commonReturn(NumberUtils.CODE_999, message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<JSONObject> success(){
        JSONObject result = commonReturn(NumberUtils.CODE_200, MessageUtils.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
