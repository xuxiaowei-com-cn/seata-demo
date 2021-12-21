package cn.com.xuxiaowei.b.controller;

import cn.com.xuxiaowei.b.dto.SaveDTO;
import cn.com.xuxiaowei.b.hystrix.AHystrixService;
import cn.com.xuxiaowei.b.hystrix.CHystrixService;
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

    private CHystrixService cHystrixService;

    @Autowired
    public void setaHystrixService(AHystrixService aHystrixService) {
        this.aHystrixService = aHystrixService;
    }

    @Autowired
    public void setcHystrixService(CHystrixService cHystrixService) {
        this.cHystrixService = cHystrixService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @RequestMapping("/save")
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);

        Map<String, Object> aSave = aHystrixService.save(saveDTO);
        Map<String, Object> cSave = cHystrixService.save(saveDTO);

        map.put("aSave", aSave);
        map.put("cSave", cSave);

        return map;
    }

}
