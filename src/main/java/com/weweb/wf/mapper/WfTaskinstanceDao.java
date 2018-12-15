package com.weweb.wf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weweb.wf.entity.WfTaskinstance;
import com.weweb.wf.entity.WfWorkflowinstance;
import com.weweb.wf.entity.WfWorkitem;

@Mapper
public interface WfTaskinstanceDao {
	// get workflow
	List<WfWorkflowinstance> getWorkflowInstanceByVersion(@Param("version") String version,
			@Param("workflowId") String workflowId);

	// get task instance
	List<WfTaskinstance> getTaskInstanceByWorkflow(@Param("workflowInstanceId") String workflowInstanceId,
			@Param("taskTypeId") String taskTypeId, @Param("itemsId") String itemsId);

	// get workitem by actor id
	List<WfWorkitem> getWorkItemByTask(@Param("taskInstanceId") String taskInstanceId,
			@Param("actorId") String actorId);

	// get
	List<WfTaskinstance> findWorkflowTaskListById(String workflowinstanceid);

	// get
	List<WfWorkitem> findWorkflowWorkItemListById(String workflowinstanceid);
	Long countWorkflowTaskList(@Param("userId") String userId, @Param("status") String status);
	// get
	List<WfTaskinstance> findWorkflowTaskList(@Param("userId") String userId, @Param("status") String status,@Param("start") Integer start,@Param("fetch") Integer fetch);

	// find taskinstance by
	List<WfWorkitem> findWorkflowWorkItemListByTaskInstanceId(String taskinstanceid);

	// find operation record by id
	List<WfWorkitem> findWorkItemByRecordId(String recordId);

	void insert(WfTaskinstance wfTaskinstance);
}
