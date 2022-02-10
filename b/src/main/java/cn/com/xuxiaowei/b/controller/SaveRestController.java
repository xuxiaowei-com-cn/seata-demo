package cn.com.xuxiaowei.b.controller;

import cn.com.xuxiaowei.b.dto.SaveDTO;
import cn.com.xuxiaowei.b.entity.B;
import cn.com.xuxiaowei.b.hystrix.CHystrixService;
import cn.com.xuxiaowei.b.service.IBService;
import io.seata.core.context.RootContext;
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

    private IBService bService;

//    private CHystrixService cHystrixService;

    @Autowired
    public void setbService(IBService bService) {
        this.bService = bService;
    }

//    @Autowired
//    public void setcHystrixService(CHystrixService cHystrixService) {
//        this.cHystrixService = cHystrixService;
//    }

    @RequestMapping("/save")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);

        log.info("当前 XID: {}", RootContext.getXID());

        B b = new B();
        b.setNum(10 / saveDTO.getBNum());
        b.setRemark(saveDTO.getB());
        bService.save(b);

//        Map<String, Object> cSave = cHystrixService.save(saveDTO);
//        map.put("cSave", cSave);

        map.put("save", b);

        return map;
    }

}
