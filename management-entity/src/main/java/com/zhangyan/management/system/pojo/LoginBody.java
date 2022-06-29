package com.zhangyan.management.system.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-29 14:21
 */
@Data
@ApiModel(value = "登录对象" , description = "登录")
public class LoginBody {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
