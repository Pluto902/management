package com.zhangyan.management.system.mapper;

import com.zhangyan.management.system.entity.SysRole;
import com.zhangyan.management.system.pojo.SysRoleParam;
import com.zhangyan.management.system.pojo.SysRoleDelParam;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 角色信息Mapper接口
 *
 * @author ZhangYan
 * @date 2022-06-28
 */
@Mapper
public interface SysRoleMapper extends BaseMapper {

    /**
     * 获取角色信息详细信息
     */
     SysRole getById(String roleId);

    /**
     * 新增角色信息
     */
    int insert(SysRole sysRole);

    /**
     * 新增角色信息
     */
    int insertBatch(List<SysRole> sysRoles);

    /**
     * 修改角色信息
     */
    int updateById(SysRole sysRole);


    /**
     * 分页查询角色信息
     */
    IPage<SysRole> list(IPage<SysRole> page, @Param("sysRoleParam") SysRoleParam sysRoleParam);

    /**
     * 不分页查询角色信息
     */
    List<SysRole> datas(SysRoleParam sysRoleParam);
}