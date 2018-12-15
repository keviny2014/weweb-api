package com.weweb.po.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by wshen on 5/12/2017.
 */
public class OrderRequestRemarksVo {
    @NotNull(message = "order request id may not be empty")
    private Long orderRequestId;
    @NotBlank(message = "remarks may not be empty")
    private String remarks;

    public Long getOrderRequestId() {
        return orderRequestId;
    }

    public void setOrderRequestId(Long orderRequestId) {
        this.orderRequestId = orderRequestId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
