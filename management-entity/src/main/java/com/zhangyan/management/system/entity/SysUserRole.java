package com.zhangyan.management.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhangyan.management.common.domain.ComModel;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;


/**
 * 用户和角色关联对象 sys_user_role
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@Data
@Accessors(chain = true)
@TableName("sys_user_role")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserRole对象" , description = "")
public class SysUserRole extends ComModel{

private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID" , example = "0")
    private Long userId;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID" , example = "0")
    private Long roleId;

    public static final String USER_ID ="user_id";
    public static final String ROLE_ID ="role_id";

}