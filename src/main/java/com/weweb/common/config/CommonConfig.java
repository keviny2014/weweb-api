package com.weweb.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.weweb.common.interceptor.RequestInterceptor;

/**
 * Created by wshen on 5/17/2017.
 */
@Configuration
public class CommonConfig extends WebMvcConfigurerAdapter {
    /***
     *
     * interceptor config
     */
    @Bean
    public RequestInterceptor getRequestInterceptor() {
        return new RequestInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getRequestInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
