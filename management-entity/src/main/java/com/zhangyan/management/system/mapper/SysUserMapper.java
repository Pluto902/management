package com.zhangyan.management.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangyan.management.system.entity.SysUser;
import com.zhangyan.management.system.pojo.SysUserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
/**
 * 系统用户Mapper接口
 *
 * @author ZhangYan
 * @date 2022-06-23
 */
@Mapper
public interface SysUserMapper extends BaseMapper {

    /**
     * 获取系统用户详细信息
     */
     SysUser getById(String userId);

    /**
     * 新增系统用户
     */
    int insert(SysUser sysUser);

    /**
     * 新增系统用户
     */
    int insertBatch(List<SysUser> sysUsers);

    /**
     * 修改系统用户
     */
    int updateById(SysUser sysUser);


    /**
     * 分页查询系统用户
     */
    IPage<SysUser> list(IPage<SysUser> page,@Param("sysUserParam") SysUserParam sysUserparam);

    /**
     * 不分页查询系统用户
     */
    List<SysUser> datas(SysUserParam sysUserparam);
}