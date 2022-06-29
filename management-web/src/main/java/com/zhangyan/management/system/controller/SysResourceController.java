package com.zhangyan.management.system.controller;

import java.util.*;

import com.zhangyan.management.common.Enums.ResultCodeEnums;
import com.zhangyan.management.common.controller.ComController;
import com.zhangyan.management.common.constant.Constant;
import com.zhangyan.management.common.util.Result;
import com.zhangyan.management.common.util.ResultList;
import com.zhangyan.management.common.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhangyan.management.system.entity.SysResource;
import com.zhangyan.management.system.service.SysResourceService;
import com.zhangyan.management.system.pojo.SysResourceParam;
import com.zhangyan.management.system.pojo.SysResourceDelParam;
import lombok.extern.slf4j.Slf4j;



/**
 * 资源Controller
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@RestController
@RequestMapping("/management/system/resource")
@Api(value = "SysResource", tags = "资源")
@Slf4j
public class SysResourceController extends ComController {

    @Autowired
    private SysResourceService sysResourceService;


    /**
     * 获取资源详细信息
     */
    @ApiOperation(value = "获取 资源 ", notes = "Get SysResource By Id")
    @GetMapping(value = "/getById")
    public Result getInfo(String resourceId)
    {
        if(StringUtils.isNotEmpty(resourceId)) {
            return Result.createSuccessResult(sysResourceService.getById(resourceId));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 新增资源
     */
    @ApiOperation(value = "新增 资源", notes = "Add SysResource")
    @PostMapping(value = "/insert")
    public Result add(@RequestBody SysResource addRequest)
    {
        if(StringUtils.isNotEmpty(addRequest)) {
            return toResult(sysResourceService.insert(addRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 修改资源
     */
    @ApiOperation(value = "修改 资源 ", notes = "Update SysResource By Id")
    @PutMapping(value = "/updateById")
    public Result edit(@RequestBody SysResource updateRequest)
    {
        if(StringUtils.isNotEmpty(updateRequest)) {
            return toResult(sysResourceService.updateByKey(updateRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 删除资源
     */
    @ApiOperation(value = "删除 资源 ", notes = "delete SysResource By Id")
    @DeleteMapping("/deleteById")
    public Result remove(@RequestBody SysResourceDelParam deleteRequest)
    {
        if(StringUtils.isNotEmpty(deleteRequest)&&StringUtils.isNotEmpty(deleteRequest.getId())) {
            return toResult(sysResourceService.deleteById(deleteRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }


    /**
     * 分页查询资源
     */
    @ApiOperation(value = "获取 资源 分页列表", notes = "List SysResource with page")
    @GetMapping(value = "/list")
    public ResultList listEntity(SysResourceParam param){
        if (StringUtils.isNotEmpty(param.getPage()) && (StringUtils.isNotEmpty(param.getLimit()))) {
            return sysResourceService.list(param);
        }
        return ResultList.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 不分页查询资源
     */
    @ApiOperation(value = "获取 资源 列表", notes = "List SysResource all")
    @GetMapping(value = "/datas")
    public  ResultList listAllEntity(SysResourceParam param){
        return sysResourceService.datas(param);
    }
}