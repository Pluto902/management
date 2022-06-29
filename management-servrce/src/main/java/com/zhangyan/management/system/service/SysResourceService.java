package com.zhangyan.management.system.service;

import java.util.List;
import com.zhangyan.management.system.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangyan.management.system.pojo.SysResourceParam;
import com.zhangyan.management.system.pojo.SysResourceDelParam;
import com.zhangyan.management.common.util.ResultList;
import com.zhangyan.management.common.service.ComService;
/**
 * 资源Service接口
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
public interface SysResourceService extends ComService<SysResource> {

    /**
     * 获取资源详细信息
     */
    SysResource getById(String resourceId);

    /**
     * 新增资源
     */
    int insert(SysResource addRequest);

    /**
     * 修改资源
     */
    int updateByKey(SysResource updateRequest);

    /**
     * 删除资源
     */
    int deleteById(SysResourceDelParam deleteRequest);


    /**
     * 分页查询资源
     */
    ResultList list(SysResourceParam param);

    /**
     * 不分页查询资源
     */
    ResultList datas(SysResourceParam param);
 }