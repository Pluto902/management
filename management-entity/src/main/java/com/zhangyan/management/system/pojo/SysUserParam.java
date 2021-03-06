package com.zhangyan.management.system.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.zhangyan.management.system.entity.SysUser;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统用户 删除参数对象
 *
 * @author ZhangYan
 * @date 2022-06-23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SysUser 列表查询参数对象")
public class SysUserParam extends SysUser {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "每页数量")
    private Long limit;

    @ApiModelProperty(value = "当前页数")
    private Long page;

    @ApiModelProperty(value = "排序字段")
    private String orderBy;

    @ApiModelProperty(value = "排序方式")
    private String orderType;

}
