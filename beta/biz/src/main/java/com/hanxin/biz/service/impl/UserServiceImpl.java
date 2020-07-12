package com.hanxin.biz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hanxin.biz.service.UserService;
import com.hanxin.commons.constant.CommonFieldNameConstant;
import com.hanxin.dao.entity.UserDo;
import com.hanxin.dao.mapper.UserMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: hanxin
 * @Date: 2020/7/7 0:45
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Resource
  private UserMapper userMapper;

  private UserMapper getUserMapper(){
    return this.userMapper;
  }

  @Override
  public UserDo getUser(String id) {
    return getUserMapper().getUser(id);
  }

  @Override
  public UserDo getUserByIdAndName(String id, String name) {
    return getUserMapper().getUserByIdAndName(id,name);
  }

  @Override
  public Map<String, Object> getAll() {
    log.info(this.getClass().getName() + "enter ----- ");
    Map<String, Object> map = new HashMap<>();
    Page<?> page =PageHelper.startPage(1,2);
    List<UserDo> list = getUserMapper().getAll();
    map.put(CommonFieldNameConstant.INFORMATION_TOTAL, page.getTotal());
    map.put(CommonFieldNameConstant.INFORMATION_OBJECT, list);
    log.info(this.getClass().getName() + "done ----- ");
    return map;
  }

  @Override
  public UserDo getUserByName(String name) {
    return getUserMapper().getUserByName(name);
  }
}
