package org.lhyf.gamll.service;

import org.lhyf.gamll.bean.UserAddress;

import java.util.List;

public interface UserService {

	/**
	 * 按用户Id返回收货地址
	 * @param userId
	 * @return
	 */
	List<UserAddress> getUserAddress(String userId);
}
