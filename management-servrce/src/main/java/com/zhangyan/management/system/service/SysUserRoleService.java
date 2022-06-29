package com.zhangyan.management.system.service;

import java.util.List;
import com.zhangyan.management.system.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangyan.management.system.pojo.SysUserRoleParam;
import com.zhangyan.management.system.pojo.SysUserRoleDelParam;
import com.zhangyan.management.common.util.ResultList;
import com.zhangyan.management.common.service.ComService;
/**
 * 用户和角色关联Service接口
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
public interface SysUserRoleService extends ComService<SysUserRole> {

    /**
     * 获取用户和角色关联详细信息
     */
    SysUserRole getById(String userId);

    /**
     * 新增用户和角色关联
     */
    int insert(SysUserRole addRequest);

    /**
     * 修改用户和角色关联
     */
    int updateByKey(SysUserRole updateRequest);

    /**
     * 删除用户和角色关联
     */
    int deleteById(SysUserRoleDelParam deleteRequest);


    /**
     * 分页查询用户和角色关联
     */
    ResultList list(SysUserRoleParam param);

    /**
     * 不分页查询用户和角色关联
     */
    ResultList datas(SysUserRoleParam param);
 }