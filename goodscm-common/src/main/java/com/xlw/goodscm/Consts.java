package com.xlw.goodscm;

/**
 * 常量
 */
public class Consts {
	public static final String REQUEST_TOOOOO_FAST = "request tooooo fast !";

	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";

	public static final String FILE_STORE_DIRECTORY_KEY = "FILE_STORE_DIRECTORY";
	public static final String FILE_DIR = "D:\\NewArt";
	
	public static final String SUB_DIRECTORY_KEY = "SUB_DIRECTORY_KEY";
	public static final String SUB_DIR = "datas";

	public static final String SESSION_USER = "SESSION_USER";

	public static enum GoodsAuditStatus {
		UNADUIT(10), AUDIT(20);
		private short code;

		private GoodsAuditStatus(int code) {
			this.code = (short) code;
		}

		public short getCode() {
			return this.code;
		}
	}
}
