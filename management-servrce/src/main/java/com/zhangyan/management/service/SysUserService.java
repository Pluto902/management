package com.zhangyan.management.service;

import java.util.List;
import com.zhangyan.management.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangyan.management.pojo.SysUserParam;
import com.zhangyan.management.pojo.SysUserDelParam;
import com.zhangyan.management.common.util.ResultList;
/**
 * 系统用户Service接口
 *
 * @author ZhangYan
 * @date 2022-06-23
 */
public interface SysUserService extends IService {

    /**
     * 获取系统用户详细信息
     */
    SysUser getById(String userId);

    /**
     * 新增系统用户
     */
    int insert(SysUser addRequest);

    /**
     * 修改系统用户
     */
    int updateById(SysUser updateRequest);

    /**
     * 删除系统用户
     */
    int deleteById(SysUserDelParam deleteRequest);


    /**
     * 分页查询系统用户
     */
    ResultList list(SysUserParam param);

    /**
     * 不分页查询系统用户
     */
    ResultList datas(SysUserParam param);
 }