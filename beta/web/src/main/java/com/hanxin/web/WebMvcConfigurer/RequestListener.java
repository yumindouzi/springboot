package com.hanxin.web.WebMvcConfigurer;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Servlet监听器
 * @Author: hanxin
 * @Date: 2020/7/8 23:03
 * @Version 1.0
 */
@WebListener
public class RequestListener implements ServletRequestListener {

  public void requestDestroyed(ServletRequestEvent sre) {
    System.out.println("======销毁监听器========");
  }

  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("======进入监听器========");

  }

}
