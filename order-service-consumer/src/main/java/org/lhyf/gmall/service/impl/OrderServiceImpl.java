package org.lhyf.gmall.service.impl;

import org.lhyf.gamll.bean.UserAddress;
import org.lhyf.gamll.service.OrderService;
import org.lhyf.gamll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1.将服务提供者注册到注册中心(暴露服务)
 * 	①.导入dubbo步骤
 * 2.让服务消费者去注册中心定于服务提供者的服务地址
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserService userService;

	@Override
	public void initOrder(String userId) {
		// 1. 查询用户的收货地址
		List<UserAddress> address = userService.getUserAddress(userId);
		System.out.println(address);
	}

}
