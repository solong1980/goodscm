package com.xlw.zerg.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.model.Order;
import com.xlw.zerg.service.OrderService;
import com.xlw.zerg.vo.OrderStatus;
import com.xlw.zerg.vo.ZergPage;

@RestController
@RequestMapping("/zerg/public/api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// 用户下单
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public OrderStatus placeOrder(@RequestHeader("token") String token, @RequestBody Order order) {
		return orderService.placeOrder(token, order);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order getOrderDetail(@PathVariable("id") Integer id) {
		return orderService.getOrderDetail(id);
	}

	@RequestMapping(value = "/delivery", method = RequestMethod.PUT)
	public void orderDelivery(Order order) {

	}

	@RequestMapping(value = "/by_user", method = RequestMethod.GET)
	public ZergPage<List<Order>> userOrders(@RequestHeader("token") String token, @RequestParam("pageNo") Integer pageNo,
			@RequestParam(value = "pageCount", required = false, defaultValue = "15") Integer pageCount) {
		List<Order> userOrders = orderService.userOrders(token, pageNo, pageCount);

		return new ZergPage<List<Order>>(userOrders, pageNo);
	}
}
