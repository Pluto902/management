package com.zhangyan.management.system.controller;

import com.zhangyan.management.common.Enums.ResultCodeEnums;
import com.zhangyan.management.common.controller.ComController;
import com.zhangyan.management.common.util.Result;
import com.zhangyan.management.common.util.ResultList;
import com.zhangyan.management.common.util.StringUtils;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhangyan.management.system.entity.SysUser;
import com.zhangyan.management.system.service.SysUserService;
import com.zhangyan.management.system.pojo.SysUserParam;
import com.zhangyan.management.system.pojo.SysUserDelParam;



/**
 * 系统用户Controller
 *
 * @author ZhangYan
 * @date 2022-06-23
 */

@RestController
@RequestMapping("/management/user")
public class SysUserController extends ComController {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 获取系统用户详细信息
     */
    @ApiOperation(value = "获取 系统用户 ", notes = "Get SysUser By Id")
    @GetMapping(value = "/getById")
    public Result getInfo(String userId)
    {
        if(StringUtils.isNotEmpty(userId)) {
            return Result.createSuccessResult(sysUserService.getById(userId));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 新增系统用户
     */
    @ApiOperation(value = "新增 系统用户", notes = "Add SysUser")
    @PostMapping(value = "/insert")
    public Result add(@RequestBody SysUser addRequest)
    {
        if(StringUtils.isNotEmpty(addRequest)) {
            return toResult(sysUserService.insert(addRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 修改系统用户
     */
    @ApiOperation(value = "修改 系统用户 ", notes = "Update SysUser By Id")
    @PutMapping(value = "/updateById")
    public Result edit(@RequestBody SysUser updateRequest)
    {
        if(StringUtils.isNotEmpty(updateRequest)) {
            return toResult(sysUserService.updateById(updateRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 删除系统用户
     */
    @ApiOperation(value = "删除 系统用户 ", notes = "delete SysUser By Id")
    @DeleteMapping("/deleteById")
    public Result remove(@RequestBody SysUserDelParam deleteRequest)
    {
        if(StringUtils.isNotEmpty(deleteRequest)&&StringUtils.isNotEmpty(deleteRequest.getId())) {
            return toResult(sysUserService.deleteById(deleteRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }


    /**
     * 分页查询系统用户
     */
    @ApiOperation(value = "获取 系统用户 分页列表", notes = "List SysUser with page")
    @GetMapping(value = "/list")
    public ResultList listEntity(SysUserParam param){
        if (StringUtils.isNotEmpty(param.getPage()) && (StringUtils.isNotEmpty(param.getLimit()))) {
            return sysUserService.list(param);
        }
        return ResultList.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 不分页查询系统用户
     */
    @ApiOperation(value = "获取 系统用户 列表", notes = "List SysUser all")
    @GetMapping(value = "/datas")
    public  ResultList listAllEntity(SysUserParam param){
        return sysUserService.datas(param);
    }
}