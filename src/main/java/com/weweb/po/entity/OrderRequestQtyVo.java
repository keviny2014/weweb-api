package com.weweb.po.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by wshen on 5/12/2017.
 */
public class OrderRequestQtyVo {
    @NotNull(message = "order request id may not be empty")
    private Long orderRequestId;
    @NotNull(message = "product qty may not be empty")
    @Min(value = 1,message = "product qty must be greater than or equal to 1")
    private Long qty;

    public Long getOrderRequestId() {
        return orderRequestId;
    }

    public void setOrderRequestId(Long orderRequestId) {
        this.orderRequestId = orderRequestId;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
}
