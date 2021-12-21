package cn.com.xuxiaowei.b.controller;

import cn.com.xuxiaowei.b.dto.SaveDTO;
import cn.com.xuxiaowei.b.entity.B;
import cn.com.xuxiaowei.b.service.IBService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private IBService bService;

    @Autowired
    public void setbService(IBService bService) {
        this.bService = bService;
    }

    @RequestMapping("/save")
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);

        B b = new B();
        b.setNum(10 / saveDTO.getBNum());
        b.setRemark(saveDTO.getB());
        bService.save(b);

        map.put("save", b);

        return map;
    }

}
