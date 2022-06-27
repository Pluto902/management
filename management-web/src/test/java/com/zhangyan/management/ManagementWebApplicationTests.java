package com.zhangyan.management;

import com.zhangyan.management.common.util.RedisUtil;
import com.zhangyan.management.common.util.RsaUtils;
import com.zhangyan.management.common.util.SpringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ManagementWebApplicationTests {

    @Resource
    private RedisUtil redisUtil;
    @Test
    public void generateKey() throws Exception {
        RsaUtils.generateKey("zhangyan",2048);
    }

}
