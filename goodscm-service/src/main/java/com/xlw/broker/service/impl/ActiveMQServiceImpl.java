package com.xlw.broker.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.xlw.broker.service.ActiveMQService;
import com.xlw.goodscm.model.Goods;

@Service
@ConditionalOnProperty(name = "spring.activemq.broker-url", havingValue = "true")
public class ActiveMQServiceImpl implements ActiveMQService {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination goodsAddTopic;

	/**
	 * 发送商品创建给主题队列，索引及页面生成
	 * 
	 * @param goods
	 */
	public void sendGoodAddMsg(Goods goods) {
		Long id = goods.getId();
		// 广播商品已添加的消息
		jmsTemplate.send(goodsAddTopic, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(id + "");
				// TextMessage textMessage = session.createTextMessage(itemId + "");
				return textMessage;
			}
		});
	}

	@JmsListener(destination = "goodsAddTopic")
	public void receiveGoodsAddTopic(String message) {
		System.out.println("创建商品静态页面");
		System.out.println("创建商品索引");
		System.out.println("监听topic=============监听topic");
		System.out.println(message);
	}

	@JmsListener(destination = "queue")
	public void receiveQueue(String message) {
		System.out.println("监听queue=============监听queue");
		System.out.println(message);

	}
}
