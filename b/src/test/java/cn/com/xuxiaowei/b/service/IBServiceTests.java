package cn.com.xuxiaowei.b.service;

import cn.com.xuxiaowei.b.entity.B;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * B表 服务类 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@SpringBootTest
class IBServiceTests {

    @Autowired
    private IBService bService;

    @Test
    void list() {
        List<B> bList = bService.list();
        for (B b : bList) {
            log.info(String.valueOf(b));
        }
    }

}
