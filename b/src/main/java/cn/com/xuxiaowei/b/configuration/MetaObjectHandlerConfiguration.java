package cn.com.xuxiaowei.b.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 插入、更新策略
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Configuration
public class MetaObjectHandlerConfiguration implements MetaObjectHandler {

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void insertFill(MetaObject metaObject) {

        HttpSession session = request.getSession();
        String id = session.getId();
        String remoteHost = request.getRemoteHost();

        this.strictInsertFill(metaObject, "createUsername", String.class, id);
        this.strictInsertFill(metaObject, "createIp", String.class, remoteHost);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        HttpSession session = request.getSession();
        String id = session.getId();
        String remoteHost = request.getRemoteHost();

        this.strictInsertFill(metaObject, "updateUsername", String.class, id);
        this.strictInsertFill(metaObject, "updateIp", String.class, remoteHost);
    }

}
