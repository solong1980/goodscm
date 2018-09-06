package com.xlw.zerg.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.zerg.dao.BannerMapper;
import com.xlw.zerg.dao.ThemeMapper;
import com.xlw.zerg.model.Banner;
import com.xlw.zerg.model.Theme;

@Service
public class FrontEndService {

	@Autowired
	private ThemeMapper themeMapper;
	@Autowired
	private BannerMapper bannerMapper;

	public Banner banner(Integer id) {
		Banner banner = bannerMapper.selectByPrimaryKey(id);
		return banner;
	}

	public List<Theme> theme(String ids) {
		String[] sid = ids.split(",");
		return themeMapper.select(Arrays.asList(sid));
	}

	public Theme theme(Integer id) {
		return themeMapper.selectByPrimaryKey(id);
	}
}
