package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.Plateform;
import com.xlw.goodscm.model.PlateformReleaseRecord;
import com.xlw.goodscm.pojo.CmPage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PlateformReleaseRecordMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PlateformReleaseRecord record);

	PlateformReleaseRecord selectByPrimaryKey(Long id);

	List<PlateformReleaseRecord> selectAll();

	int updateByPrimaryKey(PlateformReleaseRecord record);

	List<Map<String, Object>> queryGoodsAllReleaseRecord(@Param("page") CmPage<Goods, List<Map<String, Object>>> page,
			@Param("plateforms") List<Plateform> plateforms);
}