package com.zhangyan.management.system.service.impl;

import com.zhangyan.management.common.constant.Constants;
import com.zhangyan.management.common.factory.AsyncFactory;
import com.zhangyan.management.common.util.AsyncManager;
import com.zhangyan.management.common.util.MessageUtils;
import com.zhangyan.management.system.service.SysLoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-29 14:31
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public String login(String username, String password){
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e)
        {
//            if (e instanceof BadCredentialsException)
//            {
//                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
//                throw new UserPasswordNotMatchException();
//            }
//            else
//            {
//                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
//                throw new ServiceException(e.getMessage());
//            }
        }
        return null;
    }
}
