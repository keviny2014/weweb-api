package com.weweb.wf.mapper;

import com.weweb.wf.entity.WfWorkflowinstance;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface WfWorkflowinstanceDao  {
    void insert(WfWorkflowinstance wfWorkflowinstance);
} 
