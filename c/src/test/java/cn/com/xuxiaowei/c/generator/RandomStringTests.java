package cn.com.xuxiaowei.c.generator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

/**
 * 随机字符串 测试类
 *
 * @author xuxiaowei
 * @see RandomStringUtils
 * @since 0.0.1
 */
@Slf4j
class RandomStringTests {

    @Test
    void randomAlphanumeric() {
        String str = RandomStringUtils.randomAlphanumeric(4);
        System.out.println(str);
    }

}
