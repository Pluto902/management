package com.zhangyan.management.common.constant;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-20 10:58
 * 管理系统常量
 */
public class Constant {
    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";
    public static final String UTF8 = "UTF-8";

    /**
     * 分页参数
     */
    public static final Long LIMIT = 999L;
    public static final Long PAGE = 1L;

    /**
     * 排序参数
     */
    public static final String ASC = "asc";
    public static final String DESC = "desc";

    /**
     * 状态参数
     */
    public static final String STATUS_ENABLE = "0";
    public static final String STATUS_DELETE = "1";
    public static final String STATUS_DISABLE = "2";

    public static final String PUBLICKEY = "publicKey";

    public static final String PRIVATEKEY = "privateKey";
    public static final int DEFAULT_KEY_SIZE = 2048;
}
