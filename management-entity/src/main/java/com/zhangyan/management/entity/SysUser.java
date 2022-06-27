package com.zhangyan.management.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhangyan.management.common.domain.ComModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * 系统用户对象 sys_user
 *
 * @author ZhangYan
 * @date 2022-06-23
 */

@Data
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "SysUser对象" , description = "")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends ComModel {

private static final long serialVersionUID = 1L;
    /**
     * 用户主键
     */
        @ApiModelProperty(value = "用户主键" , example = "0")

            @TableId("user_id")
        private Long userId;
    /**
     * 部门id
     */
        @ApiModelProperty(value = "部门id" , example = "0")

    @TableField("dept_id")
private Long deptId;
    /**
     * 用户账号
     */
        @ApiModelProperty(value = "用户账号")

    @TableField("user_name")
private String userName;
    /**
     * 用户昵称
     */
        @ApiModelProperty(value = "用户昵称")

    @TableField("name")
private String name;
    /**
     * 用户邮箱
     */
        @ApiModelProperty(value = "用户邮箱")

    @TableField("email")
private String email;
    /**
     * 手机号码
     */
        @ApiModelProperty(value = "手机号码")

    @TableField("phonenumber")
private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
        @ApiModelProperty(value = "用户性别（0男 1女 2未知）")

    @TableField("sex")
private String sex;
    /**
     * 头像地址
     */
        @ApiModelProperty(value = "头像地址")

    @TableField("avatar")
private String avatar;
    /**
     * 密码
     */
        @ApiModelProperty(value = "密码")

    @TableField("password")
private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
        @ApiModelProperty(value = "帐号状态（0正常 1停用）")

    @TableField("status")
private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
        @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")

    @TableField("del_flag")
private String delFlag;
    /**
     * 最后登录IP
     */
        @ApiModelProperty(value = "最后登录IP")

    @TableField("login_ip")
private String loginIp;
    /**
     * 最后登录时间
     */
        @ApiModelProperty(value = "最后登录时间")

    @TableField("login_date")
private Date loginDate;
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
    /**
     * 超级管理员 0是 1不是（防止被删除）
     */
        @ApiModelProperty(value = "超级管理员 0是 1不是（防止被删除）")

    @TableField("super_admin")
private String superAdmin;

public static final String USER_ID ="user_id";
public static final String DEPT_ID ="dept_id";
public static final String USER_NAME ="user_name";
public static final String NAME ="name";
public static final String EMAIL ="email";
public static final String PHONENUMBER ="phonenumber";
public static final String SEX ="sex";
public static final String AVATAR ="avatar";
public static final String PASSWORD ="password";
public static final String STATUS ="status";
public static final String DEL_FLAG ="del_flag";
public static final String LOGIN_IP ="login_ip";
public static final String LOGIN_DATE ="login_date";
public static final String CREATE_BY ="create_by";
public static final String CREATE_TIME ="create_time";
public static final String UPDATE_BY ="update_by";
public static final String UPDATE_TIME ="update_time";
public static final String REMARK ="remark";
public static final String SUPER_ADMIN ="super_admin";

    @JsonIgnore
    public Long getId(){
            return this.userId;
            }
    @JsonIgnore
    public void setId(Long userId){
            this.userId = userId;
            }

}