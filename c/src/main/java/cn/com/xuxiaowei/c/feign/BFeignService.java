package cn.com.xuxiaowei.c.feign;

import cn.com.xuxiaowei.c.dto.SaveDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * B 服务 接口
 *
 * @author xuxiaowei
 * @see FeignClient#contextId() 防止出现相同的 {@link FeignClient#value()} 时异常
 * @since 0.0.1
 */
@FeignClient(value = "b", contextId = "bFeignService")
public interface BFeignService {

    /**
     * 保存数据
     *
     * @param saveDTO 保存数据
     * @return 返回 结果
     */
    @PostMapping("/save")
    Map<String, Object> save(@RequestBody SaveDTO saveDTO);

}
