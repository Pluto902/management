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
 * 角色信息对象 sys_role
 *
 * @author ZhangYan
 * @date 2022-06-28
 */

@Data
@Accessors(chain = true)
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRole对象" , description = "")
public class SysRole extends ComModel{

private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
        @ApiModelProperty(value = "角色ID" , example = "0")

            @TableId("role_id")
            private Long roleId;
    /**
     * 角色名称
     */
        @ApiModelProperty(value = "角色名称")

    @TableField("role_name")
    private String roleName;
    /**
     * 角色权限字符串
     */
        @ApiModelProperty(value = "角色权限字符串")

    @TableField("role_key")
    private String roleKey;
    /**
     * 显示顺序
     */
        @ApiModelProperty(value = "显示顺序" , example = "0")

    @TableField("role_sort")
    private Long roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
        @ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")

    @TableField("data_scope")
    private String dataScope;
    /**
     * 菜单树选择项是否关联显示
     */
        @ApiModelProperty(value = "菜单树选择项是否关联显示" , example = "0")

    @TableField("menu_check_strictly")
    private Integer menuCheckStrictly;
    /**
     * 部门树选择项是否关联显示
     */
        @ApiModelProperty(value = "部门树选择项是否关联显示" , example = "0")

    @TableField("dept_check_strictly")
    private Integer deptCheckStrictly;
    /**
     * 角色状态（0正常 1停用）
     */
        @ApiModelProperty(value = "角色状态（0正常 1停用）")

    @TableField("status")
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
        @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")

    @TableField("del_flag")
    private String delFlag;
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

    @TableField("create_time")
    private Date createTime;
    /**
     * 更新者
     */
        @ApiModelProperty(value = "更新者")

    @TableField("update_by")
    private String updateBy;
    /**
     * 更新时间
     */
        @ApiModelProperty(value = "更新时间")

    @TableField("update_time")
    private Date updateTime;
    /**
     * 备注
     */
        @ApiModelProperty(value = "备注")

    @TableField("remark")
    private String remark;

public static final String ROLE_ID ="role_id";
public static final String ROLE_NAME ="role_name";
public static final String ROLE_KEY ="role_key";
public static final String ROLE_SORT ="role_sort";
public static final String DATA_SCOPE ="data_scope";
public static final String MENU_CHECK_STRICTLY ="menu_check_strictly";
public static final String DEPT_CHECK_STRICTLY ="dept_check_strictly";
public static final String STATUS ="status";
public static final String DEL_FLAG ="del_flag";
public static final String CREATE_BY ="create_by";
public static final String CREATE_TIME ="create_time";
public static final String UPDATE_BY ="update_by";
public static final String UPDATE_TIME ="update_time";
public static final String REMARK ="remark";

    @JsonIgnore
    public Long getId(){
            return this.roleId;
            }
    @JsonIgnore
    public void setId(Long roleId){
            this.roleId = roleId;
            }

}