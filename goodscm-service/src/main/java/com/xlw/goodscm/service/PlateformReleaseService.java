package com.xlw.goodscm.service;

import java.util.Map;

import com.xlw.goodscm.model.PlateformReleaseRecord;

public interface PlateformReleaseService {

	void batchReleaseRecord(Map<String, PlateformReleaseRecord> batchRecordMap);

	void updateReleaseRecord(PlateformReleaseRecord record);

	void addReleaseRecord(PlateformReleaseRecord record);

	void queryGoodsAllReleaseRecord(PlateformReleaseRecord record);

	void delete(Long id);

	PlateformReleaseRecord get(Long id);

}
