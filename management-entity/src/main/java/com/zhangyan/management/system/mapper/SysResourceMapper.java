package com.zhangyan.management.system.mapper;

import com.zhangyan.management.system.entity.SysResource;
import com.zhangyan.management.system.pojo.SysResourceParam;
import com.zhangyan.management.system.pojo.SysResourceDelParam;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.zhangyan.management.common.mapper.ComMapper;

import java.util.List;
/**
 * 资源Mapper接口
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
@Mapper
public interface SysResourceMapper extends ComMapper<SysResource> {

    /**
     * 获取资源详细信息
     */
     SysResource getById(String resourceId);

    /**
     * 新增资源
     */
    int insert(SysResource sysResource);

    /**
     * 新增资源
     */
    int insertBatch(List<SysResource> sysResources);

    /**
     * 修改资源
     */
    int updateById(SysResource sysResource);


    /**
     * 分页查询资源
     */
    IPage<SysResource> list(IPage<SysResource> page, @Param("sysResourceParam") SysResourceParam sysResourceParam);

    /**
     * 不分页查询资源
     */
    List<SysResource> datas(SysResourceParam sysResourceParam);
}