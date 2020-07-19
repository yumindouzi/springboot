package com.hanxin.springbootwar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanxin
 * @Date: 2020/7/19 18:25
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

  @RequestMapping("hello")
  public String hello(){
    log.info(this.getClass().getName() + " enter -----------");
    return "hello";
  }

}
