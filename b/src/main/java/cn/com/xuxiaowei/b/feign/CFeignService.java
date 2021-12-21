package cn.com.xuxiaowei.b.feign;

import cn.com.xuxiaowei.b.dto.SaveDTO;
import cn.com.xuxiaowei.b.interceptor.TxXidRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * C 服务 接口
 *
 * @author xuxiaowei
 * @see FeignClient#contextId() 防止出现相同的 {@link FeignClient#value()} 时异常
 * @since 0.0.1
 */
@FeignClient(value = "c", contextId = "cFeignService", configuration = TxXidRequestInterceptor.class)
public interface CFeignService {

    /**
     * 保存数据
     *
     * @param saveDTO 保存数据
     * @return 返回 结果
     */
    @PostMapping("/save")
    Map<String, Object> save(@RequestBody SaveDTO saveDTO);

}
