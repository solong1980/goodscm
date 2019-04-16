package com.xlw.goodscm.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsPicMapper;
import com.xlw.goodscm.model.GoodsPic;
import com.xlw.goodscm.service.GoodsPicService;
import com.xlw.goodscm.utils.FileUploadUtil;
import com.xlw.goodscm.utils.ReduceImage;

/**
 * @author longlianghua
 */
@Service
public class GoodsPicServiceImpl implements GoodsPicService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GoodsPicServiceImpl.class);

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
		return goodsPic;
	}

	@Override
	public void updateGoodsId(List<GoodsPic> goodsPics) {
		for (GoodsPic goodsPic : goodsPics) {
			goodsPicMapper.updateGoodsId(goodsPic);
		}
	}

	@Override
	public void createThumbnail(GoodsPic goodsPic) throws Exception {
		if (goodsPic != null && goodsPic.getIsThumbnail()) {
			Long id = goodsPic.getId();
			GoodsPic dbGoodsPic = goodsPicMapper.selectByPrimaryKey(id);
			String relativePath = dbGoodsPic.getRelativePath();
			File picFile = new File(relativePath);
			if (picFile.exists()) {
				String thumbnailPath = relativePath + "_thumbnail";
				File f = new File(thumbnailPath);
				if (f.exists()) {
					LOGGER.warn("thumbnail file " + thumbnailPath + " has exists");
					return;
				}
				ReduceImage.reduceImg(relativePath, thumbnailPath, 32, 32, null);
			}
		}
	}

	@Override
	public List<GoodsPic> selectGoodsPics(Long goodsId) {
		return goodsPicMapper.selectGoodsPics(goodsId);
	}

	@Override
	public void delete(List<Long> picIds) {
		if (picIds == null || picIds.isEmpty())
			return;
		goodsPicMapper.batchDelete(picIds);
	}

	@Override
	public void deleteByGoodsId(Long goodsId) {
		if (goodsId == null || goodsId == 0)
			return;
		goodsPicMapper.deleteByGoodsId(goodsId);
	}

}
