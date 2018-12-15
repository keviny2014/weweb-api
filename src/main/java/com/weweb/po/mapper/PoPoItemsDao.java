package com.weweb.po.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.weweb.po.entity.PoPoItems;

@Mapper
public interface PoPoItemsDao {

	int update(PoPoItems poPoItems);

	Long getOrderRequestId(Long poItemsId);

}
