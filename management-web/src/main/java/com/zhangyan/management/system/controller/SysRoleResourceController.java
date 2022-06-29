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
import com.zhangyan.management.system.entity.SysRoleResource;
import com.zhangyan.management.system.service.SysRoleResourceService;
import com.zhangyan.management.system.pojo.SysRoleResourceParam;
import com.zhangyan.management.system.pojo.SysRoleResourceDelParam;
import lombok.extern.slf4j.Slf4j;



/**
 * 角色资源Controller
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@RestController
@RequestMapping("/management/system/roleResource")
@Api(value = "SysRoleResource", tags = "角色资源")
@Slf4j
public class SysRoleResourceController extends ComController {

    @Autowired
    private SysRoleResourceService sysRoleResourceService;


    /**
     * 获取角色资源详细信息
     */
    @ApiOperation(value = "获取 角色资源 ", notes = "Get SysRoleResource By Id")
    @GetMapping(value = "/getById")
    public Result getInfo(String roleId)
    {
        if(StringUtils.isNotEmpty(roleId)) {
            return Result.createSuccessResult(sysRoleResourceService.getById(roleId));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 新增角色资源
     */
    @ApiOperation(value = "新增 角色资源", notes = "Add SysRoleResource")
    @PostMapping(value = "/insert")
    public Result add(@RequestBody SysRoleResource addRequest)
    {
        if(StringUtils.isNotEmpty(addRequest)) {
            return toResult(sysRoleResourceService.insert(addRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 修改角色资源
     */
    @ApiOperation(value = "修改 角色资源 ", notes = "Update SysRoleResource By Id")
    @PutMapping(value = "/updateById")
    public Result edit(@RequestBody SysRoleResource updateRequest)
    {
        if(StringUtils.isNotEmpty(updateRequest)) {
            return toResult(sysRoleResourceService.updateByKey(updateRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 删除角色资源
     */
    @ApiOperation(value = "删除 角色资源 ", notes = "delete SysRoleResource By Id")
    @DeleteMapping("/deleteById")
    public Result remove(@RequestBody SysRoleResourceDelParam deleteRequest)
    {
        if(StringUtils.isNotEmpty(deleteRequest)&&StringUtils.isNotEmpty(deleteRequest.getId())) {
            return toResult(sysRoleResourceService.deleteById(deleteRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }


    /**
     * 分页查询角色资源
     */
    @ApiOperation(value = "获取 角色资源 分页列表", notes = "List SysRoleResource with page")
    @GetMapping(value = "/list")
    public ResultList listEntity(SysRoleResourceParam param){
        if (StringUtils.isNotEmpty(param.getPage()) && (StringUtils.isNotEmpty(param.getLimit()))) {
            return sysRoleResourceService.list(param);
        }
        return ResultList.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 不分页查询角色资源
     */
    @ApiOperation(value = "获取 角色资源 列表", notes = "List SysRoleResource all")
    @GetMapping(value = "/datas")
    public  ResultList listAllEntity(SysRoleResourceParam param){
        return sysRoleResourceService.datas(param);
    }
}