package org.lhyf.gmall.config;

import com.alibaba.dubbo.config.*;
import org.lhyf.gamll.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/****
 * @author YF
 * @date 2019-02-27 21:03
 * @desc DubboConfig
 *
 **/
@Configuration
public class DubboConfig {

    //    <dubbo:application name="user-service-provider" ></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    //    <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    //    <dubbo:protocol name="dubbo" port="20882"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20881);
        return protocolConfig;
    }

    //    <dubbo:service interface="org.lhyf.gamll.service.UserService" ref="userService01" version="1.0.0">
//        <dubbo:method name="getUserAddress" timeout="1000"  ></dubbo:method>
//    </dubbo:service>
    @Bean
    public ServiceConfig<UserService> serviceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");
        serviceConfig.setTimeout(2000);

        // 配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddress");
        methodConfig.setTimeout(1000);
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);
        return serviceConfig;
    }
//  <dubbo:monitor protocol="registry"></dubbo:monitor>
    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

}
