package com.weweb.sys.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.weweb.sys.entity.SysUserToken;

/**
 * Created by wshen on 5/3/2017.
 */
@Mapper
public interface SysUserTokenDao {
    int save(SysUserToken sysUserToken);
    int update(SysUserToken sysUserToken);
    int logout(SysUserToken sysUserToken);

    SysUserToken getSysUserTokenByUserId(Long userId);
    SysUserToken getSysUserTokenByToken(String token);

}
