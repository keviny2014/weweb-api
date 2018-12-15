package com.weweb.wf.entity;


import java.math.BigDecimal;
import java.util.Date;

public class WfTaskVo {
    private Long taskinstanceid;
    private Long state;
    private Long itemsId;
    private Long actorId;
    private String actorName;

    private Long orderRequestId;
    private Long productId;
    private String productTitle;
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
    private Long isTested;
    private Integer troubleShooting;
    private String batchCode;
    private BigDecimal oldPrice;
    private Date createDate;

    public Long getTaskinstanceid() { return taskinstanceid;}
    public void setTaskinstanceid(Long taskinstanceid) { this.taskinstanceid = taskinstanceid;}


    public Long getItemsId() { return itemsId;}
    public void setItemsId(Long itemsId) { this.itemsId = itemsId;}


    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

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

    public Long getIsTested() {
        return isTested;
    }

    public void setIsTested(Long isTested) {
        this.isTested = isTested;
    }

    public Integer getTroubleShooting() {
        return troubleShooting;
    }

    public void setTroubleShooting(Integer troubleShooting) {
        this.troubleShooting = troubleShooting;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
