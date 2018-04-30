package com.xlw.goodscm.model;

import java.math.BigDecimal;
import java.util.Date;

public class ChannelSaleRecode {
    private Long id;

    private Long channel;

    private Integer goodsId;

    private Short releaseState;

    private BigDecimal releasePrice;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Short getReleaseState() {
        return releaseState;
    }

    public void setReleaseState(Short releaseState) {
        this.releaseState = releaseState;
    }

    public BigDecimal getReleasePrice() {
        return releasePrice;
    }

    public void setReleasePrice(BigDecimal releasePrice) {
        this.releasePrice = releasePrice;
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