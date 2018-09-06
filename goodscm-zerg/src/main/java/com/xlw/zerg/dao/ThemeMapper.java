package com.xlw.zerg.dao;

import com.xlw.zerg.model.Theme;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ThemeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Theme record);

	Theme selectByPrimaryKey(Integer id);

	List<Theme> selectAll();

	List<Theme> select(@Param("ids") List<String> ids);

	int updateByPrimaryKey(Theme record);
}