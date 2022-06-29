package com.zhangyan.management.common.util;

import com.alibaba.fastjson.JSON;
import com.zhangyan.management.common.Enums.ResultCodeEnums;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-24 15:11
 * 返回结果工具
 */
@ApiModel(description = "Result类")
public class Result<T> extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 5616070434977448606L;
    private boolean success;
    private String resultCode;
    private String msg;
    private T data;
    private List<T> datas;
    public long startTime;
    public long timeConsum;
    public long total;
    private static final String HOSTNAME = (String)System.getenv().get("COMPUTERNAME");

    public static <W> Result<W> createFailResult() {
        Result<W> ret = new Result<>();
        ret.setResultCode(ResultCodeEnums.ERROR.getCode());
        ret.setMsg(ResultCodeEnums.ERROR.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> Result<W> createFailResult(String msg) {
        Result<W> ret = new Result<>();
        ret.setSuccess(false);
        ret.setResultCode(ResultCodeEnums.ERROR.getCode());
        ret.setMsg(msg);
        ret.startTime = System.currentTimeMillis();
        return ret;
    }
    public static <W> Result<W> createFailResult(String msg,W val) {
        Result<W> ret = new Result<>();
        ret.setSuccess(false);
        ret.setResultCode(ResultCodeEnums.ERROR.getCode());
        ret.setMsg(msg);
        ret.data = val;
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> Result<W> createFailResult(String code,String msg) {
        Result<W> ret = new Result<>();
        ret.setSuccess(false);
        ret.setResultCode(code);
        ret.setMsg(msg);
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> Result<W> createFailResult(ResultCodeEnums code) {
        Result<W> ret = new Result<>();
        ret.setSuccess(false);
        ret.setResultCode(code.getCode());
        ret.setMsg(code.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> Result<W> createFailResult(Result result) {
        Result<W> ret = new Result<>();
        ret.setSuccess(false);
        ret.setResultCode(result.getResultCode());
        ret.setMsg(result.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public Result() {
        this.resultCode = ResultCodeEnums.SUCCESS.getCode();
        this.startTime = -1L;
    }

    public static <W> Result<W> createSuccessResult() {
        Result<W> ret = new Result<>();
        ret.setSuccess(true);
        ret.setResultCode(ResultCodeEnums.SUCCESS.getCode());
        ret.setMsg(ResultCodeEnums.SUCCESS.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }


    public static <T> Result<T> createSuccessResult(T val) {
        Result<T> ret = new Result<>();
        ret.setSuccess(true);
        ret.setResultCode(ResultCodeEnums.SUCCESS.getCode());
        ret.setMsg(ResultCodeEnums.SUCCESS.getMsg());
        ret.value(val);
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public Result<T> value(T val) {
        if(val == null) {
            return this;
        } else {
            this.success = true;
            this.data = val;
            this.setMsg(ResultCodeEnums.SUCCESS.getMsg());
            this.setResultCode(ResultCodeEnums.SUCCESS.getCode());
            this.timeConsum = System.currentTimeMillis() - this.startTime;
            return this;
        }
    }


    public Result<T> put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }

    public T value() {
        return this.data;
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
        this.timeConsum = System.currentTimeMillis() - this.startTime;
    }



    public boolean isSuccess() {
        return this.success;
    }

    private static String id() {
        return HOSTNAME + "-" + System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }


//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("3");
//        Result<String> result = createSuccessResult(list,2L);
//        System.out.println(result.toString());
//    }

    public void setSuccess(boolean success) {
        this.success = success;
        this.timeConsum = System.currentTimeMillis() - this.startTime;
    }

    public long getTimeConsum() {
        return this.timeConsum;
    }

    public void setTimeConsum(long timeConsum) {
        this.timeConsum = timeConsum;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}