package com.xlw.zerg.dao;

import com.xlw.zerg.model.Banner;
import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    Banner selectByPrimaryKey(Integer id);

    List<Banner> selectAll();

    int updateByPrimaryKey(Banner record);
}