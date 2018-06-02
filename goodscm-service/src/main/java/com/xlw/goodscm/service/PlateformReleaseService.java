package com.xlw.goodscm.service;

import java.util.List;
import java.util.Map;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.PlateformReleaseRecord;
import com.xlw.goodscm.pojo.CmPage;

public interface PlateformReleaseService {

	void batchReleaseRecord(Map<String, PlateformReleaseRecord> batchRecordMap);

	void updateReleaseRecord(PlateformReleaseRecord record);

	void addReleaseRecord(PlateformReleaseRecord record);

	List<Map<String, Object>> queryGoodsAdjointAllReleaseRecord(CmPage<Goods, List<Map<String, Object>>> page);

	void delete(Long id);

	PlateformReleaseRecord get(Long id);

}
