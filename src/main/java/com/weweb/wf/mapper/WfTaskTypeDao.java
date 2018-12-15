package com.weweb.wf.mapper;


import com.weweb.wf.entity.WfTaskType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WfTaskTypeDao {
    public WfTaskType getByName(String name);
} 
