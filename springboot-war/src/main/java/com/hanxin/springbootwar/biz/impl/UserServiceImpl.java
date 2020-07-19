package com.hanxin.springbootwar.biz.impl;

import com.hanxin.springbootwar.biz.UserService;
import com.hanxin.springbootwar.dao.entity.UserInfo;
import com.hanxin.springbootwar.dao.mapper.UserInfoMapper;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: hanxin
 * @Date: 2020/7/19 21:55
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Resource
  private UserInfoMapper userInfoMapper;

  @Override
  public List<UserInfo> selectAll() {
    log.info(this.getClass().getName() + " enter -----------");
    return userInfoMapper.selectAll();
  }
}
