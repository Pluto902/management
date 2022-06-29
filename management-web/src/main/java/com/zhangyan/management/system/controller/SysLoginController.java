package com.zhangyan.management.system.controller;

import com.zhangyan.management.common.util.Result;
import com.zhangyan.management.common.constant.Constants;
import com.zhangyan.management.system.pojo.LoginBody;
import com.zhangyan.management.system.service.SysLoginService;
import com.zhangyan.management.system.service.SysResourceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * 登录与注册
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-27 16:03
 */
@RestController
@RequestMapping("/management/system")
@Api(value = "login",tags = "登录与注册")
public class SysLoginController {

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private SysLoginService sysLoginService;

    @RequestMapping("/login")
    public Result login(@RequestBody LoginBody loginBody){
        String token = sysLoginService.login(loginBody.getUsername(),loginBody.getPassword());
        Result result = new Result();
        result.put(Constants.TOKEN,token);
        return result;
    }

}
