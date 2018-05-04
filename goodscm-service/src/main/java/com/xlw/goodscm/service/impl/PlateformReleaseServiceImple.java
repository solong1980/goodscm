package com.xlw.goodscm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.PlateformReleaseRecordMapper;
import com.xlw.goodscm.model.PlateformReleaseRecord;
import com.xlw.goodscm.service.PlateformReleaseService;

@Service
public class PlateformReleaseServiceImple implements PlateformReleaseService {

	@Autowired
	private PlateformReleaseRecordMapper plateformReleaseRecordMapper;
	
	
	@Override
	public void batchReleaseRecord(Map<String, PlateformReleaseRecord> batchRecordMap) {

	}

	@Override
	public void updateReleaseRecord(PlateformReleaseRecord record) {
		plateformReleaseRecordMapper.updateByPrimaryKey(record);
	}

	@Override
	public void addReleaseRecord(PlateformReleaseRecord record) {

	}

	@Override
	public void queryGoodsAllReleaseRecord(PlateformReleaseRecord record) {

	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public PlateformReleaseRecord get(Long id) {
		return null;
	}

}
