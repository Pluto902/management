package com.zhangyan.management.system.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 用户和角色关联 删除参数对象
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@Data
@ApiModel(value = "SysUserRole 删除参数对象")
public class SysUserRoleDelParam implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "批量ID")
    private List<Long> ids;
}
