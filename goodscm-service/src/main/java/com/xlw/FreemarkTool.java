package com.xlw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Files;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.utils.FreemarkUtil;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkTool {
	private static final Logger logger = LoggerFactory.getLogger(FreemarkTool.class);

	private static FreemarkUtil freemarkUtil = new FreemarkUtil();
	private static Template template;
	static {
		try {
			template = freemarkUtil.getTemplate("goodscm.ftl");
		} catch (IOException e) {
			logger.error("create goods page template error", e);
		}
	}

	public static String exportGoodsPage(Goods goods) {
		Writer out = new StringWriter();
		try {
			template.process(goods, out);
			System.out.println(out.toString());
			return out.toString();
		} catch (TemplateException | IOException e) {
			logger.error("export goods page  error", e);
		}
		return null;
	}

	public static void zip(String zipName, String fileName, String pageContent, List<String> pictures)
			throws IOException {
		ZipOutputStream out = null;
		BufferedOutputStream bo = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipName));
			bo = new BufferedOutputStream(out);

			out.putNextEntry(new ZipEntry(fileName));
			bo.write(pageContent.getBytes());

			for (String picFilePath : pictures) {
				File file = new File(picFilePath);
				out.putNextEntry(new ZipEntry("pics/" + file.getName()));
				out.write(Files.toByteArray(file));
			}
		} finally {
			if (bo != null)
				bo.close();
			if (out != null)
				out.close();
		}
	}

	public static void main(String[] args) throws IOException {
		List<String> pics = new ArrayList<>();
		pics.add("E:\\game-work\\workspace\\goodscm\\goodscm\\goodscm-service\\2016-11-01 2016-11-01 001 001.jpg");
		pics.add("E:\\game-work\\workspace\\goodscm\\goodscm\\goodscm-service\\2016-10-27 2016-10-27 001 001.jpg");
		pics.add("E:\\game-work\\workspace\\goodscm\\goodscm\\goodscm-service\\2016-10-19 2016-10-19 002 001.jpg");
		zip("ziptest.zip", "ne.html", "xxxxx", pics);
	}
}
