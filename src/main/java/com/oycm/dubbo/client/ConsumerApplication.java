package com.oycm.dubbo.client;

import com.oycm.dubbo.api.ApiService;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import java.io.IOException;

public class ConsumerApplication {

    public static void main(String[] args) throws IOException {
        // 定义接口信息
        ReferenceConfig<ApiService> reference = new ReferenceConfig<>();
        reference.setInterface(ApiService.class);

        // dubbo 启动，根据配置信息获取
        DubboBootstrap.getInstance()
                .application("dubbo-consumer")
                .registry(new RegistryConfig("zookeeper://192.168.125.158:2181"))
                .reference(reference);

        ApiService service = reference.get();
        String message = service.hello("dubbo");
        System.out.println("Receive result ======> " + message);
        System.in.read();
    }

}
