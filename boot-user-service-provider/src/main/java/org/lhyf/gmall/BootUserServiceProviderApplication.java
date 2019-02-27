package org.lhyf.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 1.导入依赖
 *    1). 导入dubbo-starter
 *    2). 导入bubbo的其他依赖
 *
 * SpringBoot 与 dubbo 整合的三种方式:
 * 1). 导入dubbo-starter, 在application.properties配置属性, 使用@Service[暴露服务],使用@Reference[引用服务]
 *      注意: 需要开启@EnableDubbo 注解
 * 2). 保留dubbo xml配置文件; 导入dubbo-starter, 使用@ImportResource导入dubbo的配置文件即可
 * 3). 使用注解API方式; 将每一个组件手动创建到容器中,让dubbo来扫描其他的组件(添加配置类); 使用@EnableDubbo(scanBasePackages = "org.lhyf.gmall.service.impl") 注解
 */
//@EnableDubbo    // 开启dubbo
//@ImportResource(locations = "classpath:provider.xml")
@SpringBootApplication
@EnableDubbo(scanBasePackages = "org.lhyf.gmall.service.impl")
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
