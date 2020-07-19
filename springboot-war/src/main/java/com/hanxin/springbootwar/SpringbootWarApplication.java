package com.hanxin.springbootwar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan(value = "com.hanxin.springbootwar.dao.mapper")
public class SpringbootWarApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootWarApplication.class, args);
  }

  // 设置 CORS 相关的协议头，否则前端不能跨域过来请求
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("*")
            .maxAge(Long.MAX_VALUE);
      }
    };
  }

}
