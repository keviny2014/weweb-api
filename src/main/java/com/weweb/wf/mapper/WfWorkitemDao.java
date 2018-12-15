package com.weweb.wf.mapper;

import com.weweb.wf.entity.WfWorkitem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WfWorkitemDao  {
    void insert(WfWorkitem wfWorkitem);
    void update(WfWorkitem wfWorkitem);
    WfWorkitem get(String workitemid);
} 
