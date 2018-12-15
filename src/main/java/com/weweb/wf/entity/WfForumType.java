package com.weweb.wf.entity;

import com.weweb.common.entity.DataEntity;

public class WfForumType extends DataEntity {
    private Long forumtypeid;
    private String objectname;


    public Long getForumtypeid() { return forumtypeid;}
    public void setForumtypeid(Long forumtypeid) { this.forumtypeid = forumtypeid;}

    public String getObjectname() { return objectname;}
    public void setObjectname(String objectname) { this.objectname = objectname;}

} 
