package com.weweb.wf.entity;



import com.weweb.po.entity.PoOrderRequest;

import java.util.List;

public class WfTaskinstance  {
    private Long taskinstanceid;
    private Long tasktypeid;
    private Long workflowinstanceid;
    private String name;
    private String displayname;
    private Long state;
    private Long taskType;
    private String createdTime;
    private String startedTime;
    private String expiredTime;
    private String endTime;
    private String assignmentStrategy;
    private Long workflowinstanceId;
    private Long workflowId;
    private Long version;
    private Long itemsId;
    private Long actorId;
    private String actorName;
    private List<WfWorkitem> workItems;
    private PoOrderRequest poOrderRequest;



    public List<WfWorkitem> getWorkItems() {
        return workItems;
    }
    public void setWorkItems(List<WfWorkitem> workItems) {
        this.workItems = workItems;
    }

    public Long getTaskinstanceid() { return taskinstanceid;}
    public void setTaskinstanceid(Long taskinstanceid) { this.taskinstanceid = taskinstanceid;}

    public Long getTasktypeid() { return tasktypeid;}
    public void setTasktypeid(Long tasktypeid) { this.tasktypeid = tasktypeid;}

    public Long getWorkflowinstanceid() { return workflowinstanceid;}
    public void setWorkflowinstanceid(Long workflowinstanceid) { this.workflowinstanceid = workflowinstanceid;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getDisplayname() { return displayname;}
    public void setDisplayname(String displayname) { this.displayname = displayname;}

    public Long getState() { return state;}
    public void setState(Long state) { this.state = state;}

    public Long getTaskType() { return taskType;}
    public void setTaskType(Long taskType) { this.taskType = taskType;}

    public String getCreatedTime() { return createdTime;}
    public void setCreatedTime(String createdTime) { this.createdTime = createdTime;}

    public String getStartedTime() { return startedTime;}
    public void setStartedTime(String startedTime) { this.startedTime = startedTime;}

    public String getExpiredTime() { return expiredTime;}
    public void setExpiredTime(String expiredTime) { this.expiredTime = expiredTime;}

    public String getEndTime() { return endTime;}
    public void setEndTime(String endTime) { this.endTime = endTime;}

    public String getAssignmentStrategy() { return assignmentStrategy;}
    public void setAssignmentStrategy(String assignmentStrategy) { this.assignmentStrategy = assignmentStrategy;}

    public Long getWorkflowinstanceId() { return workflowinstanceId;}
    public void setWorkflowinstanceId(Long workflowinstanceId) { this.workflowinstanceId = workflowinstanceId;}

    public Long getWorkflowId() { return workflowId;}
    public void setWorkflowId(Long workflowId) { this.workflowId = workflowId;}

    public Long getVersion() { return version;}
    public void setVersion(Long version) { this.version = version;}

    public Long getItemsId() { return itemsId;}
    public void setItemsId(Long itemsId) { this.itemsId = itemsId;}



    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public PoOrderRequest getPoOrderRequest() {
        return poOrderRequest;
    }

    public void setPoOrderRequest(PoOrderRequest poOrderRequest) {
        this.poOrderRequest = poOrderRequest;
    }
}
