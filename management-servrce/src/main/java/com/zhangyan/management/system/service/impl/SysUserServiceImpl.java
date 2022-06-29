package com.zhangyan.management.system.service.impl;

import java.util.List;

import com.zhangyan.management.common.constant.Constants;
import com.zhangyan.management.common.util.ResultList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.zhangyan.management.system.mapper.SysUserMapper;
import com.zhangyan.management.system.entity.SysUser;
import com.zhangyan.management.system.service.SysUserService;
import com.zhangyan.management.system.pojo.SysUserParam;
import com.zhangyan.management.system.pojo.SysUserDelParam;
import com.zhangyan.management.common.service.ComServiceImpl;
import java.util.Date;

import javax.annotation.Resource;
/**
 * 系统用户Service业务层处理
 *
 * @author ZhangYan
 * @date 2022-06-23
 */
@Service
public class SysUserServiceImpl extends ComServiceImpl<SysUserMapper,SysUser> implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 获取系统用户详细信息
     */
    @Override
    public SysUser getById(String userId) {
           return sysUserMapper.getById(userId);
    }

    /**
     * 新增系统用户
     */
    @Override
    public int insert(SysUser addRequest){
//        addRequest.setCreateBy(getUserId());
//        addRequest.setUpdateBy(getUserId());
        addRequest.setCreateTime(new Date());
        addRequest.setUpdateTime(new Date());
        addRequest.setStatus(Constants.STATUS_ENABLE);
        return sysUserMapper.insert(addRequest);
    }

    /**
     * 修改系统用户
     */
    @Override
    public int updateByKey(SysUser updateRequest){
//        updateRequest.setUpdateBy(getUserId());
        updateRequest.setUpdateTime(new Date());
        return sysUserMapper.updateById(updateRequest);
    }

    /**
     * 删除系统用户
     */
    @Override
    public int deleteById(SysUserDelParam deleteRequest){
        SysUser data= new SysUser();
        data.setId(deleteRequest.getId());
        data.setStatus(Constants.STATUS_DELETE);
//        data.setUpdateBy(getUserId());
        data.setUpdateTime(new Date());
        return sysUserMapper.updateById(data);
    }


    /**
     * 分页查询系统用户
     */
    @Override
    public ResultList list(SysUserParam param){
        Page<SysUser> resultPage=new Page(param.getPage(),param.getLimit());
        Page<SysUser> resultList = (Page) sysUserMapper.list(resultPage,param);
        return ResultList.createSuccessResult(resultList.getRecords(),resultList.getTotal());
    }

    /**
     * 不分页查询系统用户
     */
    @Override
    public ResultList datas(SysUserParam param){
        List<SysUser> sysUserList = sysUserMapper.datas(param);
        return ResultList.createSuccessResult(sysUserList);
    }
}