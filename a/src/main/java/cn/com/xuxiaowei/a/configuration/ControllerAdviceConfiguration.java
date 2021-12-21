package cn.com.xuxiaowei.a.configuration;

import cn.com.xuxiaowei.a.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link Controller}、{@link RestController} 异常处理
 *
 * @author 徐晓伟
 */
@Slf4j
@ControllerAdvice
public class ControllerAdviceConfiguration {

    /**
     * 参数异常
     *
     * @param request   请求
     * @param response  响应
     * @param exception 异常
     * @return 返回 验证结果
     */
    @ResponseBody
    @ExceptionHandler(ParamException.class)
    public Map<String, Object> paramException(HttpServletRequest request, HttpServletResponse response,
                                              ParamException exception) {
        Map<String, Object> map = new HashMap<>(4);

        map.put("code", exception.getCode());
        map.put("msg", exception.getMsg());
        map.put("field", exception.getField());

        return map;
    }

}
