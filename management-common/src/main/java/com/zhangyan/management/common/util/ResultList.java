package com.zhangyan.management.common.util;

import com.alibaba.fastjson.JSON;
import com.zhangyan.management.common.Enums.ResultCodeEnums;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-22 15:46
 */
public class ResultList<T> implements Serializable {
    private static final long serialVersionUID = 5616070434977448606L;
    private boolean success;
    private String resultCode;
    private String msg;
    private List<T> data;
    public long startTime;
    public long timeConsum;
    public long total;

    public static <W> ResultList<W> createFailResult() {
        ResultList<W> ret = new ResultList<>();
        ret.setResultCode(ResultCodeEnums.ERROR.getCode());
        ret.setMsg(ResultCodeEnums.ERROR.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> ResultList<W> createFailResult(String msg) {
        ResultList<W> ret = new ResultList<>();
        ret.setSuccess(false);
        ret.setResultCode(ResultCodeEnums.ERROR.getCode());
        ret.setMsg(msg);
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> ResultList<W> createFailResult(String code,String msg) {
        ResultList<W> ret = new ResultList<>();
        ret.setSuccess(false);
        ret.setResultCode(code);
        ret.setMsg(msg);
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> ResultList<W> createFailResult(ResultCodeEnums code) {
        ResultList<W> ret = new ResultList<>();
        ret.setSuccess(false);
        ret.setResultCode(code.getCode());
        ret.setMsg(code.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> ResultList<W> createFailResult(ResultList result) {
        ResultList<W> ret = new ResultList<>();
        ret.setSuccess(false);
        ret.setResultCode(result.getResultCode());
        ret.setMsg(result.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public ResultList() {
        this.resultCode = ResultCodeEnums.SUCCESS.getCode();
        this.startTime = -1L;
    }

    public static <T> ResultList<T> createSuccessResult(List<T> val,String total) {
        ResultList<T> ret = new ResultList<>();
        ret.setSuccess(true);
        ret.setResultCode(ResultCodeEnums.SUCCESS.getCode());
        ret.setMsg(ResultCodeEnums.SUCCESS.getMsg());
        ret.setData(val);
        ret.setTotal(total);
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <T> ResultList<T> createSuccessResult(List<T> val) {
        ResultList<T> ret = new ResultList<>();
        ret.setSuccess(true);
        ret.setResultCode(ResultCodeEnums.SUCCESS.getCode());
        ret.setMsg(ResultCodeEnums.SUCCESS.getMsg());
        ret.setData(val);
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public static <W> ResultList<W> createSuccessResult() {
        ResultList<W> ret = new ResultList<>();
        ret.setSuccess(true);
        ret.setResultCode(ResultCodeEnums.SUCCESS.getCode());
        ret.setMsg(ResultCodeEnums.SUCCESS.getMsg());
        ret.startTime = System.currentTimeMillis();
        return ret;
    }

    public void setTotal(String total) {
        this.total = Long.valueOf(total);
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Long getTotal() {
        return this.total;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(final List<T> data) {
        this.data = data;
        this.timeConsum = System.currentTimeMillis() - this.startTime;
    }
    public boolean isSuccess() {
        return this.success;
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
