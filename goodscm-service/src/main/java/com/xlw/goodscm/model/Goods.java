package com.xlw.goodscm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Goods {
	private Long id;

	private String code;

	private String shortName;

	private Long categoryId;

	private String categoryCode;

	private Long thumbnailPicId;

	@Deprecated
	private String vendorGoodsCode;

	private String nameZh;

	private String nameEn;

	private BigDecimal netWeight;

	private BigDecimal weightAfterPacking;

	private BigDecimal length;

	private BigDecimal width;

	private BigDecimal height;

	private BigDecimal packingLength;

	private BigDecimal packingWidth;

	private BigDecimal packingHeight;

	private BigDecimal purchasePrice;

	private BigDecimal retailPrice;

	private BigDecimal tradePrice;

	private BigDecimal stock;

	private Short stockUnit;

	private Short status;

	private Date createTime;

	private Date updateTime;

	private String memo;

	private String zhInfo;

	private String enInfo;

	private String extInfo;

	private GoodsCategory category;

	private List<Supplier> suppliers;

	private List<SupplierRecord> supplierRecords;

	private List<GoodsPic> goodsPics;
	
	private int finish;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Long getThumbnailPicId() {
		return thumbnailPicId;
	}

	public void setThumbnailPicId(Long thumbnailPicId) {
		this.thumbnailPicId = thumbnailPicId;
	}

	public String getVendorGoodsCode() {
		return vendorGoodsCode;
	}

	public void setVendorGoodsCode(String vendorGoodsCode) {
		this.vendorGoodsCode = vendorGoodsCode == null ? null : vendorGoodsCode.trim();
	}

	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh == null ? null : nameZh.trim();
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn == null ? null : nameEn.trim();
	}

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public BigDecimal getWeightAfterPacking() {
		return weightAfterPacking;
	}

	public void setWeightAfterPacking(BigDecimal weightAfterPacking) {
		this.weightAfterPacking = weightAfterPacking;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getPackingLength() {
		return packingLength;
	}

	public void setPackingLength(BigDecimal packingLength) {
		this.packingLength = packingLength;
	}

	public BigDecimal getPackingWidth() {
		return packingWidth;
	}

	public void setPackingWidth(BigDecimal packingWidth) {
		this.packingWidth = packingWidth;
	}

	public BigDecimal getPackingHeight() {
		return packingHeight;
	}

	public void setPackingHeight(BigDecimal packingHeight) {
		this.packingHeight = packingHeight;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public Short getStockUnit() {
		return stockUnit;
	}

	public void setStockUnit(Short stockUnit) {
		this.stockUnit = stockUnit;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public String getZhInfo() {
		return zhInfo;
	}

	public void setZhInfo(String zhInfo) {
		this.zhInfo = zhInfo;
	}

	public String getEnInfo() {
		return enInfo;
	}

	public void setEnInfo(String enInfo) {
		this.enInfo = enInfo;
	}

	public String getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}

	public GoodsCategory getCategory() {
		return category;
	}

	public void setCategory(GoodsCategory category) {
		this.category = category;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<SupplierRecord> getSupplierRecords() {
		return supplierRecords;
	}

	public void setSupplierRecords(List<SupplierRecord> supplierRecords) {
		this.supplierRecords = supplierRecords;
	}

	public List<GoodsPic> getGoodsPics() {
		return goodsPics;
	}

	public void setGoodsPics(List<GoodsPic> goodsPics) {
		this.goodsPics = goodsPics;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

}