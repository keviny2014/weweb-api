package com.weweb.wf.entity;


import com.weweb.common.entity.DataEntity;

public class WfForumDetail extends DataEntity {
    private Long forumdetailid;
    private Long forumid;
    private String description;
    private String picture;
    private String video;
    private String formatDate;
    public Long getForumdetailid() { return forumdetailid;}
    public void setForumdetailid(Long forumdetailid) { this.forumdetailid = forumdetailid;}

    public Long getForumid() { return forumid;}
    public void setForumid(Long forumid) { this.forumid = forumid;}

    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public String getPicture() { return picture;}
    public void setPicture(String picture) { this.picture = picture;}

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }
}
