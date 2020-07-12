package com.hanxin.web.controller;

import com.hanxin.biz.service.UserService;
import com.hanxin.commons.exception.BizException;
import com.hanxin.dao.entity.UserDo;
import com.hanxin.web.VO.ResultBody;
import com.hanxin.web.VO.UserVo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanxin
 * @Date: 2020/7/7 0:48
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  private UserService getUserService(){
    return this.userService;
  }

  @GetMapping("getUser/{id}")
  UserDo getUser(String id){
    log.info("web.getUser enter -----");
    return new UserDo();
  }

  @PostMapping("getUserByIdAndName")
  UserDo getUserByIdAndName(@PathVariable String id, @PathVariable String name){
    return getUserService().getUserByIdAndName(id,name);
  }

  @GetMapping("getAll")
  ResultBody getAll(){
    log.info(this.getClass().getName() + " ---- enter ----- ");
    Map<String, Object> map = getUserService().getAll();
    return ResultBody.success(map);
  }

  @GetMapping("getUserByName/{name}")
  UserDo getUserByName(@PathVariable String name){
    log.info("name ----> {}", name);
    return getUserService().getUserByName(name);
  }

  // -------------------  ------------------
  @PostMapping("/creat")
  public boolean insert(@RequestBody UserVo user) {
    log.info(" ---- 开始新增 ---- ");
    log.info("user ----> {}",user);
    //如果姓名为空就手动抛出一个自定义的异常！
    if(user.getName()==null){
      throw  new BizException("-1","用户姓名不能为空！");
    }
    return true;
  }

  @PostMapping("/update")
  public boolean update(@RequestBody UserVo user) {
    log.info("开始新增...");
    //这里故意造成一个空指针的异常，并且不进行处理
    String str=null;
    str.equals("111");
    return true;
  }

}
