package com.hanxin.commons.utils.resource;

import java.io.InputStream;

/**
 * IO资源接口
 */
public interface Resource {

  /**
   * 根据协议获取资源的输入流
   *
   * @param agreement
   * @return
   * @throws Exception
   */
  InputStream getInputStream(String agreement) throws Exception;

  /**
   * 根据协议判断此资源是否存在
   *
   * @param agreement
   * @return
   * @throws Exception
   */
  boolean isExists(String agreement) throws Exception;

  /**
   * 将输入流存储起来
   *
   * @param inputStream
   * @return
   * @throws Exception
   */
  String store(InputStream inputStream) throws Exception;

  /**
   *
   * @param agreement
   * @return
   */
  boolean isAnalysis(String agreement);

  /**
   * 删除资源
   *
   * @param agreement
   * @return
   * @throws Exception
   */
  boolean remove(String agreement) throws Exception;

}
