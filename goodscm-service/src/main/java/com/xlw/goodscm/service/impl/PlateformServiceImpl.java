package com.xlw.goodscm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.PlateformMapper;
import com.xlw.goodscm.model.Plateform;
import com.xlw.goodscm.service.PlateformService;

@Service
public class PlateformServiceImpl implements PlateformService {

	@Autowired
	private PlateformMapper plateformMapper;

	@Override
	public List<Plateform> selectAll() {
		return plateformMapper.selectAll();
	}

}
