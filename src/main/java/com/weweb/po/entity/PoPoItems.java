package com.weweb.po.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.weweb.common.entity.DataEntity;

/**
 * Created by wshen on 5/12/2017.
 */

public class PoPoItems extends DataEntity {
    private Long poItemsId;
    private Long poPackageId;
    private Long deviceId;
    private Long categoryId;
    private Long productId;
    private Integer isTested;
    private Integer isVirtual;
    private String productTitle;
    private BigDecimal suggestPrice;
    private BigDecimal priceRmb;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String sku;
    private String unit;
    private String qbName;
    private Long priority;
    private Long qty;
    private Long actualQty;
    private Long productStatus;
    private String productStatusValue;
    private String remarks;
    private String priceDescription;
    private Date priceDate;
    private String detailComment;
    private Long picture;
    private Long orderRequestId;

    public Long getPoItemsId() {
        return poItemsId;
    }

    public void setPoItemsId(Long poItemsId) {
        this.poItemsId = poItemsId;
    }

    public Long getPoPackageId() {
        return poPackageId;
    }

    public void setPoPackageId(Long poPackageId) {
        this.poPackageId = poPackageId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getIsTested() {
        return isTested;
    }

    public void setIsTested(Integer isTested) {
        this.isTested = isTested;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public BigDecimal getSuggestPrice() {
        return suggestPrice;
    }

    public void setSuggestPrice(BigDecimal suggestPrice) {
        this.suggestPrice = suggestPrice;
    }

    public BigDecimal getPriceRmb() {
        return priceRmb;
    }

    public void setPriceRmb(BigDecimal priceRmb) {
        this.priceRmb = priceRmb;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQbName() {
        return qbName;
    }

    public void setQbName(String qbName) {
        this.qbName = qbName;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getActualQty() {
        return actualQty;
    }

    public void setActualQty(Long actualQty) {
        this.actualQty = actualQty;
    }

    public Long getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Long productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusValue() {
        return productStatusValue;
    }

    public void setProductStatusValue(String productStatusValue) {
        this.productStatusValue = productStatusValue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPriceDescription() {
        return priceDescription;
    }

    public void setPriceDescription(String priceDescription) {
        this.priceDescription = priceDescription;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public String getDetailComment() {
        return detailComment;
    }

    public void setDetailComment(String detailComment) {
        this.detailComment = detailComment;
    }

    public Long getPicture() {
        return picture;
    }

    public void setPicture(Long picture) {
        this.picture = picture;
    }

    public Long getOrderRequestId() {
        return orderRequestId;
    }

    public void setOrderRequestId(Long orderRequestId) {
        this.orderRequestId = orderRequestId;
    }
}