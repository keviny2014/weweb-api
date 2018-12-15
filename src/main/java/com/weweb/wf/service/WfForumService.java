package com.weweb.wf.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weweb.common.entity.CodeMessage;
import com.weweb.common.entity.GlobalConstants;
import com.weweb.common.entity.Result;
import com.weweb.common.util.FileUtils;
import com.weweb.common.util.SSTUtils;
import com.weweb.sys.entity.SysUserToken;
import com.weweb.wf.entity.ItemVo;
import com.weweb.wf.entity.WfForum;
import com.weweb.wf.entity.WfForumDetail;
import com.weweb.wf.entity.WfForumType;
import com.weweb.wf.mapper.WfForumDao;
import com.weweb.wf.mapper.WfForumDetailDao;
import com.weweb.wf.mapper.WfForumTypeDao;

/**
 * Created by zwan on 5/12/2017.
 */

@Service
public class WfForumService {
	@Autowired
	private WfForumDao wfForumDao;
	@Autowired
	private WfForumTypeDao wfForumTypeDao;
	@Autowired
	private WfForumDetailDao wfForumDetailDao;

	// Add Forum Detail
	@Transactional
	public void addOrderRequestForumDetail(String currentUserId,Long recordId, String description, String picture, String video) {
		addForumDetail(currentUserId,1L, recordId, description, picture, video);
	}

	@Transactional
	public void addPOForumDetail(String currentUserId,Long recordId, String description, String picture, String video) {
		addForumDetail(currentUserId,3L, recordId, description, picture, video);
	}

	@Transactional
	public void addPOItemsForumDetail(String currentUserId,Long recordId, String description, String picture, String video) {
		addForumDetail(currentUserId,2L, recordId, description, picture, video);
	}

	@Transactional
	public void addForumDetail(String currentUserId,Long forumType, Long recordId, String description, String picture, String video) {
		WfForum wfForum = new WfForum();
		wfForum.setForumtypeid(forumType);
		wfForum.setRecordid(recordId);
		// find Forum Id
		List<WfForum> isHadList = findListByRecordId(wfForum);
		WfForum curWfForum =isHadList.stream().findFirst()
				.orElse(createForum(currentUserId,forumType, recordId));
		WfForumDetail wfForumDetail = new WfForumDetail();
		wfForumDetail.setDescription(description);
		wfForumDetail.setPicture(picture);
		wfForumDetail.setVideo(video);
		wfForumDetail.setForumid(curWfForum.getForumid());
		wfForumDetail.setCreateBy(curWfForum.getCreateBy());
		wfForumDetailDao.insert(wfForumDetail);
	}

	// Create New Forum Title
	@Transactional
	public WfForum createForum(String currentUserId,Long forumType, Long recordId) {
		WfForumType wfForumType = wfForumTypeDao.get(String.valueOf(forumType));
		WfForum wfForum = new WfForum();
		wfForum.setForumtypeid(forumType);
		wfForum.setRecordid(recordId);
		wfForum.setTitle(wfForumType.getObjectname() + "--" + (new Date()).getTime());
		wfForum.setCreateBy(currentUserId);
		// if exist
		List<WfForum> isHadList = findListByRecordId(wfForum); // .getForumtypeid(),wfForum.getRecordid()
		// if exist ,not new
		if (isHadList.size() <= 0) {
			return createForum(wfForum);
			// return isHadList;
		}
		return null;
	}

	@Transactional
	public WfForum createForum(WfForum wfForum) {
		wfForumDao.insert(wfForum);
		return wfForum;
	}

	// get forum
	public List<WfForumType> findAllForumType() {
		return wfForumDao.findAllForumType();
	}

	public List<WfForum> findAllForum() {
		return wfForumDao.findAllForum();
	}

	// if exsist

	public List<WfForum> findListByRecordId(WfForum wfForum) {
		return wfForumDao.findListByRecordId(wfForum);
	}
	// get list
	public Result getForumDetailByOrderRequestID(Long recordId) {
		WfForum wfForum = getForumDetail(1L, recordId);
		Result result = new Result(CodeMessage.SUCCESS);
		result.setData(wfForum);
		return result;
	}

	public WfForum getForumDetailByPOID(Long recordId) {
		return getForumDetail(3L, recordId);
	}

	public WfForum getForumDetailByPOItemsID(Long recordId) {
		return getForumDetail(2L, recordId);
	}

	public WfForum getForumDetail(Long forumType, Long recordId) {
		WfForum wfForum = new WfForum();
		wfForum.setForumtypeid(forumType);
		wfForum.setRecordid(recordId);
		WfForum curWfForum = Optional.ofNullable(findListByRecordId(wfForum)).orElse(new ArrayList<>()).stream()
				.findFirst().orElse(new WfForum());
		curWfForum.setWfForumDetailList(getForumDetail(curWfForum));
		return curWfForum;
	}

	public List<WfForumDetail> getForumDetail(WfForum wfForum) {
		return wfForumDao.findForumDetail(GlobalConstants.imageServerPath+GlobalConstants.showItemForumImagePath,wfForum);
	/*	return Optional.ofNullable(wfForumDao.findForumDetail(GlobalConstants.imageServerPath+GlobalConstants.showItemForumImagePath,wfForum)).orElse(new ArrayList<>()).stream()
				.peek(item -> item.setCreateBy(sysUserDao.getUserNameByUserId(Long.valueOf(item.getCreateBy()))))
				.collect(toList());*/
	}

	public Result sendItemImage(HttpServletRequest request,Long recordId) throws Exception {
		SysUserToken sysUserToken=SSTUtils.getSysUserToken(request);
		String currentUserId=String.valueOf(sysUserToken.getUserId());
		String currentMonth=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))+"/";
		String path=GlobalConstants.uploadItemForumImagePath+currentMonth;
		List<FileUtils.FileEntity> fileEntities = FileUtils.upload(request, path);
		if (fileEntities.size()==0){
			return new Result(CodeMessage.OPERATE_FAIL,"upload image must be greater than or equal to 1");
		}
		fileEntities.stream().forEach(s->addOrderRequestForumDetail(currentUserId,recordId,null,currentMonth+s.getFileName(),null));
		return getForumDetailByOrderRequestID(Long.valueOf(recordId));
	}
	public Result sendItem(HttpServletRequest request,ItemVo itemVo) {
		SysUserToken sysUserToken= SSTUtils.getSysUserToken(request);
		String currentUserId=String.valueOf(sysUserToken.getUserId());
		Long recordId=itemVo.getRecordId();
		addOrderRequestForumDetail(currentUserId,recordId,itemVo.getContent(),null,null);
		return getForumDetailByOrderRequestID(Long.valueOf(recordId));
	}
}
