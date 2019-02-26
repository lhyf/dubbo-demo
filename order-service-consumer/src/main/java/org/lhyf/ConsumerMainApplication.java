package org.lhyf;

import org.lhyf.gamll.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

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
        orderService.initOrder("1");

        System.out.println("调用完成...");
        System.in.read();
    }
}
