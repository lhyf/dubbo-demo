package org.lhyf.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.lhyf.gamll.bean.UserAddress;
import org.lhyf.gamll.service.OrderService;
import org.lhyf.gamll.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 1.将服务提供者注册到注册中心(暴露服务)
 * ①.导入dubbo步骤
 * 2.让服务消费者去注册中心定于服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

    //	@Autowired
	@Reference(loadbalance = "roundrobin") // 使用dubbo 的注入
//    @Reference(url = "127.0.0.1:20880") // dubbo 直连
    private UserService userService;

	@HystrixCommand(fallbackMethod = "errorHandler")
    @Override
    public List<UserAddress> initOrder(String userId) {
        // 1. 查询用户的收货地址
        List<UserAddress> address = userService.getUserAddress(userId);
        System.out.println(address);
        return address;
    }

    public List<UserAddress> errorHandler(String userId) {

        return Arrays.asList(new UserAddress(10,"测试地址","测试","测试","测试","default"));
    }

}
