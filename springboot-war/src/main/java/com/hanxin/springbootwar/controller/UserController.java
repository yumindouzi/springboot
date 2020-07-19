package com.hanxin.springbootwar.controller;

import com.hanxin.springbootwar.biz.UserService;
import com.hanxin.springbootwar.dao.entity.UserInfo;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanxin
 * @Date: 2020/7/19 21:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@EnableCaching //开启缓存
@Slf4j
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping("/selectAll")
  public List<UserInfo> selectAll(){
    log.info(this.getClass().getName() + " enter -----------");
    return userService.selectAll();
  }

}
