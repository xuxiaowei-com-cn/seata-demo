package cn.com.xuxiaowei.c.controller;

import cn.com.xuxiaowei.c.dto.SaveDTO;
import cn.com.xuxiaowei.c.hystrix.AHystrixService;
import cn.com.xuxiaowei.c.hystrix.BHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/a")
public class ARestController {

    private AHystrixService aHystrixService;

    private BHystrixService bHystrixService;

    @Autowired
    public void setaHystrixService(AHystrixService aHystrixService) {
        this.aHystrixService = aHystrixService;
    }

    @Autowired
    public void setbHystrixService(BHystrixService bHystrixService) {
        this.bHystrixService = bHystrixService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @RequestMapping("/save")
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);

        Map<String, Object> aSave = aHystrixService.save(saveDTO);
        Map<String, Object> bSave = bHystrixService.save(saveDTO);

        map.put("aSave", aSave);
        map.put("bSave", bSave);

        return map;
    }

}
