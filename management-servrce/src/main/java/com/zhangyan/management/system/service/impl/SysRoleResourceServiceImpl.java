package com.zhangyan.management.system.service.impl;

import java.util.List;

import com.zhangyan.management.common.util.ResultList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.zhangyan.management.system.mapper.SysRoleResourceMapper;
import com.zhangyan.management.system.entity.SysRoleResource;
import com.zhangyan.management.system.service.SysRoleResourceService;
import com.zhangyan.management.system.pojo.SysRoleResourceParam;
import com.zhangyan.management.system.pojo.SysRoleResourceDelParam;
import com.zhangyan.management.common.service.ComServiceImpl;

import javax.annotation.Resource;
/**
 * 角色资源Service业务层处理
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
@Service
public class SysRoleResourceServiceImpl extends ComServiceImpl<SysRoleResourceMapper, SysRoleResource> implements SysRoleResourceService{

    @Resource
    private SysRoleResourceMapper sysRoleResourceMapper;

    /**
     * 获取角色资源详细信息
     */
    @Override
    public SysRoleResource getById(String roleId) {
           return sysRoleResourceMapper.getById(roleId);
    }

    /**
     * 新增角色资源
     */
    @Override
    public int insert(SysRoleResource addRequest){
//        addRequest.setCreateBy(getUserId());
//        addRequest.setUpdateBy(getUserId());
//        addRequest.setCreateTime(new Date());
//        addRequest.setUpdateTime(new Date());
//        addRequest.setStatus(Constant.STATUS_ENABLE);
        return sysRoleResourceMapper.insert(addRequest);
    }

    /**
     * 修改角色资源
     */
    @Override
    public int updateByKey(SysRoleResource updateRequest){
//        updateRequest.setUpdateBy(getUserId());
//        updateRequest.setUpdateTime(new Date());
        return sysRoleResourceMapper.updateById(updateRequest);
    }

    /**
     * 删除角色资源
     */
    @Override
    public int deleteById(SysRoleResourceDelParam deleteRequest){
        return sysRoleResourceMapper.deleteById(deleteRequest);
    }


    /**
     * 分页查询角色资源
     */
    @Override
    public ResultList list(SysRoleResourceParam param){
        Page<SysRoleResource> resultPage=new Page(param.getPage(),param.getLimit());
        Page<SysRoleResource> resultList = (Page) sysRoleResourceMapper.list(resultPage,param);
        return ResultList.createSuccessResult(resultList.getRecords(),resultList.getTotal());
    }

    /**
     * 不分页查询角色资源
     */
    @Override
    public ResultList datas(SysRoleResourceParam param){
        List<SysRoleResource> sysRoleResourceList = sysRoleResourceMapper.datas(param);
        return ResultList.createSuccessResult(sysRoleResourceList);
    }
}