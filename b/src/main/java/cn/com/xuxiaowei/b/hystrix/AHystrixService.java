package cn.com.xuxiaowei.b.hystrix;

import cn.com.xuxiaowei.b.dto.SaveDTO;
import cn.com.xuxiaowei.b.exception.ParamException;
import cn.com.xuxiaowei.b.feign.AFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * A 服务 Hystrix
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class AHystrixService {

    private AFeignService aFeignService;

    @Autowired
    public void setaFeignService(AFeignService aFeignService) {
        this.aFeignService = aFeignService;
    }

    /**
     * 保存
     *
     * @param saveDTO 保存数据
     * @return 返回 结果
     */
    @HystrixCommand(fallbackMethod = "saveFallback")
    public Map<String, Object> save(SaveDTO saveDTO) {
        return aFeignService.save(saveDTO);
    }

    /**
     * 保存 异常数据
     *
     * @param saveDTO 保存数据
     * @param e       异常
     * @return 返回 异常 结果
     * @throws ParamException 异常
     */
    public Map<String, Object> saveFallback(SaveDTO saveDTO, Throwable e) throws ParamException {
        throw new ParamException("B001", "A 服务故障：" + e.getMessage(), null);
    }

}
