package com.weweb.po.entity;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * Created by wshen on 5/12/2017.
 */
public class OrderRequestPriceVo {
    @NotNull(message = "order request id may not be empty")
    private Long orderRequestId;
    @NotNull(message = "price may not be empty")
    @DecimalMin(value="0.01",message ="product price must be greater than or equal to 0.01" )
    private BigDecimal price;

    public Long getOrderRequestId() {
        return orderRequestId;
    }

    public void setOrderRequestId(Long orderRequestId) {
        this.orderRequestId = orderRequestId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
