package com.zhangyan.management.common.util;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-24 15:27
 * 类型转换工具类
 */
public class ConvertUtil {
    public static String objectToString(Object obj){
        return String.valueOf(obj);
    }

    public static String objectToString2(Object obj){
        return (String) obj;
    }

    public static byte[] stringToByte(String str){
        return str.getBytes();
    }
    public static String byteToString(byte[] bs){
        return  new String(bs);
    }

}
