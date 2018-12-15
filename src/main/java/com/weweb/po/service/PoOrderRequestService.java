package com.weweb.po.service;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weweb.common.entity.CodeMessage;
import com.weweb.common.entity.Result;
import com.weweb.common.util.SSTUtils;
import com.weweb.po.entity.*;
import com.weweb.po.mapper.PoOrderRequestDao;
import com.weweb.sys.entity.SysUserToken;
import com.weweb.wf.service.WfTaskService;

/**
 * Created by wshen on 5/12/2017.
 */
@Service
public class PoOrderRequestService {
	@Autowired
	private PoOrderRequestDao orderRequestDao;
	@Autowired
	private WfTaskService wfTaskService;

	public int update(PoOrderRequest orderRequest) {
		return orderRequestDao.update(orderRequest);
	}
	public Result confirmPurchase(HttpServletRequest request, Long orderRequestId) {
		SysUserToken sysUserToken = SSTUtils.getSysUserToken(request);
		PoOrderRequest orderRequest = new PoOrderRequest();
		orderRequest.setOrderRequestId(orderRequestId);
		orderRequest.setStatus(5L);
		orderRequest.setUpdateBy(String.valueOf(sysUserToken.getUserId()));
		int count = update(orderRequest);
		if (count > 0) {
			return new Result(CodeMessage.SUCCESS, "Update remarks successful");
		} else {
			return new Result(CodeMessage.OPERATE_FAIL);
		}
	}
	public Result confirmTest(HttpServletRequest request, Long orderRequestId) {
		SysUserToken sysUserToken = SSTUtils.getSysUserToken(request);
		PoOrderRequest orderRequest = new PoOrderRequest();
		orderRequest.setOrderRequestId(orderRequestId);
		orderRequest.setIsTested(1L);
		orderRequest.setUpdateBy(String.valueOf(sysUserToken.getUserId()));
		int count = update(orderRequest);
		if (count > 0) {
			return new Result(CodeMessage.SUCCESS, "Update remarks successful");
		} else {
			return new Result(CodeMessage.OPERATE_FAIL);
		}
	}

	@Transactional
	public Result updateTitle(HttpServletRequest request, OrderRequestTitleVo titleVo) {
		SysUserToken sysUserToken = SSTUtils.getSysUserToken(request);
		Long orderRequestId=titleVo.getOrderRequestId();
		String title=titleVo.getTitle();
		Long currentUserId=sysUserToken.getUserId();
        PoOrderRequest oldPoOrderRequest = orderRequestDao.getOrderRequest(orderRequestId);
        PoOrderRequest orderRequest = new PoOrderRequest();
		orderRequest.setOrderRequestId(orderRequestId);
		orderRequest.setProductTitle(title);
		orderRequest.setUpdateBy(String.valueOf(currentUserId));
		String oldTitle=oldPoOrderRequest.getProductTitle();
		int count = update(orderRequest);
		if (count > 0) {
            if (!title.equals(oldTitle)) {
                String message = "Change Product title from " + oldTitle + " to " + title;
                wfTaskService.createChangeQtyWorkflow(String.valueOf(orderRequestId),
						String.valueOf(oldPoOrderRequest.getStatus()), message, currentUserId);
            }
			return new Result(CodeMessage.SUCCESS, "Update remarks successful",orderRequest.getProductTitle());
		} else {
			return new Result(CodeMessage.OPERATE_FAIL);
		}
	}

	@Transactional
	public Result updateQty(HttpServletRequest request, OrderRequestQtyVo qtyVo) {
		SysUserToken sysUserToken = SSTUtils.getSysUserToken(request);
		PoOrderRequest orderRequest = new PoOrderRequest();
		Long orderRequestId = qtyVo.getOrderRequestId();
		Long qty = qtyVo.getQty();
		orderRequest.setOrderRequestId(orderRequestId);
		orderRequest.setQty(qty);
		Long currentUserId = sysUserToken.getUserId();
		orderRequest.setUpdateBy(String.valueOf(sysUserToken.getUserId()));
		PoOrderRequest oldPoOrderRequest = orderRequestDao.getOrderRequest(orderRequestId);
		Long oldQty=oldPoOrderRequest.getQty();
		int count = update(orderRequest);
		if (count > 0) {
			if (!qty.equals(oldQty)) {
				String message = "Change Product qty from " + oldQty + " to " + qty;
				wfTaskService.createChangeQtyWorkflow(String.valueOf(orderRequestId),
						String.valueOf(oldPoOrderRequest.getStatus()), message, currentUserId);
			}
			return new Result(CodeMessage.SUCCESS, "Update qty successful",orderRequest.getQty());
		} else {
			return new Result(CodeMessage.OPERATE_FAIL);
		}
	}

	@Transactional
	public Result updatePrice(HttpServletRequest request, OrderRequestPriceVo priceVo) {
		SysUserToken sysUserToken = SSTUtils.getSysUserToken(request);
		Long orderRequestId=priceVo.getOrderRequestId();
        BigDecimal price=priceVo.getPrice();
        Long currentUserId=sysUserToken.getUserId();
		PoOrderRequest orderRequest = new PoOrderRequest();
		orderRequest.setOrderRequestId(priceVo.getOrderRequestId());
		orderRequest.setPrice(price);
		orderRequest.setUpdateBy(String.valueOf(currentUserId));
        PoOrderRequest oldPoOrderRequest = orderRequestDao.getOrderRequest(orderRequestId);
        BigDecimal oldPrice=oldPoOrderRequest.getPrice();
        int count = update(orderRequest);
		if (count > 0) {
            if (!price.equals(oldPrice)) {
                String message = "Change Product price from " + oldPrice + " to " + price;
                wfTaskService.createChangePriceWorkflow(String.valueOf(orderRequestId),
						String.valueOf(oldPoOrderRequest.getStatus()), message, currentUserId);
            }
			return new Result(CodeMessage.SUCCESS, "Update price successful",orderRequest.getPrice());
		} else {
			return new Result(CodeMessage.OPERATE_FAIL);
		}
	}

	@Transactional
	public Result updateRemarks(HttpServletRequest request, OrderRequestRemarksVo remarksVo) {
		SysUserToken sysUserToken = SSTUtils.getSysUserToken(request);
		PoOrderRequest orderRequest = new PoOrderRequest();
		orderRequest.setOrderRequestId(remarksVo.getOrderRequestId());
		orderRequest.setRemarks(remarksVo.getRemarks());
		orderRequest.setUpdateBy(String.valueOf(sysUserToken.getUserId()));
		int count = update(orderRequest);
		if (count > 0) {
			return new Result(CodeMessage.SUCCESS, "Update remarks successful",orderRequest.getRemarks());
		} else {
			return new Result(CodeMessage.OPERATE_FAIL);
		}
	}

}
