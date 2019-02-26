package org.lhyf.gmall.service.impl;

import org.lhyf.gamll.bean.UserAddress;
import org.lhyf.gamll.service.UserService;

import java.util.ArrayList;
import java.util.List;



public class UserServiceImpl implements UserService {

    private static final List<UserAddress> list = new ArrayList<>();

    static {
        list.add(new UserAddress(1, "辽宁省沈阳市", "1001", "tom", "13654976255", "true"));
        list.add(new UserAddress(2, "湖南省常德市", "1001", "jerry", "18215689468", "true"));
        list.add(new UserAddress(3, "广东省深圳市", "1002", "alita", "17363658595", "true"));
    }

    @Override
    public List<UserAddress> getUserAddress(String userId) {
        System.out.println("userId:" + userId);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

}
