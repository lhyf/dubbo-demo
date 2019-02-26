package org.lhyf.gamll.service;

import org.lhyf.gamll.bean.UserAddress;

import java.util.List;

/****
 * @author YF
 * @date 2019-02-26 21:27
 * @desc UserServiceStub
 *
 *  本地存根代码(装饰器模式)
 **/
public class UserServiceStub implements UserService{

    private final UserService userService;

    /**
     * 传入的是userService远程代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddress(String userId) {
        System.out.println("UserServiceStub......本地存根...");
        if(userId != null && userId != ""){
            return userService.getUserAddress(userId);
        }
        return null;
    }
}
