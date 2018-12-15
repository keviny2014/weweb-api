package com.weweb.common.util;

import javax.servlet.http.HttpServletRequest;

import com.weweb.sys.entity.SysUserToken;

/**
 * Created by wshen on 5/11/2017.
 */
public class SSTUtils {
    public static SysUserToken getSysUserToken(HttpServletRequest request){
        return (SysUserToken) request.getAttribute("sysUserToken");
    }
}
