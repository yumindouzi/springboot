package com.hanxin.commons.constant;

/**
 * 表单相关的常量字段
 *
 * @Author: hanxin
 * @Date: 2020/7/11 12:09
 * @Version 1.0
 */
public class CommonFieldNameConstant {

  // 通用字段
  public static final String COMMON_FIELD_ID = "id";
  public static final String COMMON_FIELD_IDS = "ids";
  public static final String COMMON_FIELD_CODE = "code";
  public static final String COMMON_FIELD_NAME = "name";
  public static final String COMMON_FIELD_CREATE_DATE = "createDate";
  public static final String COMMON_FIELD_MODIFY_DATE = "modifyDate";
  public static final String COMMON_FIELD_CREATOR_ID = "creatorId";
  public static final String COMMON_FIELD_MODIFIER_ID = "modifierId";
  public static final String COMMON_FIELD_VERSION = "version";
  public static final String COMMON_FIELD_PASSWORD = "password";

  public static final String DEFAULT_CHARACTER_SEPARATOR = ",";

  // WSG提交JSON到HSF进行分析处理
  public static final String JSON_STRING = "json";

  // 分页相关
  public static final String PAGEING_START_PAGE_NUMBER = "pageNumber"; // 页码字段名称
  public static final String PAGEING_START_PAGE_SIZE = "pageSize"; // 页数字段名称

  // JSON信息标识
  public static final String INFORMATION_SUCCESS = "success";
  public static final String INFORMATION_MESSAGE = "message";
  public static final String INFORMATION_TOTAL = "total";
  public static final String INFORMATION_OBJECT = "object";
  public static final String INFORMATION_DATAS = "datas";
  public static final String INFORMATION_ERROR_MESSAGE = "errorMessage";
  public static final String INFORMATION_IS_EXCEPTION = "isException";

}
