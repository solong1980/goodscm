package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.PlateformReleaseRecordMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.Plateform;
import com.xlw.goodscm.model.PlateformReleaseRecord;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.PlateformReleaseService;
import com.xlw.goodscm.service.PlateformService;

@Service
public class PlateformReleaseServiceImple implements PlateformReleaseService {

	@Autowired
	private PlateformReleaseRecordMapper plateformReleaseRecordMapper;
	@Autowired
	private PlateformService plateformService;

	@Override
	public void batchReleaseRecord(Map<String, PlateformReleaseRecord> batchRecordMap) {
		
	}

	@Override
	public void updateReleaseRecord(PlateformReleaseRecord record) {
		plateformReleaseRecordMapper.updateByPrimaryKey(record);
	}

	@Override
	public void addReleaseRecord(PlateformReleaseRecord record) {
		record.setCreateTime(new Date());
		plateformReleaseRecordMapper.insert(record);
	}

	@Override
	public List<Map<String, Object>> queryGoodsAdjointAllReleaseRecord(CmPage<Goods, List<Map<String, Object>>> page) {

		List<Plateform> plateforms = plateformService.selectAll();
		return plateformReleaseRecordMapper.queryGoodsAdjointAllReleaseRecord(page, plateforms);
	}

	@Override
	public void delete(Long id) {
		plateformReleaseRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PlateformReleaseRecord get(Long id) {
		return plateformReleaseRecordMapper.selectByPrimaryKey(id);
	}

}
