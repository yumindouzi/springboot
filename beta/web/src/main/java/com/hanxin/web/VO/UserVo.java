package com.hanxin.web.VO;

import lombok.Data;

/**
 * @Author: hanxin
 * @Date: 2020/7/11 11:27
 * @Version 1.0
 */
@Data
public class UserVo {

  private String name;
  private int age;

  public UserVo() {
  }

  public UserVo(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }
}
