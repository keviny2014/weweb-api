package com.weweb.wf.mapper;

import com.weweb.wf.entity.WfForum;
import com.weweb.wf.entity.WfForumDetail;
import com.weweb.wf.entity.WfForumType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WfForumDao  {
    List<WfForum> findListByRecordId(WfForum wfForum);
    List<WfForumDetail> findForumDetail(@Param(value = "imagePath") String imagePath, @Param(value = "wfForum") WfForum wfForum);
    List<WfForumType> findAllForumType();
    List<WfForum> findAllForum();
    void insert(WfForum wfForum);
} 
