package com.hanxin.biz.service;

import com.hanxin.dao.entity.UserDo;
import java.util.List;
import java.util.Map;

public interface UserService {

  UserDo getUser(String id);

  UserDo getUserByIdAndName(String id, String name);

  Map<String, Object> getAll();

  UserDo getUserByName(String name);

}
