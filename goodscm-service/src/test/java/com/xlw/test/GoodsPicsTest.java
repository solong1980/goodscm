package com.xlw.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class GoodsPicsTest extends BaseTest {

	@Test
	public void testAddGoodsPic() throws URISyntaxException {
		List<Long> addGoodsPics = addGoodsPics(null);
		assert (addGoodsPics.size() == 3);
	}

	@Test
	public void testGetGoodsThumbnail() throws URISyntaxException, IOException {
		URI url = new URI(localhost + "/goodspic/getthumbnail/picid/61");
		url = new URI(localhost + "/goodspic/getthumbnail/goodsid/22");
		ResponseEntity<byte[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, null, byte[].class);
		int statusCodeValue = responseEntity.getStatusCodeValue();
		if (statusCodeValue != 200) {
			System.out.println(responseEntity.toString());
			return;
		}
		// String type = responseEntity.getHeaders().getContentType().getSubtype();
		// if (!type.contains("octet-stream")) {
		// System.out.println(new String(responseEntity.getBody()));
		// return;
		// }
		if (MediaType.APPLICATION_OCTET_STREAM.compareTo(responseEntity.getHeaders().getContentType()) == 0) {
			HttpHeaders headers = responseEntity.getHeaders();
			List<String> list = headers.get("filename");
			String filename = "thumbnail_21.jpg";
			if (list != null && !list.isEmpty())
				filename = list.get(0);

			byte[] result = responseEntity.getBody();
			ByteArrayInputStream inputStream = null;
			FileOutputStream outputStream = null;
			try {
				inputStream = new ByteArrayInputStream(result);
				File file = new File(filename);
				if (!file.exists()) {
					file.createNewFile();
				}

				outputStream = new FileOutputStream(file);
				int len = 0;
				byte[] buf = new byte[1024];
				while ((len = inputStream.read(buf, 0, 1024)) != -1) {
					outputStream.write(buf, 0, len);
				}
				outputStream.flush();

			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}
		}

	}

	@Test
	public void testGetGoodsPic() throws URISyntaxException, IOException {
		URI url = new URI(localhost + "/goodspic/pic/52");

		ResponseEntity<byte[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, null, byte[].class);
		HttpHeaders headers = responseEntity.getHeaders();
		List<String> list = headers.get("filename");
		String filename = "52.jpg";
		if (list != null && !list.isEmpty())
			filename = list.get(0);

		byte[] result = responseEntity.getBody();
		ByteArrayInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new ByteArrayInputStream(result);
			File file = new File(filename);
			if (!file.exists()) {
				file.createNewFile();
			}

			outputStream = new FileOutputStream(file);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = inputStream.read(buf, 0, 1024)) != -1) {
				outputStream.write(buf, 0, len);
			}
			outputStream.flush();

		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	@Test
	public void test() {
	}

}
