package cn.com.xuxiaowei.a.service;

import cn.com.xuxiaowei.a.entity.A;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * A表 服务类 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@SpringBootTest
class IAServiceTests {

    @Autowired
    private IAService aService;

    @Test
    void list() {
        List<A> aList = aService.list();
        for (A a : aList) {
            log.info(String.valueOf(a));
        }
    }

}
