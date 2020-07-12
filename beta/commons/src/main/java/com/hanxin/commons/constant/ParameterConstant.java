package com.hanxin.commons.constant;

import java.math.BigDecimal;

/**
 * 常用参数常量
 *
 * @Author: hanxin
 * @Date: 2020/7/11 12:31
 * @Version 1.0
 */
public class ParameterConstant {

  // other
  public static final Integer IS_DELETED_ALREADY_DELETED = 1; // 已经删除
  public static final Integer IS_DELETED_NOT_DELETED = 0; // 未删除
  public static final Integer VERSION_INITIAL_VALUE = 1; // 版本号初始值

  // default value
  public static final BigDecimal DEFAULT_NEGATIVE_ONE_BIGDECIMAL = new BigDecimal("-1");
  public static final BigDecimal DEFAULT_ZERO_BIGDECIMAL = new BigDecimal("0");
  public static final Integer DEFAULT_ZERO_INTEGER = 0;
  public static final Integer DEFAULT_ONE_INTEGER = 1;
  public static final String DEFAULT_USER_CODE_VALUE = "admin"; // 默认的用户编号,此值主要用于一些由自动任务生成的记录,需要添加创建人修改人信息

  public static final Integer DEFAULT_UPLOAD_FILE_CACHE_SIZE = 1048576; // 1024 * 1024;
  public static final Integer DEFAULT_UPDATE_FILE_MAX_SIZE = 5242880; // 5M
  public static final Integer DEFAULT_PAGEING_START_PAGE_NUMBER = DEFAULT_ONE_INTEGER; // 默认起始页码
  public static final Integer DEFAULT_PAGEING_NUMBER_OF_RECORDS_PER_PAGE = 10; // 默认每页显示记录数
  public static final String DEFAULT_CHARACTER_SEPARATOR = ","; // 默认字符分隔符

  // 临时保存目录
  public static final String TEMP_SAVE_DIRECTORY_EXPORT = "TEMP_SAVE_DIRECTORY_EXPORT"; // 导出的临时保存目录
  public static final String TEMP_SAVE_DIRECTORY_IMPORT = "TEMP_SAVE_DIRECTORY_IMPORT"; // 导入的临时保存目录

}
