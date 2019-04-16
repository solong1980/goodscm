package com.xlw.goodscm.service.impl;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.xlw.goodscm.dao.GoodsMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsPic;
import com.xlw.goodscm.model.SupplierRecord;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.GoodsPicService;
import com.xlw.goodscm.service.GoodsService;
import com.xlw.goodscm.service.SupplierRecordService;

/**
 * @author longlianghua
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private SupplierRecordService supplierRecordService;

	@Autowired
	private GoodsPicService goodsPicService;

	@Override
	public List<Goods> query(Goods goods) {
		List<Goods> all = goodsMapper.selectAll();
		return all;
	}

	@Override
	public List<Goods> pageQuery(CmPage<Goods, List<?>> goodsPageQuery) {
		List<Goods> pageQuery = goodsMapper.pageQuery(goodsPageQuery);
		// query supplier recode for every row
		List<Long> goodsIds = new ArrayList<>();
		for (Goods goods : pageQuery) {
			goodsIds.add(goods.getId());
		}
		// query supplier record order by goods id and update date
		List<SupplierRecord> supplierRecords = supplierRecordService.batchQuery(goodsIds);
		if (supplierRecords == null || supplierRecords.isEmpty())
			return pageQuery;

		// group by goods id
		Multimap<Long, SupplierRecord> supplierRecordMap = ArrayListMultimap.create();

		for (SupplierRecord supplierRecord : supplierRecords) {
			supplierRecordMap.put(supplierRecord.getGoodsId(), supplierRecord);
		}
		for (Goods goods : pageQuery) {
			Collection<SupplierRecord> collection = supplierRecordMap.get(goods.getId());
			if (collection.size() > 0) {
				// order lowest price to index 1(first is 0)
				ArrayList<SupplierRecord> arrayList = new ArrayList<>(collection);
				List<SupplierRecord> subList = arrayList.subList(1, arrayList.size());
				subList.sort(new Comparator<SupplierRecord>() {
					@Override
					public int compare(SupplierRecord o1, SupplierRecord o2) {
						if (o1 == null || o1.getUnitPrice() == null)
							return 1;
						if (o2 == null || o2.getUnitPrice() == null)
							return -1;
						if (o1.getUnitPrice().equals(o2.getUnitPrice()))
							return 0;
						return o1.getUnitPrice().compareTo(o2.getUnitPrice());
					}
				});
				goods.setSupplierRecords(new ArrayList<SupplierRecord>() {
					private static final long serialVersionUID = 1L;
					{
						add(arrayList.get(0));
						if (subList.size() > 0)
							addAll(subList);
					}
				});
			}
		}

		return pageQuery;
	}

	@Override
	public Goods getById(Long id) {
		Goods goods = goodsMapper.selectByPrimaryKey(id);
		if (goods != null) {
			GoodsPic goodsPic = new GoodsPic();
			goodsPic.setGoodsId(id);

			List<SupplierRecord> supplierRecords = supplierRecordService.selectByGoodsId(id);

			if (supplierRecords.size() > 0) {
				// order lowest price to index 1(first is 0)
				List<SupplierRecord> subList = supplierRecords.subList(1, supplierRecords.size());
				subList.sort(new Comparator<SupplierRecord>() {
					@Override
					public int compare(SupplierRecord o1, SupplierRecord o2) {
						if (o1 == null || o1.getUnitPrice() == null)
							return 1;
						if (o2 == null || o2.getUnitPrice() == null)
							return 1;
						if (o1.getUnitPrice().equals(o2.getUnitPrice()))
							return 0;
						return o1.getUnitPrice().compareTo(o2.getUnitPrice());
					}
				});
				goods.setSupplierRecords(new ArrayList<SupplierRecord>() {
					private static final long serialVersionUID = 1L;
					{
						add(supplierRecords.get(0));
						if (subList.size() > 0)
							addAll(subList);
					}
				});
			}

			goods.setSupplierRecords(supplierRecords);

			List<GoodsPic> goodsPics = goodsPicService.selectGoodsPics(id);
			goods.setGoodsPics(goodsPics);
		}
		return goods;
	}
	
	/*
	 * Query goods info include pictures
	 * @see com.xlw.goodscm.service.GoodsService#getGoodsInfoById(java.lang.Long)
	 */
	@Override
	public Goods getGoodsInfoById(Long id) {
		Goods goods = goodsMapper.selectByPrimaryKey(id);
		if (goods != null) {
			GoodsPic goodsPic = new GoodsPic();
			goodsPic.setGoodsId(id);
			List<GoodsPic> goodsPics = goodsPicService.selectGoodsPics(id);
			goods.setGoodsPics(goodsPics);
		}
		return goods;
	}
	
	@Override
	public Long add(Goods goods) {
		goods.setId(null);
		checkGoodsCodeDuplicate(goods);

		goods.setCreateTime(new Date());
		goodsMapper.insert(goods);
		Long goodsId = goods.getId();
		List<SupplierRecord> supplierRecords = goods.getSupplierRecords();
		if (supplierRecords != null && !supplierRecords.isEmpty()) {
			for (SupplierRecord supplierRecord : supplierRecords) {
				// save goods supplier relation
				supplierRecord.setGoodsId(goodsId);
				supplierRecord.setCreateTime(new Date());
				supplierRecordService.add(supplierRecord);
			}
		}
		return goodsId;
	}

	@Override
	@Transactional
	public void addUpdatePicsGoodsId(Goods goods) throws Exception {
		Long id = add(goods);
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		if (goodsPics != null && !goodsPics.isEmpty()) {
			for (GoodsPic goodsPic : goodsPics) {
				goodsPic.setGoodsId(id);
			}
			goodsPicService.updateGoodsId(goodsPics);
			for (GoodsPic goodsPic : goodsPics) {
				if (goodsPic.getIsThumbnail()) {
					goodsPicService.createThumbnail(goodsPic);
					break;
				}
			}
		}
	}

	@Override
	@Transactional
	public void update(Goods goods) throws Exception {
		if (goods.getId() == null) {
			throw new InvalidParameterException("goods id is null");
		}
		
		checkGoodsCodeDuplicate(goods);
		
		goodsMapper.updateByPrimaryKey(goods);

		List<SupplierRecord> supplierRecords = goods.getSupplierRecords();
		if (supplierRecords != null) {
			for (SupplierRecord supplierRecord : supplierRecords) {
				Long id = supplierRecord.getId();
				if (id == null || id == 0) {
					// do add
					supplierRecord.setGoodsId(goods.getId());
					supplierRecord.setCreateTime(new Date());
					supplierRecordService.add(supplierRecord);
				} else {
					supplierRecordService.update(supplierRecord);
				}
			}
		}
		Long goodsId = goods.getId();
		// no matter goods id ,update all record
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		//delete pictures by goods id
		//goodsPicService.deleteByGoodsId(goodsId);
		//delete not exist in goodsPics
		if (goodsPics == null || goodsPics.isEmpty()) {
			return;
		}
		List<Long> picIds = new ArrayList<>();
		for (GoodsPic goodsPic : goodsPics) {
			picIds.add(goodsPic.getId());
			if (goodsPic.getIsThumbnail()) {
				goodsPicService.createThumbnail(goodsPic);
			}
			goodsPic.setGoodsId(goodsId);
		}
		goodsPicService.deleteNoInPicIds(goodsId,picIds);
		goodsPicService.updateGoodsId(goodsPics);

	}

	@Override
	public void updateStatus(Goods goods) {
		goodsMapper.updateStatus(goods);
	}

	@Override
	public void deleteById(Long id) {
		goodsMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Deprecated
	public void addSavePics(Goods goods) throws IOException {
		Long id = add(goods);
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		if (goodsPics != null && !goodsPics.isEmpty()) {
			for (GoodsPic goodsPic : goodsPics) {
				goodsPic.setGoodsId(id);
			}
			goodsPicService.add(goodsPics);
		}
	}

	@Override
	public void fastUpdate(Goods goods) {
		if (goods.getId() == null) {
			throw new InvalidParameterException("goods id is null");
		}
		checkGoodsCodeDuplicate(goods);
		goodsMapper.fastUpdateByPrimaryKey(goods);
	}

	/**
	 * 如果code为空则通过 ，否则判断是否重复
	 * 
	 * @param goods
	 */
	private synchronized void checkGoodsCodeDuplicate(Goods goods) {
		String code = goods.getCode();
		if (StringUtils.isNotEmpty(code)) {
			int count = goodsMapper.selectCount(goods);
			if (count > 0)
				throw new DuplicateKeyException("Add\\Update  Goods Exception: Duplicate entry '"+code+"' for key 'code'");
		}
	}

	@Override
	public List<Goods> queryNewGoods(CmPage<Goods, List<?>> goodsPageQuery) {
		List<Goods> pageQuery = goodsMapper.queryNewGoods(goodsPageQuery);
		return pageQuery;
	}

}
