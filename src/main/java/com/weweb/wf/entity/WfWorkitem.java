package com.weweb.wf.entity;


import java.util.Date;

public class WfWorkitem  {
    private Long workitemid;
    private Long taskinstanceid;
    private Long state;
    private Date createdTime;
    private Date signedTime;
    private Date endTime;
    private Long actorId;
    private String comments;

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    private String actorName;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    private String stateName;


    public Long getWorkitemid() { return workitemid;}
    public void setWorkitemid(Long workitemid) { this.workitemid = workitemid;}

    public Long getTaskinstanceid() { return taskinstanceid;}
    public void setTaskinstanceid(Long taskinstanceid) { this.taskinstanceid = taskinstanceid;}

    public Long getState() { return state;}
    public void setState(Long state) { this.state = state;}

    public Date getCreatedTime() { return createdTime;}
    public void setCreatedTime(Date createdTime) { this.createdTime = createdTime;}

    public Date getSignedTime() { return signedTime;}
    public void setSignedTime(Date signedTime) { this.signedTime = signedTime;}

    public Date getEndTime() { return endTime;}
    public void setEndTime(Date endTime) { this.endTime = endTime;}

    public Long getActorId() { return actorId;}
    public void setActorId(Long actorId) { this.actorId = actorId;}

    public String getComments() { return comments;}
    public void setComments(String comments) { this.comments = comments;}

} 
