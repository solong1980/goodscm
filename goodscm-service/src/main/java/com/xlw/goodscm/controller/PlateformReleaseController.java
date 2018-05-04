package com.xlw.goodscm.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlw.goodscm.ReturnCode;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.PlateformReleaseRecord;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.PlateformReleaseService;

@Controller
@RequestMapping("/plateformrelease")
public class PlateformReleaseController {
	private static Logger logger = LoggerFactory.getLogger(PlateformReleaseController.class);

	@Autowired
	private PlateformReleaseService plateformReleaseService;

	@ResponseBody
	@RequestMapping("/querygoodsreleaserecord")
	public CmResult queryGoodsAllReleaseRecord(@RequestBody CmPage<Goods, List<Map<String, Object>>> page) throws Exception {
		logger.info("queryGoodsAllReleaseRecord " + page);
		List<Map<String, Object>> goodsAllReleaseRecord = plateformReleaseService.queryGoodsAllReleaseRecord(page);
		CmResult cmResult = CmResult.build(ReturnCode.Codes.SUCCESS, goodsAllReleaseRecord);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) throws Exception {
		logger.info("delete release record id=" + id);
		plateformReleaseService.delete(id);
		CmResult cmResult = CmResult.build(ReturnCode.Codes.SUCCESS, null);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) throws Exception {
		logger.info("get release record id=" + id);
		PlateformReleaseRecord releaseRecord = plateformReleaseService.get(id);
		CmResult cmResult = CmResult.build(ReturnCode.Codes.SUCCESS, releaseRecord);
		return cmResult;
	}

	/**
	 * 批量处理平台发布记录
	 * 
	 * @param batchRecordMap
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/batchrecord")
	public CmResult batchReleaseRecord(@RequestBody Map<String, PlateformReleaseRecord> batchRecordMap)
			throws Exception {
		logger.info("batchReleaseRecord " + batchRecordMap);
		plateformReleaseService.batchReleaseRecord(batchRecordMap);
		CmResult cmResult = CmResult.build(ReturnCode.Codes.SUCCESS, null);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/updatereleaserecord")
	public CmResult updateReleaseRecord(@RequestBody PlateformReleaseRecord record) throws Exception {
		logger.info("updateReleaseRecord " + record);
		plateformReleaseService.updateReleaseRecord(record);
		CmResult cmResult = CmResult.build(ReturnCode.Codes.SUCCESS, null);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/addreleaserecord")
	public CmResult addReleaseRecord(@RequestBody PlateformReleaseRecord record) throws Exception {
		logger.info("addReleaseRecord " + record);
		plateformReleaseService.addReleaseRecord(record);
		CmResult cmResult = CmResult.build(ReturnCode.Codes.SUCCESS, null);
		return cmResult;
	}

}
