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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.xlw.broker.service.ActiveMQService;
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

	@Autowired(required = false)
	private ActiveMQService activeMQService;

	@Autowired
	private GoodsService self;
	
	
	@Override
	public List<Goods> query(Goods goods) {
		List<Goods> all = goodsMapper.selectAll();
		return all;
	}
	
	/**
	 * 通过返回goods对象放入缓存
	 * @param goods
	 * @return
	 */
	@Override
	@CachePut(value = "goods", key = "#goods.id")
	public Goods addGoods(Goods goods) {
		goodsMapper.insert(goods);
		return goods;
	}
	
	@Override
	public CmPage<Goods, List<?>> pageQuery(CmPage<Goods, List<?>> cmPage) {
		//query total number
		int total = goodsMapper.pageQueryCount(cmPage.getC());
		//query record
		List<Goods> pageQuery = goodsMapper.pageQuery(cmPage);
		cmPage.setTotal(total);
		cmPage.setT(pageQuery);
		
		// query supplier recode for every row
		List<Long> goodsIds = new ArrayList<>();
		for (Goods goods : pageQuery) {
			goodsIds.add(goods.getId());
		}
		// query supplier record order by goods id and update date
		List<SupplierRecord> supplierRecords = supplierRecordService.batchQuery(goodsIds);
		if (supplierRecords == null || supplierRecords.isEmpty())
			return cmPage;

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

		return cmPage;
	}

	@Override
	@Cacheable(value = "goods", key = "#id")
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
	 * 
	 * @see com.xlw.goodscm.service.GoodsService#getGoodsInfoById(java.lang.Long)
	 */
	@Override
	@Cacheable(value = "goods", key = "#id")
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
		self.addGoods(goods);
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
		// 发送消息，不应在事务内调用
		activeMQService.sendGoodAddMsg(goods);
	}

	@Override
	@CacheEvict(value = "goods")
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
		// no matter goods id ,update all record
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		if (goodsPics != null) {
			for (GoodsPic goodsPic : goodsPics) {
				if (goodsPic.getIsThumbnail()) {
					goodsPicService.createThumbnail(goodsPic);
				}
				goodsPic.setGoodsId(goods.getId());
			}
			goodsPicService.updateGoodsId(goodsPics);
		}
	}

	@Override
	public void updateStatus(Goods goods) {
		goodsMapper.updateStatus(goods);
	}

	@Override
	@CacheEvict(value = "goods")
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
				throw new DuplicateKeyException("Add\\Update  Goods Exception: Duplicate entry '" + code + "' for key 'code'");
		}
	}

	@Override
	public List<Goods> queryNewGoods(CmPage<Goods, List<?>> goodsPageQuery) {
		List<Goods> pageQuery = goodsMapper.queryNewGoods(goodsPageQuery);
		return pageQuery;
	}

}
