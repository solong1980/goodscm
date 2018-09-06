package com.xlw.zerg.dao;

import com.xlw.zerg.model.BannerItem;
import java.util.List;

public interface BannerItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BannerItem record);

    BannerItem selectByPrimaryKey(Integer id);

    List<BannerItem> selectAll();

    int updateByPrimaryKey(BannerItem record);
}