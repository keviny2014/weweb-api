package com.weweb.wf.entity;

public class WfWorkflow  {
    private Long workflowid;
    private String name;
    private String displayName;
    private String description;
    private Long version;
    private String processContent;
    private String published;
    private Long publisher;
    private String publishTime;


    public Long getWorkflowid() { return workflowid;}
    public void setWorkflowid(Long workflowid) { this.workflowid = workflowid;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getDisplayName() { return displayName;}
    public void setDisplayName(String displayName) { this.displayName = displayName;}

    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public Long getVersion() { return version;}
    public void setVersion(Long version) { this.version = version;}

    public String getProcessContent() { return processContent;}
    public void setProcessContent(String processContent) { this.processContent = processContent;}

    public String getPublished() { return published;}
    public void setPublished(String published) { this.published = published;}

    public Long getPublisher() { return publisher;}
    public void setPublisher(Long publisher) { this.publisher = publisher;}

    public String getPublishTime() { return publishTime;}
    public void setPublishTime(String publishTime) { this.publishTime = publishTime;}

} 
