package com.xlw.zerg.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.model.Order;
import com.xlw.zerg.service.OrderService;
import com.xlw.zerg.service.WxCallbackService;
import com.xlw.zerg.vo.OrderStatus;

@RestController
@RequestMapping("/zerg/public/api/v1/pay")
public class PayController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private WxCallbackService wxCallbackService;

	/**
	 * 支付申请
	 * 
	 * @return
	 * @return array
	 * @throws Exception
	 */
	// 生单
	@RequestMapping("/pre_order")
	public OrderStatus preOrder(@RequestHeader String token, @RequestBody Order order) {
		return orderService.preOrder(token, order);
	}

	/**
	 * 支付回调
	 * 
	 * @throws Exception
	 */
	@RequestMapping(name = "/notify", produces = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.POST)
	public void receiveNotify(@RequestBody String wxResponese) throws Exception {
		wxCallbackService.receiveNotify(wxResponese);
	}

}
