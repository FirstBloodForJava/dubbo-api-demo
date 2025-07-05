package com.oycm.dubbo.provider;

import com.oycm.dubbo.api.ApiService;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

public class ProviderApplication {

    public static void main(String[] args) {
        // 定义要发布的服务信息
        ServiceConfig<ApiService> service = new ServiceConfig<>();
        service.setInterface(ApiService.class);
        service.setRef(new ApiServiceImpl());

        // 启动 dubbo
        DubboBootstrap.getInstance()
                .application("dubbo-provider")
                .registry(new RegistryConfig("zookeeper://192.168.125.158:2181"))
                .protocol(new ProtocolConfig("dubbo", -1))
                .service(service)
                .start()
                .await();
    }

}
