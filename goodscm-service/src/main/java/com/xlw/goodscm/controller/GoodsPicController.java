package com.xlw.goodscm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xlw.goodscm.Consts;
import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.GoodsPic;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.GoodsPicService;

@Controller
@RequestMapping("/goodspic")
public class GoodsPicController {
	private static Logger logger = LoggerFactory.getLogger(GoodsPicController.class);

	@Autowired
	private GoodsPicService goodsPicService;

	@RequestMapping("")
	public String index() throws Exception {
		return "goodspic";
	}

	@ResponseBody
	// 只用同时具有user:view和user:create权限才能访问
	// @RequiresPermissions(value = { "user:view", "user:create" }, logical =
	// Logical.AND)
	@RequestMapping("/query")
	public CmResult query(GoodsPic goodsPic) throws Exception {
		logger.info("query goods pics" + goodsPic);
		List<GoodsPic> goodsList = goodsPicService.query(goodsPic);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsList);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/get")
	public CmResult get(Long id) throws Exception {
		logger.info("query goods picture by id=" + id);
		GoodsPic goodsPic = goodsPicService.getById(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsPic);
		return cmResult;
	}

	@RequestMapping("/getthumbnail/{id}")
	public void getThumbnail(@PathVariable("id") Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("query goods thrumbnail picture by id=" + id);
		GoodsPic goodsPic = goodsPicService.getById(id);

		if (goodsPic != null) {
			String fileName = goodsPic.getName();
			String path = goodsPic.getRelativePath();

			String thumbnailPath = path + "_thumbnail";
			fileName = "thumbnail_" + fileName;

			File f = new File(thumbnailPath);
			String characterEncoding = request.getCharacterEncoding();
			if (f.exists()) {
				// 读取文件
				OutputStream os = new BufferedOutputStream(response.getOutputStream());
				try {
					response.setContentType("application/octet-stream");
					String header = request.getHeader("User-Agent");
					if (header != null && header.toUpperCase().indexOf("MSIE") > 0) { // IE浏览器
						fileName = URLEncoder.encode(fileName, "UTF-8");
					} else {
						fileName = URLDecoder.decode(fileName, characterEncoding);// 其他浏览器
					}
					response.setContentLengthLong(f.length());
					response.setHeader("Content-disposition",
							"attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1")); // 指定下载的文件名
					os.write(FileUtils.readFileToByteArray(f));
					os.flush();
				} catch (IOException e) {
					logger.error("download file for id=" + id + " fail", e);
					e.printStackTrace();
				} finally {
					if (os != null) {
						os.close();
					}
				}
			} else {
				logger.error("download file for id=" + id + " fail,file not exists");
				throw new RuntimeException("File not exists");
			}
		}else {
			logger.error("download file for id=" + id + " fail,goods has no thrumbnail picture");
			throw new RuntimeException("Goods has no thumbnail picture");
		}
	}

	@RequestMapping("/pic/{id}")
	public void getPic(@PathVariable("id") Long picId, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("query picture by id=" + picId);
		GoodsPic goodsPic = goodsPicService.getById(picId);

		if (goodsPic != null) {
			String fileName = goodsPic.getName();
			String path = goodsPic.getRelativePath();
			File f = new File(path);
			String characterEncoding = request.getCharacterEncoding();
			if (f.exists()) {
				// 读取文件
				OutputStream os = new BufferedOutputStream(response.getOutputStream());
				try {
					response.setContentType("application/octet-stream");
					String header = request.getHeader("User-Agent");
					if (header != null && header.toUpperCase().indexOf("MSIE") > 0) { // IE浏览器
						fileName = URLEncoder.encode(fileName, "UTF-8");
					} else {
						fileName = URLDecoder.decode(fileName, characterEncoding);// 其他浏览器
					}
					response.setContentLengthLong(f.length());
					response.setHeader("Content-disposition",
							"attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1")); // 指定下载的文件名
					response.setHeader("filename", new String(fileName.getBytes("utf-8"), "ISO8859-1"));// 方便rest
																										// template使用
					os.write(FileUtils.readFileToByteArray(f));
					os.flush();
				} catch (IOException e) {
					logger.error("download file for picture id=" + picId + " fail", e);
					e.printStackTrace();
				} finally {
					if (os != null) {
						os.close();
					}
				}
			} else {
				logger.error("download file for picture id=" + picId + " fail,file not exists");
				throw new RuntimeException("File not exists");
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public CmResult upload(HttpServletRequest request, @RequestParam("files") MultipartFile[] files) {
		try {
			String directory = request.getServletContext().getInitParameter(Consts.FILE_STORE_DIRECTORY_KEY);
			if (directory == null)
				directory = System.getProperty("user.home");
			String savePath = request.getServletContext().getInitParameter(Consts.SUB_DIRECTORY_KEY);
			if (savePath == null) {
				savePath = Consts.SUB_DIR;
			}
			savePath = directory + File.separator + savePath + File.separator + "goodspics";
			List<GoodsPic> goodsPics = new ArrayList<>();
			for (int i = 0; i < files.length; i++) {
				GoodsPic goodsPic = new GoodsPic();
				goodsPic.setRelativePath(savePath + File.separator + UUID.randomUUID().toString().replace("-", ""));
				goodsPic.setName(files[i].getOriginalFilename());
				goodsPic.setNo((short) i);
				goodsPic.setState((byte) 0);
				goodsPic.setPicData(files[i].getBytes());
				goodsPic.setCreateTime(new Date());
				goodsPics.add(goodsPic);
			}
			goodsPicService.add(goodsPics);
			List<Long> picIds = new ArrayList<>();
			for (GoodsPic pic : goodsPics) {
				picIds.add(pic.getId());
			}
			CmResult cmResult = CmResult.build(Codes.SUCCESS, picIds);
			return cmResult;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("upload pic failure", e);
			CmResult cmResult = CmResult.build(Codes.FAILURE);
			return cmResult;
		}
	}

}
