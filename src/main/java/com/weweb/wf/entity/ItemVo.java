package com.weweb.wf.entity;

import javax.validation.constraints.NotNull;

/**
 * Created by wshen on 5/18/2017.
 */
public class ItemVo {
    @NotNull(message = "record id may not be empty")
    private Long recordId;
    @NotNull
    private String content;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
