package com.weweb.sys.mapper;

import com.weweb.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao {
    SysUser getSysUser(String loginName);

    SysUser getSysUserByUserId(Long userId);

    String getUserNameByUserId(Long userId);
    List<String> getRoleNamesByUserId(Long userId);
}