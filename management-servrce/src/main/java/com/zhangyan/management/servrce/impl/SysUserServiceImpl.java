package com.zhangyan.management.servrce.impl;


import com.zhangyan.management.dao.SysUserDao;
import com.zhangyan.management.entity.SysUser;
import com.zhangyan.management.servrce.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2022-06-21 11:18:52
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Long userId) {
        return this.sysUserDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param sysUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SysUser> queryByPage(SysUser sysUser, PageRequest pageRequest) {
//        long total = this.sysUserDao.count(sysUser);
//        return new PageImpl<>(this.sysUserDao.queryAllByLimit(sysUser, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.sysUserDao.deleteById(userId) > 0;
    }
}
