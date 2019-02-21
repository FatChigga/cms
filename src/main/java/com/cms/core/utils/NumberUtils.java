package com.cms.core.utils;

import java.util.Random;

/**
 * 类名: NumberUtils
 * 包名: com.msf.materialproductservice.utils
 * 描述: 数字处理工具类
 * 创建人: sunpenglin
 * 创建时间: 2018/1/15 14:22
 **/
public class NumberUtils {
    /*普通数字*/
    public static final Integer NB_Zero = 0;
    public static final Integer NB_One = 1;
    public static final Integer NB_Two = 2;
    public static final Integer NB_Three = 3;
    public static final Integer NB_Four = 4;
    public static final Integer NB_Five = 5;
    public static final Integer NB_Six = 6;
    public static final Integer NB_Seven = 7;
    public static final Integer NB_Eight = 8;
    public static final Integer NB_Nine = 9;
    public static final Integer NB_Ten = 10;
    public static final Integer NB_Eleven = 11;
    public static final Integer NB_Twelve = 12;
    public static final Integer NB_Fifteen = 15;
    public static final Integer NB_Twenty = 20;
    public static final Integer NB_Thirty = 30;
    public static final Integer NB_Thirty_One = 31;
    public static final Integer NB_Thirty_Two = 32;
    public static final Integer NB_Thirty_Four = 34;
    public static final Integer NB_Thirty_Eight = 38;
    public static final Integer NB_Forty = 40;
    public static final Integer NB_Fifty = 50;
    public static final Integer NB_Sixty = 60;
    public static final Integer NB_Seventy = 70;
    public static final Integer NB_Eighty = 80;
    public static final Integer NB_Ninety = 90;
    public static final Integer Nb_Hundred = 100;

    /*http请求返回code*/
    public static final Integer CODE_200 = 200;//正常
    public static final Integer CODE_99 = 99;//业务异常
    public static final Integer CODE_999 = 999;//系统异常 报错
    public static final Integer CODE_1000 = 1000;//停用行业时该行业有店铺关联，不可停用
    public static final Integer CODE_1001 = 1001;//行业名重复
    public static final Integer CODE_1002 = 1002;//行业属性名重复
    public static final Integer CODE_1003 = 1003;//行业属性值名重复
    public static final Integer CODE_2001 = 2001;//消息推送失败
    public static final Integer CODE_2002 = 2002;//验证失败
    public static final Integer CODE_2003 = 2003;//流水号有误
    public static final Integer CODE_2004 = 2004;//状态有误
    public static final Integer CODE_2005 = 2005;//申请类型有误
    /**
     * 方法名称: getSix
     * 参数: []
     * 返回类型: java.lang.String
     * 描述: 生成随机6位数字
     * 创建人: sunpenglin
     * 创建时间: 2018/1/15 14:22
     **/
    public static String getSix() {
        Random rad = new Random();
        String result = rad.nextInt(1000000) + "";
        if (result.length() != 6) {
            return getSix();
        }
        return result;
    }
}
