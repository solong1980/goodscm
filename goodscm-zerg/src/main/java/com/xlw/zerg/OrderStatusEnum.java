package com.xlw.zerg;

public enum OrderStatusEnum {
	// 待支付
	UNPAID(1),
	// 已支付
	PAID(2),
	// 已发货
	DELIVERED(3),
	// 已支付，但库存不足
	PAID_BUT_OUT_OF(4),
	// 已处理PAID_BUT_OUT_OF
	HANDLED_OUT_OF(5);
	private Integer code;

	private OrderStatusEnum(Integer code) {
		this.code = code;
	}

	public Integer code() {
		return this.code;
	}
}
