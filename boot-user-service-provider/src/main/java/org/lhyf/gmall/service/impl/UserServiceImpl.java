package org.lhyf.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.lhyf.gamll.bean.UserAddress;
import org.lhyf.gamll.service.UserService;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@Component(value = "userService")
@Service
public class UserServiceImpl implements UserService {

    private static final List<UserAddress> list = new ArrayList<>();

    static {
        list.add(new UserAddress(1, "辽宁省沈阳市", "1001", "tom", "13654976255", "true"));
        list.add(new UserAddress(2, "湖南省常德市", "1001", "jerry", "18215689468", "true"));
        list.add(new UserAddress(3, "广东省深圳市", "1002", "alita", "17363658595", "true"));
    }

    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddress(String userId) {
        System.out.println("userId:" + userId);

        if(Math.random() > 0.5){
            throw new RuntimeException();
        }

        return list;
    }

}
