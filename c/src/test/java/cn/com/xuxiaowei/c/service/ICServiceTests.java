package cn.com.xuxiaowei.c.service;

import cn.com.xuxiaowei.c.entity.C;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * C表 服务类 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@SpringBootTest
class ICServiceTests {

    @Autowired
    private ICService cService;

    @Test
    void list() {
        List<C> cList = cService.list();
        for (C c : cList) {
            log.info(String.valueOf(c));
        }
    }

}
