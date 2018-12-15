package com.weweb.sys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weweb.sys.entity.SysUserToken;
import com.weweb.sys.mapper.SysUserDao;
import com.weweb.sys.mapper.SysUserTokenDao;

/**
 * Created by wshen on 5/3/2017.
 */
@Service
public class SysUserTokenService {
	@Autowired
	private SysUserTokenDao sysUserTokenDao;
	@Autowired
	private SysUserDao sysUserDao;
	@Transactional
	public void saveOrUpdateToken(SysUserToken sysUserToken){
		SysUserToken sysUserTokenPo=sysUserTokenDao.getSysUserTokenByUserId(sysUserToken.getUserId());
		if(sysUserTokenPo!=null){//update
			sysUserToken.setCreateTime(sysUserTokenPo.getCreateTime());
			sysUserToken.setTokenId(sysUserTokenPo.getTokenId());
			setSysUserToken(sysUserToken);
			sysUserTokenDao.update(sysUserToken);
		}else{//add
			setSysUserToken(sysUserToken);
			sysUserTokenDao.save(sysUserToken);
		}
	}
	private void setSysUserToken(SysUserToken sysUserToken){
		Long userId=sysUserToken.getUserId();
		List<String> roleNames=sysUserDao.getRoleNamesByUserId(userId);
		sysUserToken.setUserRoleName(roleNames.stream().collect(Collectors.joining(",")));
		String userName=sysUserDao.getUserNameByUserId(userId);
		sysUserToken.setUserName(userName);
	}
	public int logout(SysUserToken sysUserToken){
		return sysUserTokenDao.logout(sysUserToken);
	}
	public SysUserToken getSysUserTokenByToken(String token){
		return sysUserTokenDao.getSysUserTokenByToken(token);
	}

}
