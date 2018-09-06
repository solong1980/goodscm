package com.xlw.zerg.dao;

import com.xlw.zerg.model.Image;
import java.util.List;

public interface ImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Image record);

    Image selectByPrimaryKey(Integer id);

    List<Image> selectAll();

    int updateByPrimaryKey(Image record);
}