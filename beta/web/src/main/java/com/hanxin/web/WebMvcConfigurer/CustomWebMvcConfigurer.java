package com.hanxin.web.WebMvcConfigurer;

import com.hanxin.web.WebMvcConfigurer.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CustomWebMvcConfigurer主拦截器
 *
 * @Author: hanxin
 * @Date: 2020/7/8 23:05
 * @Version 1.0
 */
//主拦截器，根据拦截不同路径跳转不同自定义拦截器 （实现WebMvcConfigurer方法）
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/user/*/**");
    //registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");
    //.excludePathPatterns("/api2/xxx/**"); //拦截全部 /*/*/**
    WebMvcConfigurer.super.addInterceptors(registry);
  }

}
