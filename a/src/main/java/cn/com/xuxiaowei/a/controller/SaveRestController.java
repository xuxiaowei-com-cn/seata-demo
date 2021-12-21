package cn.com.xuxiaowei.a.controller;

import cn.com.xuxiaowei.a.dto.SaveDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxiaowei
 * @since 0.0.1
 */
@RestController
public class SaveRestController {

    @RequestMapping("/save")
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);

        map.put("save", true);

        return map;
    }

}
