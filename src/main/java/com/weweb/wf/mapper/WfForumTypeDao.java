package com.weweb.wf.mapper;

import com.weweb.wf.entity.WfForumType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WfForumTypeDao  {
    WfForumType get(String forumtypeid);
} 
