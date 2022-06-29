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
 * 角色资源对象 sys_role_resource
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@Data
@Accessors(chain = true)
@TableName("sys_role_resource")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRoleResource对象" , description = "")
public class SysRoleResource extends ComModel{

private static final long serialVersionUID = 1L;
    /**
     * 角色表主键
     */
    @ApiModelProperty(value = "角色表主键" , example = "0")
    private Long roleId;
    /**
     * 资源表主键
     */
    @ApiModelProperty(value = "资源表主键" , example = "0")
    private Long resourceId;

    public static final String ROLE_ID ="role_id";
    public static final String RESOURCE_ID ="resource_id";


}