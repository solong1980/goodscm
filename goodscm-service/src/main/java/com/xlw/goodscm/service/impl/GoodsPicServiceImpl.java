package com.xlw.goodscm.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsPicMapper;
import com.xlw.goodscm.model.GoodsPic;
import com.xlw.goodscm.service.GoodsPicService;
import com.xlw.goodscm.utils.FileUploadUtil;

/**
 * @author longlianghua
 */
@Service
public class GoodsPicServiceImpl implements GoodsPicService {

	@Autowired
	private GoodsPicMapper goodsPicMapper;

	@Override
	public List<GoodsPic> query(GoodsPic goodsPic) {
		List<GoodsPic> all = goodsPicMapper.selectAll();
		return all;
	}

	@Override
	public GoodsPic getById(Long id) {
		return goodsPicMapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(GoodsPic goodsPic) {
		goodsPicMapper.insert(goodsPic);
	}

	@Override
	public void add(List<GoodsPic> goodsPics) throws IOException {
		for (GoodsPic goodsPic : goodsPics) {
			if (goodsPic.getIsThumbnail()) {
				// create thumbnail and save as name xxx_thumbnail
			}
			FileUploadUtil.save(goodsPic.getRelativePath(), goodsPic.getPicData());
		}
		for (GoodsPic goodsPic : goodsPics) {
			goodsPicMapper.insert(goodsPic);
		}
	}

	@Override
	public void update(GoodsPic goodsPic) {
		goodsPicMapper.updateByPrimaryKey(goodsPic);
	}

	@Override
	public void addBatch(List<GoodsPic> goodsPics) throws IOException {
		for (GoodsPic goodsPic : goodsPics) {
			if (goodsPic.getIsThumbnail()) {
				// create thumbnail and save as name xxx_thumbnail
			}
			FileUploadUtil.save(goodsPic.getRelativePath(), goodsPic.getPicData());
		}
		goodsPicMapper.insertGoodsPics(goodsPics);
	}

	@Override
	public GoodsPic getThrumbnail(Long goodsId) {
		GoodsPic goodsPic = goodsPicMapper.getGoodsThumbnail(goodsId);
		return null;
	}

}
