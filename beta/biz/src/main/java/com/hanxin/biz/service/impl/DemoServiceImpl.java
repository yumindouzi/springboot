package com.hanxin.biz.service.impl;

import com.hanxin.biz.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @Author: hanxin
 * @Date: 2020/7/6 23:36
 * @Version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {

  @Override
  public String test() {
    return "biz.test";
  }
}
