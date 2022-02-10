package cn.com.xuxiaowei.c.controller;

import cn.com.xuxiaowei.c.dto.SaveDTO;
import cn.com.xuxiaowei.c.entity.C;
import cn.com.xuxiaowei.c.service.ICService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
public class SaveRestController {

    private ICService cService;

    @Autowired
    public void setcService(ICService cService) {
        this.cService = cService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @RequestMapping("/save")
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);


        C c = new C();
        c.setNum(10 / saveDTO.getCNum());
        c.setRemark(saveDTO.getC());
        cService.save(c);

        map.put("save", c);

        return map;
    }

}
