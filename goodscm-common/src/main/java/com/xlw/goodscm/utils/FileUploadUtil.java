package com.xlw.goodscm.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUploadUtil {
	public static void save(String path, byte[] content) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			throw new IOException("file:" + file + " is exists");
		}
		FileUtils.writeByteArrayToFile(file, content);
	}

	public static void save(String savePath, String originalFilename, String saveFileName, byte[] content) throws IOException {
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File saveFile = new File(savePath, saveFileName);
		if (saveFile.exists()) {
			throw new IOException("file:" + file + " is exists");
		}
		FileUtils.writeByteArrayToFile(new File(savePath, saveFileName), content);
	}
}
