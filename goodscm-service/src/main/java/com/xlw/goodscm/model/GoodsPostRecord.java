package com.xlw.goodscm.model;

import java.util.Date;

public class GoodsPostRecord {
    private Long id;

    private Long goodsId;

    private Long goodsHisId;

    private Long customerId;

    private Short postStatus;

    private Date exportTime;

    private Date postTime;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsHisId() {
        return goodsHisId;
    }

    public void setGoodsHisId(Long goodsHisId) {
        this.goodsHisId = goodsHisId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Short getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Short postStatus) {
        this.postStatus = postStatus;
    }

    public Date getExportTime() {
        return exportTime;
    }

    public void setExportTime(Date exportTime) {
        this.exportTime = exportTime;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
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
}