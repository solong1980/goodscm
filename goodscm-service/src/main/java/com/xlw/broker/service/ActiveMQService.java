package com.xlw.broker.service;

import com.xlw.goodscm.model.Goods;

public interface ActiveMQService {
	public void sendGoodAddMsg(Goods goods);
}
