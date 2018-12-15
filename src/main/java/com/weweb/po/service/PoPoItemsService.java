package com.weweb.po.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weweb.po.entity.PoPoItems;
import com.weweb.po.mapper.PoPoItemsDao;

/**
 * Created by wshen on 5/12/2017.
 */
@Service
public class PoPoItemsService {
	@Autowired
	private PoPoItemsDao poItemsDao;

	public int update(PoPoItems poItems) {
		return poItemsDao.update(poItems);
	}

	public Long getOrderRequestId(Long poItemsId) {
		return poItemsDao.getOrderRequestId(poItemsId);
	}

}
