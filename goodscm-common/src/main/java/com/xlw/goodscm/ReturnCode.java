package com.xlw.goodscm;

public class ReturnCode {

	public enum Codes {
		SUCCESS(200, Consts.SUCCESS), 
		
		LOGIN_SUCCESS(200, "登录成功"),
		NO_LOGIN(201, "未登录"),
		
		PARAM_ERROR(400, "参数错误"), 
		
		TOKEN_ERROR(401, "token错误"), 
		
		NO_PERMISSION(403, "用户无权限"), 
		
		
		FAILURE(500, Consts.FAILURE), 
		
		LOGIN_FAILURE(503, "登录失败，该用户已被冻结"), 
		
		PASSWORD_ERROR(503, "密码错误"), 
		
		USER_NOEXIST(503, "该用户不存在"),
		
		;
		private Integer code;
		private String message;

		private Codes(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		public Integer getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

	}

}
