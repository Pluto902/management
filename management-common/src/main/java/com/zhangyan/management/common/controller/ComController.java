package com.zhangyan.management.common.controller;

import com.zhangyan.management.common.util.Result;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-22 11:35
 * 公共controller
 */
public class ComController {



    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected Result toResult(int rows)
    {
        return rows > 0 ? Result.createSuccessResult() : Result.createFailResult();
    }


}
