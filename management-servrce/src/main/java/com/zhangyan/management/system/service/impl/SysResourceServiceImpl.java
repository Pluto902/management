package com.zhangyan.management.system.service.impl;

import java.util.List;

import com.zhangyan.management.common.constant.Constants;
import com.zhangyan.management.common.util.ResultList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.zhangyan.management.system.mapper.SysResourceMapper;
import com.zhangyan.management.system.entity.SysResource;
import com.zhangyan.management.system.service.SysResourceService;
import com.zhangyan.management.system.pojo.SysResourceParam;
import com.zhangyan.management.system.pojo.SysResourceDelParam;
import com.zhangyan.management.common.service.ComServiceImpl;

import javax.annotation.Resource;
/**
 * 资源Service业务层处理
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
@Service
public class SysResourceServiceImpl extends ComServiceImpl<SysResourceMapper, SysResource> implements SysResourceService{

    @Resource
    private SysResourceMapper sysResourceMapper;

    /**
     * 获取资源详细信息
     */
    @Override
    public SysResource getById(String resourceId) {
           return sysResourceMapper.getById(resourceId);
    }

    /**
     * 新增资源
     */
    @Override
    public int insert(SysResource addRequest){
//        addRequest.setCreateBy(getUserId());
//        addRequest.setUpdateBy(getUserId());
//        addRequest.setCreateTime(new Date());
//        addRequest.setUpdateTime(new Date());
        addRequest.setStatus(Constants.STATUS_ENABLE);
        return sysResourceMapper.insert(addRequest);
    }

    /**
     * 修改资源
     */
    @Override
    public int updateByKey(SysResource updateRequest){
//        updateRequest.setUpdateBy(getUserId());
//        updateRequest.setUpdateTime(new Date());
        return sysResourceMapper.updateById(updateRequest);
    }

    /**
     * 删除资源
     */
    @Override
    public int deleteById(SysResourceDelParam deleteRequest){
        SysResource data= new SysResource();
        data.setId(deleteRequest.getId());
        data.setStatus(Constants.STATUS_DELETE);
//        data.setUpdateBy(getUserId());
//        data.setUpdateTime(new Date());
        return sysResourceMapper.updateById(data);
    }


    /**
     * 分页查询资源
     */
    @Override
    public ResultList list(SysResourceParam param){
        Page<SysResource> resultPage=new Page(param.getPage(),param.getLimit());
        Page<SysResource> resultList = (Page) sysResourceMapper.list(resultPage,param);
        return ResultList.createSuccessResult(resultList.getRecords(),resultList.getTotal());
    }

    /**
     * 不分页查询资源
     */
    @Override
    public ResultList datas(SysResourceParam param){
        List<SysResource> sysResourceList = sysResourceMapper.datas(param);
        return ResultList.createSuccessResult(sysResourceList);
    }
}