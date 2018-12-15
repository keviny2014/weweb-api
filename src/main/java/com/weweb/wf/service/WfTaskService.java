package com.weweb.wf.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.weweb.common.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weweb.common.entity.CodeMessage;
import com.weweb.common.entity.Result;
import com.weweb.common.util.SSTUtils;
import com.weweb.po.entity.PoOrderRequest;
import com.weweb.po.mapper.PoOrderRequestDao;
import com.weweb.sys.entity.SysUserToken;
import com.weweb.sys.mapper.SysUserDao;
import com.weweb.wf.entity.*;
import com.weweb.wf.mapper.*;

/**
 * Created by zwan on 5/12/2017.
 */
@Service
public class WfTaskService {
	@Autowired
	private WfTaskinstanceDao wfTaskinstanceDao;
	@Autowired
	private WfWorkflowinstanceDao wfWorkflowinstanceDao;
	@Autowired
	private WfWorkitemDao wfWorkitemDao;
	@Autowired
	private WfWorkflowDao wfWorkflowDao;
	@Autowired
	private WfTaskTypeDao wfTaskTypeDao;
	@Autowired
	private PoOrderRequestDao poOrderRequestDao;

	@Autowired
	private PoStatusDao poStatusDao;
	@Autowired
	private SysUserDao sysUserDao;

	// workflow
	// create upi workflow for order request & po
	/*@Transactional
	public WfWorkflowinstance createUPIPOWorkflow(String recordId, String status) {
		WfTaskType wfTaskType = wfTaskTypeDao.getByName("OrderRequest");
		WfWorkflow wfWorkflow = wfWorkflowDao.getByName("UPITask");
		String version = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		WfWorkflowinstance wfWorkflowinstance = getWorkflowInstanceByVersion(version,
				String.valueOf(wfWorkflow.getWorkflowid())); // search exist
																// workflow
																// instance
		String strategy = "Role:UPIS";
		String workflowName = getProductTitle(recordId) + "-OrderRequest Task";
		wfWorkflowinstance = createUPIWorkflow(wfWorkflowinstance, wfWorkflow, wfTaskType, version, recordId, status,
				workflowName, strategy);
		return wfWorkflowinstance; //
	}*/

	// create change price workflow
	@Transactional
	public WfWorkflowinstance createChangePriceWorkflow(String recordId, String status, String remarks, Long actorId) {
		WfTaskType wfTaskType = wfTaskTypeDao.getByName("ItemPriceChange");
		WfWorkflow wfWorkflow = wfWorkflowDao.getByName("ItemPriceChange");
		String version = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		WfWorkflowinstance wfWorkflowinstance = getWorkflowInstanceByVersion(version,
				String.valueOf(wfWorkflow.getWorkflowid())); // search exist
																// workflow
																// instance
		String strategy = "ItemPriceChange";
		String workflowName = getProductTitle(recordId) + "-Price Change";
		WfTaskinstance wfTaskinstance = createWorkflow(wfWorkflowinstance, wfWorkflow, wfTaskType, version, recordId,
				 workflowName, strategy);

		WfWorkitem wfWorkitem = new WfWorkitem();
		wfWorkitem.setTaskinstanceid(wfTaskinstance.getTaskinstanceid());
		wfWorkitem.setActorId(actorId);
		if (status != null && status.length() > 0)
			wfWorkitem.setState(Long.valueOf(status));
		else
			wfWorkitem.setState(0L);
		wfWorkitem.setComments(remarks);
		wfWorkitemDao.insert(wfWorkitem);
		return wfWorkflowinstance; //
	}

	// create change quatity workflow
	@Transactional
	public WfWorkflowinstance createChangeQtyWorkflow(String recordId, String status, String remarks, Long actorId) {
		WfTaskType wfTaskType = wfTaskTypeDao.getByName("ItemQtyChange");
		WfWorkflow wfWorkflow = wfWorkflowDao.getByName("ItemQtyChange");
		String version = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		WfWorkflowinstance wfWorkflowinstance = getWorkflowInstanceByVersion(version,
				String.valueOf(wfWorkflow.getWorkflowid())); // search exist
																// workflow
																// instance
		String strategy = "ItemQtyChange";
		String workflowName = getProductTitle(recordId) + "-Quantity Change";
		WfTaskinstance wfTaskinstance = createWorkflow(wfWorkflowinstance, wfWorkflow, wfTaskType, version, recordId,
				 workflowName, strategy);

		WfWorkitem wfWorkitem = new WfWorkitem();
		wfWorkitem.setTaskinstanceid(wfTaskinstance.getTaskinstanceid());
		wfWorkitem.setActorId(actorId);
		if (status != null && status.length() > 0)
			wfWorkitem.setState(Long.valueOf(status));
		else
			wfWorkitem.setState(0L);
		wfWorkitem.setComments(remarks);
		wfWorkitemDao.insert(wfWorkitem);

		return wfWorkflowinstance; //
	}

	// create change name workflow
	@Transactional
	public WfWorkflowinstance createChangeNameWorkflow(String recordId, String status, String remarks, Long actorId) {
		WfTaskType wfTaskType = wfTaskTypeDao.getByName("ItemNameChange");
		WfWorkflow wfWorkflow = wfWorkflowDao.getByName("ItemNameChange");
		String version = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		WfWorkflowinstance wfWorkflowinstance = getWorkflowInstanceByVersion(version,
				String.valueOf(wfWorkflow.getWorkflowid())); // search exist
																// workflow
																// instance
		String strategy = "ItemNameChange";
		String workflowName = getProductTitle(recordId) + "-Name Change";
		WfTaskinstance wfTaskinstance = createWorkflow(wfWorkflowinstance, wfWorkflow, wfTaskType, version, recordId,
				 workflowName, strategy);
		WfWorkitem wfWorkitem = new WfWorkitem();
		wfWorkitem.setTaskinstanceid(wfTaskinstance.getTaskinstanceid());
		wfWorkitem.setActorId(actorId);
		if (status != null && status.length() > 0)
			wfWorkitem.setState(Long.valueOf(status));
		else
			wfWorkitem.setState(0L);
		wfWorkitem.setComments(remarks);
		wfWorkitemDao.insert(wfWorkitem);
		return wfWorkflowinstance; //
	}

	// create noworkflow for UPI
	/*@Transactional
	public WfWorkflowinstance createUPIWorkflow(WfWorkflowinstance wfWorkflowinstance, WfWorkflow wfWorkflow,
			WfTaskType wfTaskType, String version, String recordId, String status, String workflowName,
			String strategy) {
		WfTaskinstance wfTaskinstance = createWorkflow(wfWorkflowinstance, wfWorkflow, wfTaskType, version, recordId,
				status, workflowName, strategy);
		String actorId = null;
		if (Long.valueOf(status) >= 10L) { // create and allocate task and new
											// workitem
			// actorId=UserUtils.getUser().getId();
		}
		// System.out.println("current user id==="+actorId);
		allocateTask(wfTaskinstance, status, actorId); // alloacateTask
		// wfWorkflowinstance.setTaskInstances(wfTaskinstanceDao.findWorkflowTaskListById(String.valueOf(wfWorkflowinstance.getWorkflowinstanceid())));
		// wfWorkflowinstance.setWorkItems(wfTaskinstanceDao.findWorkflowWorkItemListById(String.valueOf(wfWorkflowinstance.getWorkflowinstanceid())));
		return wfWorkflowinstance;
	}*/

	// create a work flow
	@Transactional
	public WfTaskinstance createWorkflow(WfWorkflowinstance wfWorkflowinstance, WfWorkflow wfWorkflow,
			WfTaskType wfTaskType, String version, String recordId, String workflowName,
			String strategy) {
		if (wfWorkflowinstance == null) {
			wfWorkflowinstance = new WfWorkflowinstance();
			wfWorkflowinstance.setVersion(version);
			wfWorkflowinstance.setName("OrderRequest" + version+"");
			wfWorkflowinstance.setWorkflowid(wfWorkflow.getWorkflowid());
			wfWorkflowinstanceDao.insert(wfWorkflowinstance);
		}
		// create a task instance
		WfTaskinstance wfTaskinstance = getTaskInstanceByWorkflow(
				String.valueOf(wfWorkflowinstance.getWorkflowinstanceid()), String.valueOf(wfTaskType.getTasktypeid()),
				recordId);

		if (wfTaskinstance == null) {
			wfTaskinstance = new WfTaskinstance();
			wfTaskinstance.setItemsId(Long.valueOf(recordId));
			wfTaskinstance.setName(workflowName);
			wfTaskinstance.setDisplayname(workflowName + "-" + version+"");
			wfTaskinstance.setAssignmentStrategy(strategy);
			wfTaskinstance.setTasktypeid(wfTaskType.getTasktypeid());
			wfTaskinstance.setWorkflowinstanceId(wfWorkflowinstance.getWorkflowinstanceid());
			wfTaskinstance.setWorkflowinstanceid(wfWorkflowinstance.getWorkflowinstanceid());
			wfTaskinstance.setWorkflowId(wfWorkflow.getWorkflowid());
			wfTaskinstance.setVersion(wfWorkflow.getWorkflowid());
			wfTaskinstance.setTaskType(wfTaskType.getTasktypeid());
			wfTaskinstanceDao.insert(wfTaskinstance);
		}
		return wfTaskinstance;
	}

	// auto allocate Task
	/*@Transactional
	public void allocateTask(WfTaskinstance wfTaskinstance, String status, String actorId) {
		// select actor
		PoUpisetting poUPI = new PoUpisetting();
		List<PoUpisetting> poUPIs = poUpisettingDao.findList(poUPI);
		// Long actorId=-1L;
		// logic should change
		if (actorId == null) {
			for (int i = 0; i < poUPIs.size(); i++) {
				actorId = String.valueOf(poUPIs.get(i).getUserid());
			}
		}
		//
		//
		WfWorkitem wfWorkitem = getWorkItemByTask(String.valueOf(wfTaskinstance.getTaskinstanceid()), actorId);
		// System.out.println("======++"+wfWorkitem);

		if (wfWorkitem == null || ((wfWorkitem.getState() != null && wfWorkitem.getState() != Long.valueOf(status)))) {
			wfWorkitem = new WfWorkitem();
			wfWorkitem.setTaskinstanceid(wfTaskinstance.getTaskinstanceid());
			wfWorkitem.setActorId(Long.valueOf(actorId));
			wfWorkitem.setState(Long.valueOf(status));
			wfWorkitemDao.insert(wfWorkitem);
		}
	}

	// manu allocate task
	@Transactional
	public void allocateTask(String workItemId, String oldActorId, String newActorId) {
		WfWorkitem wfWorkitem = wfWorkitemDao.get(workItemId);
		wfWorkitem.setActorId(Long.valueOf(newActorId));
		String comments = wfWorkitem.getComments();
		if (comments == null)
			comments = "";
		// comments=comments+"[Change Operater from
		// ("+UserUtils.get(oldActorId).getName()+") to
		// ("+UserUtils.get(newActorId).getName()+")]";
		wfWorkitem.setComments(comments);
		wfWorkitemDao.update(wfWorkitem);
	}
    */
	@Transactional
	public Result getTaskList(HttpServletRequest request, String status, int start,int pageSize) {
		String userId=null;
		if(request!=null){
			SysUserToken sysUserToken= SSTUtils.getSysUserToken(request);
			userId=String.valueOf(sysUserToken.getUserId());
		}
		//List<WfTaskVo> wfTaskVos = new ArrayList();
		Long total=wfTaskinstanceDao.countWorkflowTaskList(userId,status);
		List<WfTaskinstance> WfTaskinstances = wfTaskinstanceDao.findWorkflowTaskList(userId, status,start,start+pageSize);
		List<WfTaskVo> wfTaskVos = new ArrayList();
		WfTaskinstances.forEach(item -> {
			PoOrderRequest poOrderRequest = poOrderRequestDao.getOrderRequest(item.getItemsId());
			//if(poOrderRequest.getStatus()<5){
				WfTaskVo wfTaskVo = new WfTaskVo();
				String actorName = "";
				String actorId = "-1";
				List<WfWorkitem> wfWorkitems = getWorkItembByTaskInstance(item);
				for (WfWorkitem wfItem : wfWorkitems) {
					if (wfItem.getState() < 10) {
						actorName = sysUserDao.getUserNameByUserId(wfItem.getActorId());
						actorId = String.valueOf(wfItem.getActorId());
					}
				}
				wfTaskVo.setActorId(Long.valueOf(actorId));
				wfTaskVo.setActorName(actorName);
				wfTaskVo.setTaskinstanceid(item.getTaskinstanceid());
				wfTaskVo.setOrderRequestId(item.getItemsId());
				wfTaskVo.setProductTitle(poOrderRequest.getProductTitle());
				wfTaskVo.setProductId(poOrderRequest.getProductId());
				wfTaskVo.setQty(poOrderRequest.getQty());
				wfTaskVo.setSuggestPrice(poOrderRequest.getSuggestPrice());
				wfTaskVo.setPrice(poOrderRequest.getPrice());
				wfTaskVo.setPriceRmb(poOrderRequest.getPriceRmb());
				wfTaskVo.setPriority(poOrderRequest.getPriority());
				wfTaskVo.setRemarks(poOrderRequest.getRemarks());
				wfTaskVo.setPicture(poOrderRequest.getPicture());
				wfTaskVo.setPicturePath(poOrderRequest.getPicturePath());
				wfTaskVo.setStatus(poOrderRequest.getStatus());
				wfTaskVo.setStatusValue(poOrderRequest.getStatusValue());
				wfTaskVo.setIsTested(poOrderRequest.getIsTested());
				wfTaskVo.setTroubleShooting(poOrderRequest.getTroubleShooting());
				wfTaskVo.setBatchCode(poOrderRequest.getBatchCode());
				wfTaskVo.setOldPrice(poOrderRequest.getInitPrice());
			    wfTaskVo.setCreateDate(poOrderRequest.getCreateDate());
				wfTaskVos.add(wfTaskVo);
			//}


		});
		PageEntity page=new PageEntity(total,start,pageSize,wfTaskVos);
		Result result = new Result(CodeMessage.SUCCESS);
		result.setData(page);
		return result;
	}

	// get task & workflow list // for taskinstance
	/*@Transactional
	public WfWorkflowinstance getUserActiveTaskList(String userId, String status) {
		WfWorkflowinstance wfWorkflowinstance = new WfWorkflowinstance();
		wfWorkflowinstance.setName("Search List");
		wfWorkflowinstance.setTaskInstances(wfTaskinstanceDao.findWorkflowTaskList(userId, status,1,10));
		if (wfWorkflowinstance.getTaskInstances() != null) {
			for (int i = 0; i < wfWorkflowinstance.getTaskInstances().size(); i++) {
				String dispName = wfWorkflowinstance.getTaskInstances().get(i).getName();
				dispName = dispName.substring(0, dispName.lastIndexOf("-"));
				wfWorkflowinstance.getTaskInstances().get(i).setName(dispName);
				List<WfWorkitem> wfWorkitems = getWorkItembByTaskInstance(wfWorkflowinstance.getTaskInstances().get(i));

				String actorName = "";
				String actorId = "-1";
				for (WfWorkitem item : wfWorkitems) {

				}
				wfWorkflowinstance.getTaskInstances().get(i).setWorkItems(wfWorkitems);
				wfWorkflowinstance.getTaskInstances().get(i).setActorId(Long.valueOf(actorId));
				wfWorkflowinstance.getTaskInstances().get(i).setActorName(actorName);
				// wfWorkflowinstance.getTaskInstances().get(i).setPoOrderRequest(poOrderRequestDao.get(
				// String.valueOf(wfWorkflowinstance.getTaskInstances().get(i).getItemsId())));
			}
		}
		return wfWorkflowinstance;
	}
    */
	// get task & workflow list

	/*public WfWorkflowinstance getAllActiveTaskList(String status) {
		return getUserActiveTaskList("", status);
	}*/

	// get workitem history by ordrequest record id
	public Result getOdWorkflowHistory(HttpServletRequest request, Long orderRequestId) {

		try {
			List<WfWorkitem> wfWorkitems = wfTaskinstanceDao.findWorkItemByRecordId(String.valueOf(orderRequestId));
			wfWorkitems.stream().filter(s -> s.getActorId() != null).forEach(el -> {
				el.setActorName(sysUserDao.getUserNameByUserId(el.getActorId()));
				String stateName = "";
				if (el.getState() != null)
					stateName = poStatusDao.get(String.valueOf(el.getState())).getRemarks();
				el.setStateName(stateName);
			});
			Result result = new Result(CodeMessage.SUCCESS);
			result.setData(wfWorkitems);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return new Result(CodeMessage.OPERATE_FAIL);
		}

	}

	// do task
	// with no change status
	@Transactional
	public void doWorkflowTask(String workItemId, String comments) {
		WfWorkitem wfWorkitem = wfWorkitemDao.get(workItemId);
		String insertComments = wfWorkitem.getComments();
		insertComments = comments + "\n" + insertComments+" By App";
		wfWorkitem.setComments(insertComments);
		Date now = new Date();
		wfWorkitem.setSignedTime(now);
		wfWorkitem.setEndTime(now);
		wfWorkitemDao.update(wfWorkitem);
	}

	// with change status
	@Transactional
	public void doWorkflowTask(String workItemId, String comments, String status) {
		WfWorkitem wfWorkitem = wfWorkitemDao.get(workItemId);
		String insertComments = wfWorkitem.getComments();
		insertComments = comments + "\n" + insertComments +"By App";
		wfWorkitem.setComments(insertComments);
		Date now = new Date();
		wfWorkitem.setSignedTime(now);
		wfWorkitem.setEndTime(now);
		wfWorkitem.setState(Long.valueOf(status));
		wfWorkitemDao.update(wfWorkitem);
	}

	// get product title for task
	@Transactional
	public List<WfWorkitem> getWorkItembByTaskInstance(WfTaskinstance wfTaskinstance) {
		return wfTaskinstanceDao
				.findWorkflowWorkItemListByTaskInstanceId(String.valueOf(wfTaskinstance.getTaskinstanceid()));
	}

	// get product title for task
	@Transactional
	public String getProductTitle(String recordId) {
		return poOrderRequestDao.getOrderRequest(Long.valueOf(recordId)).getProductTitle();
	}

	// get workflow instace by version
	@Transactional
	public WfWorkflowinstance getWorkflowInstanceByVersion(String version, String id) {

		List<WfWorkflowinstance> wfWorkflowinstances = wfTaskinstanceDao.getWorkflowInstanceByVersion(version, id);
		WfWorkflowinstance wfWorkflowinstance = null;
		if (wfWorkflowinstances != null && wfWorkflowinstances.size() > 0)
			wfWorkflowinstance = wfWorkflowinstances.get(0);
		return wfWorkflowinstance;
	}

	@Transactional
	public WfTaskinstance getTaskInstanceByWorkflow(String workflowInstanceId, String taskTypeId, String itemsId) {
		List<WfTaskinstance> wfTaskinstances = wfTaskinstanceDao.getTaskInstanceByWorkflow(workflowInstanceId,
				taskTypeId, itemsId);
		WfTaskinstance wfTaskinstance = null;
		if (wfTaskinstances != null && wfTaskinstances.size() > 0)
			wfTaskinstance = wfTaskinstances.get(0);
		return wfTaskinstance;
	}

	@Transactional
	public WfWorkitem getWorkItemByTask(String taskInstanceId, String actorId) {
		List<WfWorkitem> wfWorkitems = wfTaskinstanceDao.getWorkItemByTask(taskInstanceId, actorId);
		WfWorkitem wfWorkitem = null;
		if (wfWorkitems != null && wfWorkitems.size() > 0)
			wfWorkitem = wfWorkitems.get(0);
		return wfWorkitem;

	}
}
