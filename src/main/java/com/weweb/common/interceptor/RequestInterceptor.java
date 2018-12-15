package com.weweb.common.interceptor;

import com.weweb.common.annotation.ValidationToken;
import com.weweb.common.entity.CodeMessage;
import com.weweb.common.entity.Result;
import com.weweb.common.entity.SSTContants;
import com.weweb.common.util.JsonUtils;
import com.weweb.common.util.StringUtil;
import com.weweb.sys.entity.SysUserToken;
import com.weweb.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by wshen on 5/3/2017.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {
    private Executor executor= Executors.newSingleThreadExecutor();
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("===========================================");
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            return validate(request, response, method);
        }
        return true;

    }
    private boolean validate(HttpServletRequest request, HttpServletResponse response, Method method)
            throws IOException {
        ValidationToken validationToken = method.getAnnotation(ValidationToken.class);
        if (validationToken != null&&validationToken.validate()) {
            String token=request.getHeader(SSTContants.REQUEST_HEADER_APP_TOKEN);
            if(StringUtil.isAllEmpty(token)){
                response.getWriter().write(JsonUtils.toString(new Result(CodeMessage.INVALIDTOKEN)));
                return false;
            }
            SysUserToken sysUserToken=sysUserTokenService.getSysUserTokenByToken(token);

            if (sysUserToken==null){
                response.getWriter().write(JsonUtils.toString(new Result(CodeMessage.UNAUTHUSER)));
                return false;
            }
            request.setAttribute("sysUserToken",sysUserToken);
        }
        return true;
    }

}
