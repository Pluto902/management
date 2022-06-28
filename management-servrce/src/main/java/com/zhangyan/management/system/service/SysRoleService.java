package com.zhangyan.management.system.service;

import java.util.List;
import com.zhangyan.management.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangyan.management.system.pojo.SysRoleParam;
import com.zhangyan.management.system.pojo.SysRoleDelParam;
import com.zhangyan.management.common.util.ResultList;
/**
 * 角色信息Service接口
 *
 * @author ZhangYan
 * @date 2022-06-28
 */
public interface SysRoleService extends IService {

    /**
     * 获取角色信息详细信息
     */
    SysRole getById(String roleId);

    /**
     * 新增角色信息
     */
    int insert(SysRole addRequest);

    /**
     * 修改角色信息
     */
    int updateById(SysRole updateRequest);

    /**
     * 删除角色信息
     */
    int deleteById(SysRoleDelParam deleteRequest);


    /**
     * 分页查询角色信息
     */
    ResultList list(SysRoleParam param);

    /**
     * 不分页查询角色信息
     */
    ResultList datas(SysRoleParam param);
 }