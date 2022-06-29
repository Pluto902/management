package com.zhangyan.management.system.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 资源对象 sys_resource
 *
 * @author ZhangYan
 * @date 2022-06-29
 */

@Data
@Accessors(chain = true)
@TableName("sys_resource")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysResource对象" , description = "")
public class SysResource extends ComModel{

private static final long serialVersionUID = 1L;
    /**
     * 资源表主键
     */
        @ApiModelProperty(value = "资源表主键" , example = "0")

            @TableId("resource_id")
            private Long resourceId;
    /**
     * 父级资源主键：如果是顶级资源节点值为0
     */
        @ApiModelProperty(value = "父级资源主键：如果是顶级资源节点值为0" , example = "0")

    @TableField("parent_id")
    private Long parentId;
    /**
     * 所有父级资源主键，以英文逗号隔开如：一级，二级等
     */
        @ApiModelProperty(value = "所有父级资源主键，以英文逗号隔开如：一级，二级等")

    @TableField("parent_ids")
    private String parentIds;
    /**
     * 资源名称
     */
        @ApiModelProperty(value = "资源名称")

    @TableField("resource_name")
    private String resourceName;
    /**
     * 资源排序
     */
        @ApiModelProperty(value = "资源排序" , example = "0")

    @TableField("resource_sort")
    private Long resourceSort;
    /**
     * 资源层级：1顶级依次类推
     */
        @ApiModelProperty(value = "资源层级：1顶级依次类推" , example = "0")

    @TableField("resource_level")
    private Long resourceLevel;
    /**
     * 资源类型：1目录、2菜单、3按钮、4路由
     */
        @ApiModelProperty(value = "资源类型：1目录、2菜单、3按钮、4路由")

    @TableField("resource_type")
    private String resourceType;
    /**
     * 是否显示：0显示、1隐藏
     */
        @ApiModelProperty(value = "是否显示：0显示、1隐藏")

    @TableField("is_show")
    private String isShow;
    /**
     * 资源链接
     */
        @ApiModelProperty(value = "资源链接")

    @TableField("resource_url")
    private String resourceUrl;
    /**
     * 资源图表
     */
        @ApiModelProperty(value = "资源图表")

    @TableField("photo_url")
    private String photoUrl;
    /**
     * 权限标识
     */
        @ApiModelProperty(value = "权限标识")

    @TableField("permission")
    private String permission;
    /**
     * 状态：0正常 1删除 2停用
     */
        @ApiModelProperty(value = "状态：0正常 1删除 2停用")

    @TableField("status")
    private String status;
    /**
     * 创建者
     */
        @ApiModelProperty(value = "创建者")

    @TableField("create_by")
    private String createBy;
    /**
     * 创建时间
     */
        @ApiModelProperty(value = "创建时间")

    @TableField("create_date")
    private Date createDate;
    /**
     * 最后一次更新者
     */
        @ApiModelProperty(value = "最后一次更新者")

    @TableField("update_by")
    private String updateBy;
    /**
     * 最后一次更新时间
     */
        @ApiModelProperty(value = "最后一次更新时间")

    @TableField("update_date")
    private Date updateDate;
    /**
     * 备注
     */
        @ApiModelProperty(value = "备注")

    @TableField("remarks")
    private String remarks;
    /**
     * 前端路由对应
     */
        @ApiModelProperty(value = "前端路由对应")

    @TableField("router_mapping")
    private String routerMapping;
    /**
     * 资源鉴权类型．０：开放，１：需登录，２：需授权
     */
        @ApiModelProperty(value = "资源鉴权类型．０：开放，１：需登录，２：需授权")

    @TableField("resource_auth_type")
    private String resourceAuthType;

public static final String RESOURCE_ID ="resource_id";
public static final String PARENT_ID ="parent_id";
public static final String PARENT_IDS ="parent_ids";
public static final String RESOURCE_NAME ="resource_name";
public static final String RESOURCE_SORT ="resource_sort";
public static final String RESOURCE_LEVEL ="resource_level";
public static final String RESOURCE_TYPE ="resource_type";
public static final String IS_SHOW ="is_show";
public static final String RESOURCE_URL ="resource_url";
public static final String PHOTO_URL ="photo_url";
public static final String PERMISSION ="permission";
public static final String STATUS ="status";
public static final String CREATE_BY ="create_by";
public static final String CREATE_DATE ="create_date";
public static final String UPDATE_BY ="update_by";
public static final String UPDATE_DATE ="update_date";
public static final String REMARKS ="remarks";
public static final String ROUTER_MAPPING ="router_mapping";
public static final String RESOURCE_AUTH_TYPE ="resource_auth_type";

    @JsonIgnore
    public Long getId(){
            return this.resourceId;
            }
    @JsonIgnore
    public void setId(Long resourceId){
            this.resourceId = resourceId;
            }

}