package com.hanxin.springbootwar.biz;

import com.hanxin.springbootwar.dao.entity.UserInfo;
import java.util.List;

public interface UserService {

  List<UserInfo> selectAll();

}
