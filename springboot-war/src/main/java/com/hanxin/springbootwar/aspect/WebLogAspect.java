package com.hanxin.springbootwar.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * aop处理日志切面
 *
 * @Author: hanxin
 * @Date: 2020/7/19 23:15
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

  private ThreadLocal<Long> startTime = new ThreadLocal<>();

  @Pointcut("execution(public * com.hanxin.springbootwar.controller.*.*(..))")
  public void webLog() {
  }

  @Before("webLog()")
  public void deBefore(JoinPoint joinPoint){
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    // 打印请求相关参数
    log.info("========================================== Start ==========================================");
    // 打印请求URL
    log.info("URL            : {}", request.getRequestURL().toString());
    // 打印http method
    log.info("HTTP Method    : {}", request.getMethod());
    // 打印调用controller的全路径以及执行方法
    log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringType(), joinPoint.getSignature().getName());
    // 打印请求的IP
    log.info("IP             : {}", request.getRemoteAddr());
    // 打印请求入参
    log.info("Request Args   : {}", Arrays.toString(joinPoint.getArgs()));
  }

  @After("webLog()")
  public void doAfter(){
    log.info("=========================================== End ===========================================");
    // 每个请求之间空一行
    log.info("");
  }

  @Around("webLog()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    long startTime = System.currentTimeMillis();
    Object result = proceedingJoinPoint.proceed();
    // 打印出参
    log.info("Response Args  : {}", result);
    // 执行耗时
    log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
    return result;
  }
  
}
