package com.zhangyan.management.system.controller;

import com.zhangyan.management.common.Enums.ResultCodeEnums;
import com.zhangyan.management.common.controller.ComController;
import com.zhangyan.management.common.util.Result;
import com.zhangyan.management.common.util.ResultList;
import com.zhangyan.management.common.util.StringUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhangyan.management.system.entity.SysUserRole;
import com.zhangyan.management.system.service.SysUserRoleService;
import com.zhangyan.management.system.pojo.SysUserRoleParam;
import com.zhangyan.management.system.pojo.SysUserRoleDelParam;
import lombok.extern.slf4j.Slf4j;



/**
 * 用户和角色关联Controller
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@RestController
    @RequestMapping("/management/system/userRole")
@Api(value = "SysUserRole", tags = "用户和角色关联")
@Slf4j
public class SysUserRoleController extends ComController {

    @Autowired
    private SysUserRoleService sysUserRoleService;


    /**
     * 获取用户和角色关联详细信息
     */
    @ApiOperation(value = "获取 用户和角色关联 ", notes = "Get SysUserRole By Id")
    @GetMapping(value = "/getById")
    public Result getInfo(String userId)
    {
        if(StringUtils.isNotEmpty(userId)) {
            return Result.createSuccessResult(sysUserRoleService.getById(userId));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 新增用户和角色关联
     */
    @ApiOperation(value = "新增 用户和角色关联", notes = "Add SysUserRole")
    @PostMapping(value = "/insert")
    public Result add(@RequestBody SysUserRole addRequest)
    {
        if(StringUtils.isNotEmpty(addRequest)) {
            return toResult(sysUserRoleService.insert(addRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 修改用户和角色关联
     */
    @ApiOperation(value = "修改 用户和角色关联 ", notes = "Update SysUserRole By Id")
    @PutMapping(value = "/updateById")
    public Result edit(@RequestBody SysUserRole updateRequest)
    {
        if(StringUtils.isNotEmpty(updateRequest)) {
            return toResult(sysUserRoleService.updateByKey(updateRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 删除用户和角色关联
     */
    @ApiOperation(value = "删除 用户和角色关联 ", notes = "delete SysUserRole By Id")
    @DeleteMapping("/deleteById")
    public Result remove(@RequestBody SysUserRoleDelParam deleteRequest)
    {
        if(StringUtils.isNotEmpty(deleteRequest)&&StringUtils.isNotEmpty(deleteRequest.getId())) {
            return toResult(sysUserRoleService.deleteById(deleteRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }


    /**
     * 分页查询用户和角色关联
     */
    @ApiOperation(value = "获取 用户和角色关联 分页列表", notes = "List SysUserRole with page")
    @GetMapping(value = "/list")
    public ResultList listEntity(SysUserRoleParam param){
        if (StringUtils.isNotEmpty(param.getPage()) && (StringUtils.isNotEmpty(param.getLimit()))) {
            return sysUserRoleService.list(param);
        }
        return ResultList.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 不分页查询用户和角色关联
     */
    @ApiOperation(value = "获取 用户和角色关联 列表", notes = "List SysUserRole all")
    @GetMapping(value = "/datas")
    public  ResultList listAllEntity(SysUserRoleParam param){
        return sysUserRoleService.datas(param);
    }
}