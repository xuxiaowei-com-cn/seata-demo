package cn.com.xuxiaowei.c.hystrix;

import cn.com.xuxiaowei.c.dto.SaveDTO;
import cn.com.xuxiaowei.c.exception.ParamException;
import cn.com.xuxiaowei.c.feign.BFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * B 服务 Hystrix
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class BHystrixService {

    private BFeignService bFeignService;

    @Autowired
    public void setbFeignService(BFeignService bFeignService) {
        this.bFeignService = bFeignService;
    }

    /**
     * 保存
     *
     * @param saveDTO 保存数据
     * @return 返回 结果
     */
    @HystrixCommand(fallbackMethod = "saveFallback")
    public Map<String, Object> save(SaveDTO saveDTO) {
        return bFeignService.save(saveDTO);
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
        throw new ParamException("B001", "B 服务故障：" + e.getMessage(), null);
    }

}
