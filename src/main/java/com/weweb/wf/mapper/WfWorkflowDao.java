package com.weweb.wf.mapper;

import com.weweb.wf.entity.WfWorkflow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WfWorkflowDao  {
    public WfWorkflow getByName(String name);
} 
