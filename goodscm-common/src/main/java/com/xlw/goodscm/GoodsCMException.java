package com.xlw.goodscm;

import com.xlw.goodscm.ReturnCode.Codes;

public class GoodsCMException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ReturnCode.Codes code;

	public GoodsCMException(Codes code) {
		super(code.getMessage());
		this.code = code;
	}

	public GoodsCMException(Codes code, String message) {
		super(message == null ? code.getMessage() : message);
		this.code = code;
	}

	public ReturnCode.Codes getCode() {
		return code;
	}

	public void setCode(ReturnCode.Codes code) {
		this.code = code;
	}

}
