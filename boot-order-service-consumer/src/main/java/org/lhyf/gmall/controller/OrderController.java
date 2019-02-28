package org.lhyf.gmall.controller;

import org.lhyf.gamll.bean.UserAddress;
import org.lhyf.gamll.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/****
 * @author YF
 * @date 2019-02-26 17:37
 * @desc OrderController
 *
 **/
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "init")
    public List<UserAddress> initOrder(@RequestParam("userid") String userId) {

        List<UserAddress> addresses = orderService.initOrder(userId);
        return addresses;
    }
}
