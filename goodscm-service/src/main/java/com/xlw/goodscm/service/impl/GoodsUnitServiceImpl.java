package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsUnitMapper;
import com.xlw.goodscm.model.GoodsUnit;
import com.xlw.goodscm.service.GoodsUnitService;

/**
 * @author longlianghua
 */
@Service
public class GoodsUnitServiceImpl implements GoodsUnitService {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(GoodsUnitServiceImpl.class);

	@Autowired
	private GoodsUnitMapper goodsUnitMapper;

	@Override
	public void add(GoodsUnit goodsUnit) {
		goodsUnit.setCreateTime(new Date());
		goodsUnitMapper.insert(goodsUnit);
	}

	@Override
	public GoodsUnit get(Long id) {
		return goodsUnitMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(GoodsUnit goodsUnit) {
		goodsUnitMapper.updateByPrimaryKey(goodsUnit);
	}

	@Override
	public List<GoodsUnit> selectAll() {
		return goodsUnitMapper.selectAll();
	}

	@Override
	public void delete(Long id) {
		goodsUnitMapper.deleteByPrimaryKey(id);
	}

}
