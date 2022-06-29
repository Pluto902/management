package com.zhangyan.management.system.mapper;

import com.zhangyan.management.common.mapper.ComMapper;
import com.zhangyan.management.system.entity.SysUserRole;
import com.zhangyan.management.system.pojo.SysUserRoleParam;
import com.zhangyan.management.system.pojo.SysUserRoleDelParam;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 用户和角色关联Mapper接口
 *
 * @author ZhangYan
 * @date 2022-06-29
 */
@Mapper
public interface SysUserRoleMapper extends ComMapper<SysUserRole> {

    /**
     * 获取用户和角色关联详细信息
     */
     SysUserRole getById(String userId);

    /**
     * 新增用户和角色关联
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 新增用户和角色关联
     */
    int insertBatch(List<SysUserRole> sysUserRoles);

    /**
     * 修改用户和角色关联
     */
    int updateById(SysUserRole sysUserRole);


    /**
     * 分页查询用户和角色关联
     */
    IPage<SysUserRole> list(IPage<SysUserRole> page, @Param("sysUserRoleParam") SysUserRoleParam sysUserRoleParam);

    /**
     * 不分页查询用户和角色关联
     */
    List<SysUserRole> datas(SysUserRoleParam sysUserRoleParam);
}