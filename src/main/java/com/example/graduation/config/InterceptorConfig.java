package com.example.graduation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <h3>graduation</h3>
 * <p>配置拦截器，注册之后才能生效</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 11:35
 **/

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 配饰Token拦截器，不拦截/login请求
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/register");
    }
}
