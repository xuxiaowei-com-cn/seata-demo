package cn.com.xuxiaowei.a.controller;

import cn.com.xuxiaowei.a.dto.SaveDTO;
import cn.com.xuxiaowei.a.hystrix.BHystrixService;
import cn.com.xuxiaowei.a.hystrix.CHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/b")
public class BRestController {

    private BHystrixService bHystrixService;

    private CHystrixService cHystrixService;

    @Autowired
    public void setbHystrixService(BHystrixService bHystrixService) {
        this.bHystrixService = bHystrixService;
    }

    @Autowired
    public void setcHystrixService(CHystrixService cHystrixService) {
        this.cHystrixService = cHystrixService;
    }

    @RequestMapping("/save")
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);

        Map<String, Object> bSave = bHystrixService.save(saveDTO);
        Map<String, Object> cSave = cHystrixService.save(saveDTO);

        map.put("bSave", bSave);
        map.put("cSave", cSave);

        return map;
    }

}
