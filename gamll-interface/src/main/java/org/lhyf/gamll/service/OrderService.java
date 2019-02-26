package org.lhyf.gamll.service;

import org.lhyf.gamll.bean.UserAddress;

import java.util.List;

public interface OrderService {

	List<UserAddress> initOrder(String userId);
}
