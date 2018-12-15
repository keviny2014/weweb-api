package com.weweb.api;

import javax.servlet.http.HttpServletRequest;

import com.weweb.wf.entity.WfForum;
import com.weweb.wf.entity.WfTaskVo;
import com.weweb.wf.entity.WfWorkitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.weweb.common.annotation.ValidationToken;
import com.weweb.common.entity.Result;
import com.weweb.po.entity.OrderRequestPriceVo;
import com.weweb.po.entity.OrderRequestQtyVo;
import com.weweb.po.entity.OrderRequestRemarksVo;
import com.weweb.po.entity.OrderRequestTitleVo;
import com.weweb.po.service.PoOrderRequestService;
import com.weweb.sys.entity.LoginVo;
import com.weweb.sys.service.SysUserService;
import com.weweb.wf.entity.ItemVo;
import com.weweb.wf.service.WfForumService;
import com.weweb.wf.service.WfTaskService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Created by wshen on 5/3/2017.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/po/api")
public class PoApiController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private PoOrderRequestService orderRequestService;
	@Autowired
	private WfForumService wfForumService;
	@Autowired
	private WfTaskService wfTaskService;
	@ApiImplicitParam(paramType = "header", name = "app_token", dataType = "String",defaultValue = "login app token is optional")
	@ApiOperation(value = "login in po", notes = "Logon by login name and password")
	@PostMapping(value = "/login")
	@ResponseBody
	public Result login(@RequestBody @Validated LoginVo login, HttpServletRequest request) throws Exception {
		return sysUserService.login(request,login);
	}
	@ApiOperation(value = "logout in po", notes = "Logout in system")
	@PostMapping(value = "/logout")
	@ValidationToken
	@ResponseBody
	public Result logout(HttpServletRequest request)  {
		return sysUserService.logout(request);
	}
	@ApiOperation(value = "getMyActiveWorkTasks", notes = "Get my active work task by current user",response = WfTaskVo.class)
	@GetMapping(value = "/getMyActiveWorkTasks")
	@ValidationToken
	@ResponseBody
	public Result getActiveWorkTasksByUPIUser(@RequestParam int start,@RequestParam int pageSize,HttpServletRequest request){
		return wfTaskService.getTaskList(request,"5",start,pageSize);
	}
	@ApiOperation(value = "getAllActiveWorkTasks", notes = "Get all active work tasks",response = WfTaskVo.class)
	@GetMapping(value = "/getAllActiveWorkTasks")
	@ValidationToken
	@ResponseBody
	public Result getAllActiveWorkTasks(@RequestParam int start,@RequestParam int pageSize){
		return wfTaskService.getTaskList(null,"5",start,pageSize);
	}
	@ApiOperation(value = "getMyFinishedWorkTasks", notes = "Get my finished work tasks",response = WfTaskVo.class)
	@GetMapping(value = "/getMyFinishedWorkTasks")
	@ValidationToken
	@ResponseBody
	public Result getMyFinishedWorkTasks(@RequestParam int start,@RequestParam int pageSize, HttpServletRequest request){
		return wfTaskService.getTaskList(request,"6",start,pageSize);
	}
	@ApiOperation(value = "getAllFinishedWorkTasks", notes = "Get all finished work tasks",response = WfTaskVo.class)
	@GetMapping(value = "/getAllFinishedWorkTasks")
	@ValidationToken
	@ResponseBody
	public Result getAllFinishedWorkTasks(@RequestParam int start,@RequestParam int pageSize){
		return wfTaskService.getTaskList(null,"6",start,pageSize);
	}
	@ApiOperation(value = "getItemHistory", notes = "Get all finished work tasks",response = WfWorkitem.class)
	@GetMapping(value = "/getItemHistory/{orderRequestId}")
	@ValidationToken
	@ResponseBody
	public Result getItemHistory(@PathVariable Long orderRequestId,HttpServletRequest request){
		return wfTaskService.getOdWorkflowHistory(request,orderRequestId);
	}
	@ApiOperation(value = "getItemForum", notes = "Get item Forum",response = WfForum.class)
	@GetMapping(value = "/getItemForum/{orderRequestId}")
	@ValidationToken
	@ResponseBody
	public Result getItemForum(@PathVariable Long orderRequestId)  {
		return wfForumService.getForumDetailByOrderRequestID(orderRequestId);
	}
	@ApiOperation(value = "confirmPurchase", notes = "Confirm purchase")
	@PostMapping(value = "/confirmPurchase/{orderRequestId}")
	@ValidationToken
	@ResponseBody
	public Result confirmPurchase(@PathVariable Long orderRequestId,HttpServletRequest request) {
		return orderRequestService.confirmPurchase(request,orderRequestId);
	}
	@ApiOperation(value = "confirmTest", notes = "Confirm test product")
	@PostMapping(value = "/confirmTest/{orderRequestId}")
	@ValidationToken
	@ResponseBody
	public Result confirmTest(@PathVariable Long orderRequestId, HttpServletRequest request) {
		return orderRequestService.confirmTest(request,orderRequestId);

	}
	@ApiOperation(value = "updateProductTitle", notes = "Update product title")
	@PostMapping(value = "/updateProductTitle")
	@ValidationToken
	@ResponseBody
	public Result updateProductTitle(@RequestBody @Validated OrderRequestTitleVo titleVo, HttpServletRequest request) {
		return orderRequestService.updateTitle(request,titleVo);
	}
	@ApiOperation(value = "updateQty", notes = "Update qty")
	@PostMapping(value = "/updateQty")
	@ValidationToken
	@ResponseBody
	public Result updateQty(@RequestBody @Validated OrderRequestQtyVo qtyVo, HttpServletRequest request) {
		return orderRequestService.updateQty(request,qtyVo);

	}
	@ApiOperation(value = "updatePrice", notes = "Update price")
	@PostMapping(value = "/updatePrice")
	@ValidationToken
	@ResponseBody
	public Result updatePrice(@RequestBody @Validated OrderRequestPriceVo priceVo, HttpServletRequest request) {
		return orderRequestService.updatePrice(request,priceVo);

	}
	@ApiOperation(value = "updateRemarks", notes = "Update remarks")
	@PostMapping(value = "/updateRemarks")
	@ValidationToken
	@ResponseBody
	public Result updateRemarks(@RequestBody @Validated OrderRequestRemarksVo remarksVo, HttpServletRequest request) {
		return orderRequestService.updateRemarks(request,remarksVo);
	}
	@ApiOperation(value = "sendItemImage", notes = "Send Item Image",response = WfForum.class)
	@PostMapping(value = "/sendItemImage")
	@ValidationToken
	@ResponseBody
	public Result sendItemImage( HttpServletRequest request) throws Exception {
		String recordId=request.getParameter("recordId");
		return wfForumService.sendItemImage(request,Long.valueOf(recordId));
	}
	@ApiOperation(value = "sendItem", notes = "Send Item",response = WfForum.class)
	@PostMapping(value = "/sendItem")
	@ValidationToken
	@ResponseBody
	public Result sendItem(@RequestBody @Validated ItemVo itemVo,HttpServletRequest request) {
		return wfForumService.sendItem(request,itemVo);
	}
}
