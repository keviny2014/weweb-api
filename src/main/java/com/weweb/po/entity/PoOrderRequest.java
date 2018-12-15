package com.weweb.po.entity;

import com.weweb.common.entity.DataEntity;

import java.math.BigDecimal;

/**
 * Created by wshen on 5/12/2017.
 */
public class PoOrderRequest extends DataEntity{
    private Long orderRequestId;
    private Long productId;
    private String productTitle;
    private Long createdByDeviceId;
    private String deviceName;
    private Integer isVirtual;
    private String sku;
    private String unit;
    private String qbName;
    private Long qty;
    private BigDecimal suggestPrice;
    private BigDecimal price;
    private BigDecimal priceRmb;
    private Long priority;
    private String remarks;
    private Long picture;
    private String picturePath;
    private Long status;
    private String statusValue;
    private Long thumbnail;
    private String thumbnailPath;
    private String detail;
    private String batchCode;
    private String requestType;
    private String attribute;
    private Integer quality;
    private Integer troubleShooting;
    private BigDecimal initPrice;
    private Long initQty;
    private Long isTested;

    public Long getOrderRequestId() {
        return orderRequestId;
    }

    public void setOrderRequestId(Long orderRequestId) {
        this.orderRequestId = orderRequestId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Long getCreatedByDeviceId() {
        return createdByDeviceId;
    }

    public void setCreatedByDeviceId(Long createdByDeviceId) {
        this.createdByDeviceId = createdByDeviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
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

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public BigDecimal getSuggestPrice() {
        return suggestPrice;
    }

    public void setSuggestPrice(BigDecimal suggestPrice) {
        this.suggestPrice = suggestPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceRmb() {
        return priceRmb;
    }

    public void setPriceRmb(BigDecimal priceRmb) {
        this.priceRmb = priceRmb;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getPicture() {
        return picture;
    }

    public void setPicture(Long picture) {
        this.picture = picture;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public Long getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Long thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getTroubleShooting() {
        return troubleShooting;
    }

    public void setTroubleShooting(Integer troubleShooting) {
        this.troubleShooting = troubleShooting;
    }

    public BigDecimal getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(BigDecimal initPrice) {
        this.initPrice = initPrice;
    }

    public Long getInitQty() {
        return initQty;
    }

    public void setInitQty(Long initQty) {
        this.initQty = initQty;
    }

    public Long getIsTested() {
        return isTested;
    }

    public void setIsTested(Long isTested) {
        this.isTested = isTested;
    }
}
