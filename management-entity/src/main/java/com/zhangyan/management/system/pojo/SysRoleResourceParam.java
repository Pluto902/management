package com.zhangyan.management.system.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
import com.zhangyan.management.system.entity.SysRoleResource;

/**
 * 角色资源 删除参数对象
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@Data
@ApiModel(value = "SysRoleResource 列表查询参数对象")
public class SysRoleResourceParam extends SysRoleResource {
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
