package com.hanxin.web.WebMvcConfigurer;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * LoginFilter过滤器
 *
 * @Author: hanxin
 * @Date: 2020/7/8 22:59
 * @Version 1.0
 */

// 过滤器拦截路径
@WebFilter(urlPatterns = "/user/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

  /**
   * 容器加载的时候调用
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println(" ------- 过滤器初始化 ------- ");
  }

  /**
   * 请求被拦截的时候进行调用
   */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("过滤中========过滤中========");
    HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
    HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
    if(hrequest.getRequestURI().indexOf("/user") != -1 ||
        hrequest.getRequestURI().indexOf("/asd") != -1 ||
        hrequest.getRequestURI().indexOf("/online") != -1 ||
        hrequest.getRequestURI().indexOf("/login") != -1
        ) {
      filterChain.doFilter(servletRequest, servletResponse);
    }else {
      wrapper.sendRedirect("/login");
    }

  }

  /**
   * 容器被销毁的时候被调用
   */
  @Override
  public void destroy() {
    System.out.println("过滤器销毁========过滤器销毁========");
  }

}
