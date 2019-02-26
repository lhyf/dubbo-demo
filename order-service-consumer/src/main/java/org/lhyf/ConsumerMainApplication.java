package org.lhyf;

import org.lhyf.gamll.bean.UserAddress;
import org.lhyf.gamll.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/****
 * @author YF
 * @date 2019-02-26 16:01
 * @desc MainApplication
 *
 **/
public class ConsumerMainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = ioc.getBean(OrderService.class);
        List<UserAddress> addresses1 = orderService.initOrder("1");
        List<UserAddress> addresses2 = orderService.initOrder("2");

        System.out.println(addresses1);
        System.out.println(addresses2);

        System.out.println("调用完成...");
        System.in.read();
    }
}
