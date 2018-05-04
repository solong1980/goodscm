package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.Plateform;
import java.util.List;

public interface PlateformMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Plateform record);

    Plateform selectByPrimaryKey(Long id);

    List<Plateform> selectAll();

    int updateByPrimaryKey(Plateform record);
}