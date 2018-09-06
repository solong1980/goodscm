package com.xlw.zerg;

import java.util.Random;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class WXPublicUtils {

	// 生成令牌
	public static String generateToken() {
		// 隨機字符串
		String randChar = getRandChar(32);
		long timestamp = System.currentTimeMillis();
		// 盐
		String tokenSalt = "K(^HjuItdwe";
		return Hashing.md5().newHasher().putString(randChar + timestamp + tokenSalt, Charsets.UTF_8).hash().toString();
	}

	private static String strPol = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static String getRandChar(int len) {
		String str = null;
		int max = strPol.length() - 1;
		StringBuilder ser = new StringBuilder();
		for (int x = 0; x < len; x++) {
			Random random = new Random(System.currentTimeMillis());
			ser.append(strPol.indexOf(random.nextInt(max)));
		}

		return ser.toString();
	}

	/**
	 * 验证Token
	 * 
	 * @param msgSignature
	 *            签名串，对应URL参数的signature
	 * @param timeStamp
	 *            时间戳，对应URL参数的timestamp
	 * @param nonce
	 *            随机串，对应URL参数的nonce
	 *
	 * @return 是否为安全签名
	 * @throws AesException
	 *             执行失败，请查看该异常的错误码和具体的错误信息
	 */
	public static boolean verifyUrl(String msgSignature, String timeStamp, String nonce) throws AesException {
		// 这里的 WXPublicConstants.TOKEN 填写你自己设置的Token就可以了
		String signature = SHA1.getSHA1(WXPublicConstants.TOKEN, timeStamp, nonce);
		if (!signature.equals(msgSignature)) {
			throw new AesException(AesException.ValidateSignatureError);
		}
		return true;
	}
}