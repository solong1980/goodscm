package com.xlw.broker.service.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.xlw.broker.service.ActiveMQService;
import com.xlw.goodscm.model.Goods;

@Service
@ConditionalOnProperty(name = "spring.activemq.broker-url", havingValue = "false")
public class EmptyActiveMQServiceImpl implements ActiveMQService {

	public void sendGoodAddMsg(Goods goods) {

	}

}
