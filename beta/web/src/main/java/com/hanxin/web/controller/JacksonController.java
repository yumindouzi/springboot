package com.hanxin.web.controller;

import com.hanxin.web.VO.UserVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanxin
 * @Date: 2020/7/11 11:29
 * @Version 1.0
 */
@RestController
@RequestMapping("testnull")
public class JacksonController {

  @RequestMapping("/user")
  public UserVo getUserVo() {
    return new UserVo("汉字", 26);
  }

  @RequestMapping("/list")
  public List<UserVo> getUserVoList() {
    List<UserVo> userList = new ArrayList<>();
    UserVo user1 = new UserVo("hx", 26);
    UserVo user2 = new UserVo(null, 27);
    userList.add(user1);
    userList.add(user2);
    return userList;
  }

  @RequestMapping("/map")
  public Map<String, Object> getMap() {
    Map<String, Object> map = new HashMap<>(3);
    UserVo user = new UserVo("hxh", 26);
    map.put("作者信息", user);
    map.put("博客地址", null);
    map.put("CSDN地址", "http://blog.csdn.net/eson_15");
    map.put("粉丝数量", 4153);
    return map;
  }

}
