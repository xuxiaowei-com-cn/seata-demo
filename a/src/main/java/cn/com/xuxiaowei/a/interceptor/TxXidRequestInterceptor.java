package cn.com.xuxiaowei.a.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * 发送至服务时，携带 XID header
 *
 * @author xuxiaowei
 * @see feign.auth.BasicAuthRequestInterceptor 拦截器，添加使用HTTP基本身份验证所需的请求标头。
 * @see org.springframework.cloud.openfeign.encoding.FeignClientEncodingProperties Feign编码属性。
 * @see org.springframework.cloud.openfeign.encoding.FeignContentGzipEncodingInterceptor 通过指定Content-Encoding标头来启用HTTP请求有效负载压缩。
 * @see org.springframework.cloud.openfeign.encoding.FeignAcceptGzipEncodingInterceptor  通过指定Accept-Encoding标头来启用HTTP响应有效负载压缩。 尽管这还不意味着请求将被压缩，但它要求远程服务器了解标头并配置为压缩响应。 仍然不能基于媒体类型匹配和其他因素（如响应内容长度）来压缩所有响应。
 * @since 0.0.1
 */
@Slf4j
public class TxXidRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        // 分布式事务传递 TX_XID
        String xid = RootContext.getXID();
        if (StringUtils.isNotEmpty(xid)) {
            template.header(RootContext.KEY_XID, xid);
        }

    }

}
