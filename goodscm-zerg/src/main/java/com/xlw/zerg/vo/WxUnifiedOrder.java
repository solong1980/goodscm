package com.xlw.zerg.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

public class WxUnifiedOrder implements Serializable {
	private static final long serialVersionUID = -1625456735825651293L;

	@JSONField(name = "body")
	private String body;

	@JSONField(name = "out_trade_no")
	private String outTradeNo;

	@JSONField(name = "trade_type")
	private String tradeType;

	@JSONField(name = "total_fee")
	private BigDecimal totalFee;

	private String openId;

	@JSONField(name = "notify_url")
	private String notifyUrl;

	@JSONField(name = "prepay_id")
	private String prepayId;

	@JSONField(name = "return_code")
	private String returnCode;

	@JSONField(name = "result_code")
	private String resultCode;

	private String msg;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public WxUnifiedOrder() {
		super();
	}

	public WxUnifiedOrder(Map<String, String> wxRespData) {
		super();
		setBody(wxRespData.get("body"));
		setOutTradeNo(wxRespData.get("out_trade_no"));
		setTradeType(wxRespData.get("trade_type"));
		setTotalFee(new BigDecimal(wxRespData.get("total_fee")));
		setOpenId(wxRespData.get("openid"));
		setPrepayId(wxRespData.get("prepay_id"));
		setReturnCode(wxRespData.get("return_code"));
		setResultCode(wxRespData.get("result_code"));
		setMsg(wxRespData.get("msg"));
	}

	public boolean isSuccess() {
		// 失败时不会返回result_code
		return "SUCCESS".equals(getReturnCode()) && !"SUCCESS".equals(getResultCode());
	}

}
