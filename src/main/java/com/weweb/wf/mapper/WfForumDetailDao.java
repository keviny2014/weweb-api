package com.weweb.wf.mapper;

import com.weweb.wf.entity.WfForumDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WfForumDetailDao  {
    void insert(WfForumDetail wfForumDetail);
} 
