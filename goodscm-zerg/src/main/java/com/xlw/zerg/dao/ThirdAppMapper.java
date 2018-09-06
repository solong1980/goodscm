package com.xlw.zerg.dao;

import com.xlw.zerg.model.ThirdApp;
import java.util.List;

public interface ThirdAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ThirdApp record);

    ThirdApp selectByPrimaryKey(Integer id);

    List<ThirdApp> selectAll();

    int updateByPrimaryKey(ThirdApp record);
}