package com.hanxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author: hanxin
 * @Date: 2020/7/6 23:37
 * @Version 1.0
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.hanxin.dao.mapper")
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }

}
