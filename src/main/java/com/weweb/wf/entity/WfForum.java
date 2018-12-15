package com.weweb.wf.entity;

import java.util.Collections;
import java.util.List;

import com.weweb.common.entity.DataEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("WfForum")
public class WfForum  extends DataEntity{
    @ApiModelProperty(value = "forumid ")
    private Long forumid;
    @ApiModelProperty(value = "forumtypeid")
    private Long forumtypeid;
    @ApiModelProperty(value = "product title")
    private String title;
    @ApiModelProperty(value = "recordid")
    private Long recordid;

    public List<WfForumDetail> getWfForumDetailList() {
        return wfForumDetailList;
    }

    public void setWfForumDetailList(List<WfForumDetail> wfForumDetailList) {
        this.wfForumDetailList = wfForumDetailList;
    }

    private List<WfForumDetail> wfForumDetailList= Collections.emptyList();
    public Long getForumid() { return forumid;}
    public void setForumid(Long forumid) { this.forumid = forumid;}

    public Long getForumtypeid() { return forumtypeid;}
    public void setForumtypeid(Long forumtypeid) { this.forumtypeid = forumtypeid;}

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title;}

    public Long getRecordid() { return recordid;}
    public void setRecordid(Long recordid) { this.recordid = recordid;}

} 
