package cn.com.xuxiaowei.a.service.impl;

import cn.com.xuxiaowei.a.entity.A;
import cn.com.xuxiaowei.a.mapper.AMapper;
import cn.com.xuxiaowei.a.service.IAService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * A表 服务实现类
 * </p>
 *
 * @author xuxiaowei
 * @since 2021-12-21
 */
@Service
public class AServiceImpl extends ServiceImpl<AMapper, A> implements IAService {

}
