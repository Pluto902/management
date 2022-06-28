package com.zhangyan.management.system.service.impl;

import java.util.List;

import com.zhangyan.management.common.constant.Constant;
import com.zhangyan.management.common.util.DateUtils;
import com.zhangyan.management.common.util.ResultList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.zhangyan.management.system.mapper.SysRoleMapper;
import com.zhangyan.management.system.entity.SysRole;
import com.zhangyan.management.system.service.SysRoleService;
import com.zhangyan.management.system.pojo.SysRoleParam;
import com.zhangyan.management.system.pojo.SysRoleDelParam;
import com.zhangyan.management.common.service.ComServiceImpl;
import java.util.Date;

import javax.annotation.Resource;
/**
 * 角色信息Service业务层处理
 *
 * @author ZhangYan
 * @date 2022-06-28
 */
@Service
public class SysRoleServiceImpl extends ComServiceImpl implements SysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 获取角色信息详细信息
     */
    @Override
    public SysRole getById(String roleId) {
           return sysRoleMapper.getById(roleId);
    }

    /**
     * 新增角色信息
     */
    @Override
    public int insert(SysRole addRequest){
//        addRequest.setCreateBy(getUserId());
//        addRequest.setUpdateBy(getUserId());
        addRequest.setCreateTime(new Date());
        addRequest.setUpdateTime(new Date());
        addRequest.setStatus(Constant.STATUS_ENABLE);
        return sysRoleMapper.insert(addRequest);
    }

    /**
     * 修改角色信息
     */
    @Override
    public int updateById(SysRole updateRequest){
//        updateRequest.setUpdateBy(getUserId());
        updateRequest.setUpdateTime(new Date());
        return sysRoleMapper.updateById(updateRequest);
    }

    /**
     * 删除角色信息
     */
    @Override
    public int deleteById(SysRoleDelParam deleteRequest){
        SysRole data= new SysRole();
        data.setId(deleteRequest.getId());
        data.setStatus(Constant.STATUS_DELETE);
//        data.setUpdateBy(getUserId());
        data.setUpdateTime(new Date());
        return sysRoleMapper.updateById(data);
    }


    /**
     * 分页查询角色信息
     */
    @Override
    public ResultList list(SysRoleParam param){
        Page<SysRole> resultPage=new Page(param.getPage(),param.getLimit());
        Page<SysRole> resultList = (Page) sysRoleMapper.list(resultPage,param);
        return ResultList.createSuccessResult(resultList.getRecords(),resultList.getTotal());
    }

    /**
     * 不分页查询角色信息
     */
    @Override
    public ResultList datas(SysRoleParam param){
        List<SysRole> sysRoleList = sysRoleMapper.datas(param);
        return ResultList.createSuccessResult(sysRoleList);
    }
}