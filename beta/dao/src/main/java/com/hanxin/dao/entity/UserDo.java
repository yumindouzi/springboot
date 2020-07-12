package com.hanxin.dao.entity;

import lombok.Data;

/**
 * @Author: hanxin
 * @Date: 2020/7/6 23:49
 * @Version 1.0
 */
public class UserDo {

  String id;
  String name;
  int age;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
