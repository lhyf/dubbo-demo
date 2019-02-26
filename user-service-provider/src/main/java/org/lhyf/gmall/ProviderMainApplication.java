package org.lhyf.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/****
 * @author YF
 * @date 2019-02-26 15:49
 * @desc MainApplication
 *
 **/
public class ProviderMainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();

        System.in.read();
    }
}
