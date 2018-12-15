package com.weweb.wf.entity;


import java.util.List;

public class WfWorkflowinstance  {
    private Long workflowinstanceid;
    private Long workflowid;
    private String version;
    private String name;
    private String displayName;
    private Long state;
    private String createdTime;
    private String startedTime;
    private String expiredTime;
    private String endTime;
    private String parentWorkflowinstanceId;
    private String parentTaskinstanceId;

    private List<WfWorkitem> workItems;
    private List<WfTaskinstance> taskInstances;

    public List<WfTaskinstance> getTaskInstances() {
        return taskInstances;
    }

    public void setTaskInstances(List<WfTaskinstance> taskInstances) {
        this.taskInstances = taskInstances;
    }



    public List<WfWorkitem> getWorkItems() {
        return workItems;
    }

    public void setWorkItems(List<WfWorkitem> workItems) {
        this.workItems = workItems;
    }



    public Long getWorkflowinstanceid() { return workflowinstanceid;}
    public void setWorkflowinstanceid(Long workflowinstanceid) { this.workflowinstanceid = workflowinstanceid;}

    public Long getWorkflowid() { return workflowid;}
    public void setWorkflowid(Long workflowid) { this.workflowid = workflowid;}

    public String getVersion() { return version;}
    public void setVersion(String version) { this.version = version;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getDisplayName() { return displayName;}
    public void setDisplayName(String displayName) { this.displayName = displayName;}

    public Long getState() { return state;}
    public void setState(Long state) { this.state = state;}

    public String getCreatedTime() { return createdTime;}
    public void setCreatedTime(String createdTime) { this.createdTime = createdTime;}

    public String getStartedTime() { return startedTime;}
    public void setStartedTime(String startedTime) { this.startedTime = startedTime;}

    public String getExpiredTime() { return expiredTime;}
    public void setExpiredTime(String expiredTime) { this.expiredTime = expiredTime;}

    public String getEndTime() { return endTime;}
    public void setEndTime(String endTime) { this.endTime = endTime;}

    public String getParentWorkflowinstanceId() { return parentWorkflowinstanceId;}
    public void setParentWorkflowinstanceId(String parentWorkflowinstanceId) { this.parentWorkflowinstanceId = parentWorkflowinstanceId;}

    public String getParentTaskinstanceId() { return parentTaskinstanceId;}
    public void setParentTaskinstanceId(String parentTaskinstanceId) { this.parentTaskinstanceId = parentTaskinstanceId;}


}
