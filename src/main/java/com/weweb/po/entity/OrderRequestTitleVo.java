package com.weweb.po.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by wshen on 5/12/2017.
 */
public class OrderRequestTitleVo {
    @NotNull(message = "order request id may not be empty")
    private Long orderRequestId;
    @NotBlank(message = "product title may not be empty")
    private String title;
    public Long getOrderRequestId() {
        return orderRequestId;
    }

    public void setOrderRequestId(Long orderRequestId) {
        this.orderRequestId = orderRequestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
