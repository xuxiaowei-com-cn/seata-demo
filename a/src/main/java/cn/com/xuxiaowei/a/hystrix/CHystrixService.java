package cn.com.xuxiaowei.a.hystrix;

import cn.com.xuxiaowei.a.dto.SaveDTO;
import cn.com.xuxiaowei.a.exception.ParamException;
import cn.com.xuxiaowei.a.feign.CFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * C 服务 Hystrix
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class CHystrixService {

    private CFeignService cFeignService;

    @Autowired
    public void setcFeignService(CFeignService cFeignService) {
        this.cFeignService = cFeignService;
    }

    /**
     * 保存
     *
     * @param saveDTO 保存数据
     * @return 返回 结果
     */
    @HystrixCommand(fallbackMethod = "saveFallback")
    public Map<String, Object> save(SaveDTO saveDTO) {
        return cFeignService.save(saveDTO);
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
        throw new ParamException("B001", "C 服务故障：" + e.getMessage(), null);
    }

}
