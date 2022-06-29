package com.zhangyan.management.common.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-22 16:51
 * 公共service
 */
public class ComServiceImpl <D extends BaseMapper<E>, E> extends ServiceImpl<D, E> implements ComService<E> {
    //    /**
//     * 获取用户缓存信息
//     */
//    public LoginUser getLoginUser()
//    {
//        return SecurityUtils.getLoginUser();
//    }
//
//    /**
//     * 获取登录用户id
//     */
//    public Long getUserId()
//    {
//        return getLoginUser().getUserId();
//    }
//
//    /**
//     * 获取登录部门id
//     */
//    public Long getDeptId()
//    {
//        return getLoginUser().getDeptId();
//    }
//
//    /**
//     * 获取登录用户名
//     */
//    public String getUsername()
//    {
//        return getLoginUser().getUsername();
//    }
}
