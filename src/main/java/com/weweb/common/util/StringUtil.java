package com.weweb.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * Created by wshen on 5/4/2017.
 */
public class StringUtil {
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-Real-IP");
		if (isNoEmpty(remoteAddr)) {
			remoteAddr = request.getHeader("X-Forwarded-For");
		} else if (isNoEmpty(remoteAddr)) {
			remoteAddr = request.getHeader("Proxy-Client-IP");
		} else if (isNoEmpty(remoteAddr)) {
			remoteAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	public static boolean isAllEmpty(String content) {
		return isEmpty(content) || "null".equals(content) || "undefined".equals(content);
	}

	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	public static boolean isNoEmpty(String str) {
		return !isEmpty(str);
	}
}
