package com.weweb.po.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.weweb.po.entity.PoOrderRequest;

/**
 * Created by wshen on 5/12/2017.
 */
@Mapper
public interface PoOrderRequestDao {
	int update(PoOrderRequest orderRequest);
	PoOrderRequest getOrderRequest(Long orderRequestId);
}
