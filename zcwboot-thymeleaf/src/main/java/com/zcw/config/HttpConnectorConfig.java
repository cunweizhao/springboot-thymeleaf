package com.zcw.config;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : HttpConnectorConfig
 * @Description : 此类专门负责http连接的相关配置
 * @Author : Zhaocunwei
 * @Date: 2020-04-02 17:54
 */
@Configuration
public class HttpConnectorConfig {
    public Connector initConnector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        //如果现在使用普通的http方式进行访问
        connector.setScheme("http");
        //用户访问的是80端口
        connector.setPort(80);
        //如果该连接为跳转，则表示不是一个新的连接对象
        connector.setSecure(false);
        //设置转发操作端口
        connector.setRedirectPort(443);
        return connector;
    }
    @Bean
    public TomcatEmbeddedServletContainerFactory servletContainerFactory(){
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory(){
            //该方法主要进行请求处理的上下配置，定义新的安全访问策略
            protected void postProcessContext(org.apache.catalina.Context context){
                SecurityConstraint securityConstraint = new SecurityConstraint();
                //定义用户访问约束要求
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                //匹配所有的访问映射路径
                collection.addPattern("/*");
                //追加路径映射访问配置
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            };
        };
        factory.addAdditionalTomcatConnectors(this.initConnector());
        return factory;
    }
}
