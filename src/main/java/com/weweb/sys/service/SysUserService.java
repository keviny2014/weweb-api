package com.weweb.sys.service;

import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weweb.common.entity.CodeMessage;
import com.weweb.common.entity.Result;
import com.weweb.common.entity.SSTContants;
import com.weweb.common.util.SSTUtils;
import com.weweb.common.util.StringUtil;
import com.weweb.sys.entity.LoginVo;
import com.weweb.sys.entity.SysUser;
import com.weweb.sys.entity.SysUserToken;
import com.weweb.sys.mapper.SysUserDao;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by wshen on 5/3/2017.
 */
@Service
public class SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserTokenService sysUserTokenService;

	public Result login(HttpServletRequest request, LoginVo loginVo) throws Exception {
		String loginName = loginVo.getAccount();
		String reqPassword = loginVo.getPassword();
		SysUser sysUser = sysUserDao.getSysUser(loginName);
		if (sysUser == null || !validatePassword(sysUser.getPassword(), reqPassword)) {// login-fail
			return new Result(CodeMessage.OPERATE_FAIL, "Account or password not correct");
		} else {
			String token = generateToken(loginName, reqPassword);
			Long userId = sysUser.getId();
			String series = request.getHeader(SSTContants.REQUEST_HEADER_APP_SERIES);
			String tokenIp = StringUtil.getRemoteAddr(request);
			String type=request.getHeader(SSTContants.REQUEST_HEADER_DEV_OS_TYPE);
			SysUserToken sysUserToken=new SysUserToken();
			sysUserToken.setToken(token);
			sysUserToken.setUserId(userId);
			sysUserToken.setSeries(series);
			sysUserToken.setTokenIp(tokenIp);
			sysUserToken.setType(Integer.valueOf(type));
			sysUserToken.setIsOnLine(1);
			sysUserTokenService.saveOrUpdateToken(sysUserToken);
			return new Result(CodeMessage.SUCCESS, "Login successful", token);
		}
	}

	public Result logout(HttpServletRequest request) {
		SysUserToken sysUserToken = SSTUtils.getSysUserToken(request);
		sysUserToken.setIsOnLine(0);
		sysUserToken.setToken(UUID.randomUUID().toString());
		int count = sysUserTokenService.logout(sysUserToken);
		if (count > 0) {// logout
			return new Result(CodeMessage.SUCCESS, "Logout successful");
		} else {
			return new Result(CodeMessage.OPERATE_FAIL, "Operate fail");
		}
	}

	private String encoderByMd5(String str) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(str.getBytes());
		return new BigInteger(1, md5.digest()).toString(16);
	}

	private boolean validatePassword(String password, String reqPassword) throws Exception {
		return password.equals(encoderByMd5(reqPassword));
	}

	private String generateToken(String loginName, String password) {
		Key key = new SecretKeySpec((password + new Date().toString()).getBytes(),
				SignatureAlgorithm.HS512.getJcaName());
		return Jwts.builder().setSubject(loginName).signWith(SignatureAlgorithm.HS512, key).compact();
	}

	public SysUser getSysUserByUserId(Long userId) {
		return sysUserDao.getSysUserByUserId(userId);
	}

}
