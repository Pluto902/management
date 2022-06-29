package com.zhangyan.management.system.service;

import java.util.List;
import com.zhangyan.management.system.entity.SysRoleResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangyan.management.system.pojo.SysRoleResourceParam;
import com.zhangyan.management.system.pojo.SysRoleResourceDelParam;
import com.zhangyan.management.common.util.ResultList;
import com.zhangyan.management.common.service.ComService;
/**
 * 角色资源Service接口
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
public interface SysRoleResourceService extends ComService<SysRoleResource> {

    /**
     * 获取角色资源详细信息
     */
    SysRoleResource getById(String roleId);

    /**
     * 新增角色资源
     */
    int insert(SysRoleResource addRequest);

    /**
     * 修改角色资源
     */
    int updateByKey(SysRoleResource updateRequest);

    /**
     * 删除角色资源
     */
    int deleteById(SysRoleResourceDelParam deleteRequest);


    /**
     * 分页查询角色资源
     */
    ResultList list(SysRoleResourceParam param);

    /**
     * 不分页查询角色资源
     */
    ResultList datas(SysRoleResourceParam param);
 }