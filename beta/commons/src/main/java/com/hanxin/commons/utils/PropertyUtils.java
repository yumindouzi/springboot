package com.hanxin.commons.utils;

import java.io.File;

/**
 * 环节常量读取工具类
 *
 * @Author: hanxin
 * @Date: 2020/7/11 18:04
 * @Version 1.0
 */
public class PropertyUtils {

  public final static String PROPERTY_USER_HOME = "user.home";

  public static File readUserHomeDirectory() {
    return new File(readUserHome());
  }

  /**
   * 返回当前系统的家目录
   *
   * @return user.home/C:\Users\玉米豆子
   */
  public static String readUserHome() {
    return System.getProperty(PROPERTY_USER_HOME);
  }

}
