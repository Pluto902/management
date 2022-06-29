package com.zhangyan.management.system.service.impl;

import java.util.List;

import com.zhangyan.management.common.constant.Constant;
import com.zhangyan.management.common.util.ResultList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.zhangyan.management.system.mapper.SysUserRoleMapper;
import com.zhangyan.management.system.entity.SysUserRole;
import com.zhangyan.management.system.service.SysUserRoleService;
import com.zhangyan.management.system.pojo.SysUserRoleParam;
import com.zhangyan.management.system.pojo.SysUserRoleDelParam;
import com.zhangyan.management.common.service.ComServiceImpl;
import java.util.Date;

import javax.annotation.Resource;
/**
 * 用户和角色关联Service业务层处理
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
@Service
public class SysUserRoleServiceImpl extends ComServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService{

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 获取用户和角色关联详细信息
     */
    @Override
    public SysUserRole getById(String userId) {
           return sysUserRoleMapper.getById(userId);
    }

    /**
     * 新增用户和角色关联
     */
    @Override
    public int insert(SysUserRole addRequest){
//        addRequest.setCreateBy(getUserId());
//        addRequest.setUpdateBy(getUserId());
//        addRequest.setCreateTime(new Date());
//        addRequest.setUpdateTime(new Date());
//        addRequest.setStatus(Constant.STATUS_ENABLE);
        return sysUserRoleMapper.insert(addRequest);
    }

    /**
     * 修改用户和角色关联
     */
    @Override
    public int updateByKey(SysUserRole updateRequest){
//        updateRequest.setUpdateBy(getUserId());
//        updateRequest.setUpdateTime(new Date());
        return sysUserRoleMapper.updateById(updateRequest);
    }

    /**
     * 删除用户和角色关联
     */
    @Override
    public int deleteById(SysUserRoleDelParam deleteRequest){
//        data.setStatus(Constant.STATUS_DELETE);
//        data.setUpdateBy(getUserId());
//        data.setUpdateTime(new Date());
        return sysUserRoleMapper.deleteById(deleteRequest);
    }


    /**
     * 分页查询用户和角色关联
     */
    @Override
    public ResultList list(SysUserRoleParam param){
        Page<SysUserRole> resultPage=new Page(param.getPage(),param.getLimit());
        Page<SysUserRole> resultList = (Page) sysUserRoleMapper.list(resultPage,param);
        return ResultList.createSuccessResult(resultList.getRecords(),resultList.getTotal());
    }

    /**
     * 不分页查询用户和角色关联
     */
    @Override
    public ResultList datas(SysUserRoleParam param){
        List<SysUserRole> sysUserRoleList = sysUserRoleMapper.datas(param);
        return ResultList.createSuccessResult(sysUserRoleList);
    }
}