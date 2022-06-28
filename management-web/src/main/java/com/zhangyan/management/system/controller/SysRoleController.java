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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhangyan.management.system.entity.SysRole;
import com.zhangyan.management.system.service.SysRoleService;
import com.zhangyan.management.system.pojo.SysRoleParam;
import com.zhangyan.management.system.pojo.SysRoleDelParam;



/**
 * 角色信息Controller
 *
 * @author ZhangYan
 * @date 2022-06-28
 */

@RestController
@RequestMapping("/management/role")
public class SysRoleController extends ComController {

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 获取角色信息详细信息
     */
    @ApiOperation(value = "获取 角色信息 ", notes = "Get SysRole By Id")
    @GetMapping(value = "/getById")
    public Result getInfo(String roleId)
    {
        if(StringUtils.isNotEmpty(roleId)) {
            return Result.createSuccessResult(sysRoleService.getById(roleId));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 新增角色信息
     */
    @ApiOperation(value = "新增 角色信息", notes = "Add SysRole")
    @PostMapping(value = "/insert")
    public Result add(@RequestBody SysRole addRequest)
    {
        if(StringUtils.isNotEmpty(addRequest)) {
            return toResult(sysRoleService.insert(addRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 修改角色信息
     */
    @ApiOperation(value = "修改 角色信息 ", notes = "Update SysRole By Id")
    @PutMapping(value = "/updateById")
    public Result edit(@RequestBody SysRole updateRequest)
    {
        if(StringUtils.isNotEmpty(updateRequest)) {
            return toResult(sysRoleService.updateById(updateRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 删除角色信息
     */
    @ApiOperation(value = "删除 角色信息 ", notes = "delete SysRole By Id")
    @DeleteMapping("/deleteById")
    public Result remove(@RequestBody SysRoleDelParam deleteRequest)
    {
        if(StringUtils.isNotEmpty(deleteRequest)&&StringUtils.isNotEmpty(deleteRequest.getId())) {
            return toResult(sysRoleService.deleteById(deleteRequest));
        }
        return Result.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }


    /**
     * 分页查询角色信息
     */
    @ApiOperation(value = "获取 角色信息 分页列表", notes = "List SysRole with page")
    @GetMapping(value = "/list")
    public ResultList listEntity(SysRoleParam param){
        if (StringUtils.isNotEmpty(param.getPage()) && (StringUtils.isNotEmpty(param.getLimit()))) {
            return sysRoleService.list(param);
        }
        return ResultList.createFailResult(ResultCodeEnums.BAD_REQUEST.getCode(),ResultCodeEnums.BAD_REQUEST.getMsg());
    }

    /**
     * 不分页查询角色信息
     */
    @ApiOperation(value = "获取 角色信息 列表", notes = "List SysRole all")
    @GetMapping(value = "/datas")
    public  ResultList listAllEntity(SysRoleParam param){
        return sysRoleService.datas(param);
    }
}