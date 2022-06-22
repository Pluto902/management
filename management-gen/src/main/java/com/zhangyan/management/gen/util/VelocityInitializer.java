package com.zhangyan.management.gen.util;

import com.zhangyan.management.common.constant.Constant;
import org.apache.velocity.app.Velocity;

import java.util.Properties;

/**
 * TODO
 *
 * @author ZhangYan
 * @version V1.0
 * @since 2022-06-22 11:07
 */
public class VelocityInitializer {
    /**
     * 初始化vm方法
     */
    public static void initVelocity()
    {
        Properties p = new Properties();
        try
        {
            // 加载classpath目录下的vm文件
            p.setProperty("resource.loader.file.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            // 定义字符集
            p.setProperty(Velocity.INPUT_ENCODING, Constant.UTF8);
            // 初始化Velocity引擎，指定配置Properties
            Velocity.init(p);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
