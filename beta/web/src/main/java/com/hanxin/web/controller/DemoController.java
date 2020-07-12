package com.hanxin.web.controller;

import com.hanxin.biz.service.DemoService;
import com.hanxin.web.VO.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanxin
 * @Date: 2020/7/6 23:39
 * @Version 1.0
 */
@RestController
@RequestMapping("demo")
@Slf4j
public class DemoController {

  @Autowired
  private DemoService demoService;

  private DemoService getDemoService(){
    return this.demoService;
  }

  @GetMapping("test")
  public String test(){
    log.info("---- web.demo.test start ----");
    return getDemoService().test();
  }

}
