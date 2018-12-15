package com.weweb.common.entity;

import java.util.List;

/**
 * Created by wshen on 5/22/2017.
 */
public class PageEntity {
    private Long total;
    private Integer pageSize;
    private Integer start;
    private List<?> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public PageEntity() {
    }

    public PageEntity(Long total, Integer start, Integer pageSize, List<?> list) {
        this.total = total;
        this.start = start;
        this.pageSize = pageSize;
        this.list = list;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
