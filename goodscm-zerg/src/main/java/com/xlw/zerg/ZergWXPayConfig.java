package com.xlw.zerg;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;

public class ZergWXPayConfig implements WXPayConfig {
	private byte[] certData;

	public ZergWXPayConfig() throws Exception {
		String certPath = "/path/to/apiclient_cert.p12";
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}

	public String getAppID() {
		return WxSetting.wxAppID;
	}

	public String getMchID() {
		return WxSetting.wxMachID;
	}

	public String getKey() {
		return WxSetting.wxAppSecret;
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	public int getHttpConnectTimeoutMs() {
		return 8000;
	}

	public int getHttpReadTimeoutMs() {
		return 10000;
	}
}
