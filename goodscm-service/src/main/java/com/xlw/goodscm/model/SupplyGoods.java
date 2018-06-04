package com.xlw.goodscm.model;

import java.math.BigDecimal;

public class SupplyGoods extends Goods {
	private BigDecimal unitPrice;

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

}