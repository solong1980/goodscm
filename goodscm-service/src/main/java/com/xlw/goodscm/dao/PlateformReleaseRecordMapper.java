package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.PlateformReleaseRecord;
import java.util.List;

public interface PlateformReleaseRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlateformReleaseRecord record);

    PlateformReleaseRecord selectByPrimaryKey(Long id);

    List<PlateformReleaseRecord> selectAll();

    int updateByPrimaryKey(PlateformReleaseRecord record);
}