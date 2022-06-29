package com.zhangyan.management.system.mapper;

import com.zhangyan.management.system.entity.SysRoleResource;
import com.zhangyan.management.system.pojo.SysRoleResourceParam;
import com.zhangyan.management.system.pojo.SysRoleResourceDelParam;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.zhangyan.management.common.mapper.ComMapper;

import java.util.List;
/**
 * 角色资源Mapper接口
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
@Mapper
public interface SysRoleResourceMapper extends ComMapper<SysRoleResource> {

    /**
     * 获取角色资源详细信息
     */
     SysRoleResource getById(String roleId);

    /**
     * 新增角色资源
     */
    int insert(SysRoleResource sysRoleResource);

    /**
     * 新增角色资源
     */
    int insertBatch(List<SysRoleResource> sysRoleResources);

    /**
     * 修改角色资源
     */
    int updateById(SysRoleResource sysRoleResource);


    /**
     * 分页查询角色资源
     */
    IPage<SysRoleResource> list(IPage<SysRoleResource> page, @Param("sysRoleResourceParam") SysRoleResourceParam sysRoleResourceParam);

    /**
     * 不分页查询角色资源
     */
    List<SysRoleResource> datas(SysRoleResourceParam sysRoleResourceParam);
}