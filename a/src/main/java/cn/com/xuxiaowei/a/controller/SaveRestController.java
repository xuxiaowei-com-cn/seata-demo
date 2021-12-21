package cn.com.xuxiaowei.a.controller;

import cn.com.xuxiaowei.a.dto.SaveDTO;
import cn.com.xuxiaowei.a.entity.A;
import cn.com.xuxiaowei.a.service.IAService;
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
@RestController
public class SaveRestController {

    private IAService aService;

    @Autowired
    public void setaService(IAService aService) {
        this.aService = aService;
    }

    @RequestMapping("/save")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Map<String, Object> save(@RequestBody SaveDTO saveDTO) {
        Map<String, Object> map = new HashMap<>(4);

        A a = new A();
        a.setNum(10 / saveDTO.getANum());
        a.setRemark(saveDTO.getA());
        aService.save(a);

        map.put("save", a);

        return map;
    }

}
