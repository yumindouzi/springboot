package com.hanxin.commons.utils;

import com.hanxin.commons.constant.CommonFieldNameConstant;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 公共单元工具类
 *
 * @Author: hanxin
 * @Date: 2020/7/11 12:15
 * @Version 1.0
 */
@Slf4j
public class CommonUtils {

  /**
   * 当originalValue的值为空对象或者空字符串时,返回nullOrEmptyValue,不是则返回originalValue
   */
  public static String nullOrEmpty(String originalValue, String nullOrEmptyValue) {
    return isNullOrEmpty(originalValue, true) ? nullOrEmptyValue : originalValue;
  }

  /**
   * 当originalValue的值为空对象或者空字符串时,返回nullOrEmptyValue,不是则返回originalValue
   */
  public static String nullOrEmpty(String originalValue, boolean isTrim, String nullOrEmptyValue) {
    return isNullOrEmpty(originalValue, isTrim) ? nullOrEmptyValue : originalValue;
  }

  /**
   * 判断map是空对象或者空列表
   */
  public static boolean isNullOrEmpty(Map<?, ?> mapper) {
    return null == mapper || mapper.isEmpty();
  }

  /**
   * 判断列表为空对象或者空列表
   */
  public static boolean isNullOrEmpty(List<?> list) {
    return null == list || list.isEmpty();
  }

  /**
   * 判断列表不是空对象与空列表
   */
  public static boolean isNotNullAndEmpty(List<?> list) {
    return !isNullOrEmpty(list);
  }

  /**
   * 判断字符串是空对象或者是空字符串
   */
  public static boolean isNullOrEmpty(String str) {
    return isNullOrEmpty(str, false);
  }

  /**
   * 判断字符串是空对象或者是空字符串
   */
  public static boolean isNullOrEmpty(String str, boolean isTrim) {
    if (str == null) {
      return true;
    }
    return isTrim ? "".equals(str.trim()) : "".equals(str);
  }

  /**
   * 判断字符串符即不是空对象也不是空字符串
   */
  public static boolean isNotNullAndEmpty(String str) {
    return !isNullOrEmpty(str);
  }

  /**
   * 将对象类型转换成字符串
   */
  public static String object2String(Object objectValue) {
    return object2String(objectValue, null);
  }

  /**
   * 将对象转换为BigDecimal
   */
  public static BigDecimal object2BigDecimal(Object objectValue, BigDecimal nullDefaultValue) {
    return objectValue == null ? nullDefaultValue : (objectValue instanceof BigDecimal ? (BigDecimal) objectValue : new BigDecimal(objectValue.toString()));
  }

  /**
   * 将对象转换为整型包装类
   */
  public static Integer object2Integer(Object objectValue, Integer nullDefaultValue) {
    if (null == objectValue) {
      return nullDefaultValue;
    }
    if (objectValue instanceof Integer) {
      return (Integer) objectValue;
    }
    if (objectValue instanceof BigDecimal) {
      return ((BigDecimal) objectValue).intValue();
    }
    if (objectValue instanceof Long) {
      return ((Long) objectValue).intValue();
    }
    String stringValue = objectValue.toString();
    if (isNullOrEmpty(stringValue, true)) {
      return nullDefaultValue;
    }
    try {
      return Integer.parseInt(stringValue);
    } catch (Exception e) {
      return nullDefaultValue;
    }
  }

  /**
   * 将对象转换成int基础类型
   */
  public static int object2Int(Object objectValue, int nullDefaultValue) {
    return object2Integer(objectValue, nullDefaultValue);
  }

  /**
   * 将对象转换成字符串类型
   */
  public static String object2String(Object objectValue, String nullDefaultValue) {
    return null == objectValue ? nullDefaultValue : (objectValue instanceof String ? (String) objectValue : objectValue.toString());
  }

  /**
   * 将字符串数字转换成整型基本类型
   */
  public static int string2Int(String str, int nullDefaultValue) {
    return string2Integer(str, nullDefaultValue);
  }

  /**
   * 将字符串转换成整型对象类型
   */
  public static Integer string2Integer(String str, Integer nullDefaultValue) {
    if (isNullOrEmpty(str, true)) {
      return nullDefaultValue;
    }
    return new Integer(Integer.parseInt(str));
  }

  /**
   * 将字符串数字转换成长整型
   */
  public static long string2Long(String str, long nullDefaultValue) {
    if (isNullOrEmpty(str, true)) {
      return nullDefaultValue;
    }
    return Long.parseLong(str);
  }

  /**
   * 将字符串数字转换成BigDecimal
   */
  public static BigDecimal string2BigDecimal(String str, BigDecimal nullDefaultValue) {
    if (isNullOrEmpty(str, true)) {
      return nullDefaultValue;
    }
    return new BigDecimal(str);
  }

  public static BigDecimal string2BigDecimal(String str, int nullDefaultValue) {
    return string2BigDecimal(str, new BigDecimal(nullDefaultValue));
  }

  public static String list2String(Object[] list) {
    return list2String(list, CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR, null);
  }

  public static String list2String(Object[] list, String separator) {
    return list2String(list, separator, null);
  }

  public static String list2String(Object[] list, String separator, String nullOrEmptyValue) {
    if (null == list || list.length == 0) {
      return nullOrEmptyValue;
    }
    StringBuilder builder = new StringBuilder();
    if (separator == null) {
      separator = CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR;
    }
    if (list.length >= 1) {
      builder.append(list[0]);
      for (int index = 1; index < list.length; index++) {
        builder.append(separator).append(list[index]);
      }
    }

    return builder.length() >= 1 ? builder.toString() : nullOrEmptyValue;
  }

  /**
   * 将列表转换成字符串
   */
  public static String list2String(List<?> list) {
    return list2String(list, CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR, null);
  }

  /**
   * 将列表转换成字符串
   */
  public static String list2String(List<?> list, String separator) {
    return list2String(list, separator, null);
  }

  /**
   * 将列表转换成字符串
   */
  public static String list2String(List<?> list, String separator, String nullOrEmptyValue) {
    if (null == list || list.isEmpty()) {
      return nullOrEmptyValue;
    }
    StringBuilder builder = new StringBuilder();
    if (separator == null) {
      separator = CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR;
    }
    if (list.size() >= 1) {
      builder.append(list.get(0));
      for (int index = 1; index < list.size(); index++) {
        builder.append(separator).append(list.get(index));
      }
    }

    return builder.length() >= 1 ? builder.toString() : nullOrEmptyValue;
  }

  /**
   * 将字符串分隔成列表
   */
  public static List<String> string2ListString(String listString) {
    return string2ListString(listString, null);
  }

  /**
   * 将字符串分隔成列表
   */
  public static List<String> string2ListString(String listString, List<String> nullOrEmptyValue) {
    return string2ListString(listString, CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR, nullOrEmptyValue);
  }

  /**
   * 将字符串分隔成列表
   */
  public static List<String> string2ListString(String listString, String separator, List<String> nullOrEmptyValue) {
    return string2ListString(listString, separator, nullOrEmptyValue, true);
  }

  /**
   * 将字符串分隔成列表
   */
  public static List<String> string2ListString(String listString, String separator, List<String> nullOrEmptyValue, boolean isFilterEmpty) {
    if (isNullOrEmpty(listString, true)) {
      return nullOrEmptyValue;
    }

    if (separator == null) {
      separator = CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR;
    }

    String[] splitStrings = listString.split(separator);
    List<String> list = null;
    String value = null;
    if (splitStrings.length == 1) {
      value = splitStrings[0];
      if (isFilterEmpty && isNullOrEmpty(value)) {
        list = Collections.emptyList();
      } else {
        list = new ArrayList<String>(1);
        list.add(value);
      }
    } else {
      list = new ArrayList<String>(splitStrings.length);
      for (int index = 0; index < splitStrings.length; index++) {
        value = splitStrings[index];
        if (isFilterEmpty && isNullOrEmpty(value)) {
          continue;
        }
        list.add(value);
      }
    }

    return list == null || list.isEmpty() ? nullOrEmptyValue : list;
  }

  public static List<BigDecimal> string2ListBigDecimal(String listString, List<BigDecimal> nullOrEmptyValue) {
    return string2ListBigDecimal(listString, CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR, nullOrEmptyValue, true);
  }

  public static List<BigDecimal> string2ListBigDecimal(String listString, String separator, List<BigDecimal> nullOrEmptyValue) {
    return string2ListBigDecimal(listString, separator, nullOrEmptyValue, true);
  }

  /**
   * 将字符串分隔并转换成BigDecimal列表
   */
  public static List<BigDecimal> string2ListBigDecimal(String listString, String separator, List<BigDecimal> nullOrEmptyValue, boolean isFilterNull) {
    if (isNullOrEmpty(listString, true)) {
      return nullOrEmptyValue;
    }

    if (separator == null) {
      separator = CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR;
    }

    String[] splitStrings = listString.split(separator);
    List<BigDecimal> list = null;
    BigDecimal value = null;
    if (splitStrings.length == 1) {
      value = string2BigDecimal(splitStrings[0], null);
      if (isFilterNull && value == null) {
        list = Collections.emptyList();
      } else {
        list = new ArrayList<BigDecimal>(1);
        list.add(value);
      }
    } else {
      list = new ArrayList<BigDecimal>();
      for (int index = 0; index < splitStrings.length; index++) {
        value = string2BigDecimal(splitStrings[index], null);
        if (isFilterNull && value == null) {
          continue;
        }
        list.add(value);
      }
    }

    return list == null || list.isEmpty() ? nullOrEmptyValue : list;
  }

  private static int bufferMaxLength = 1024;

  /**
   * IO读取输入流到输出流(还没有测试,先不要用,暂时先private)
   */
  private static void ioRead2Writer(InputStream inputStream, OutputStream outputStream, final int readLength) throws Exception {
    if (readLength == 0) {
      return;
    }
    byte[] bufferBytes = new byte[bufferMaxLength];
    int nowReadlength = 0; // 当前读取到的长度
    int nextCanReadLength = 0; // 下次可以读取的长度
    int alsoNeedReadLength = readLength; // 还需要读取的长度

    do {
      if (alsoNeedReadLength >= 1) {
        nextCanReadLength = bufferMaxLength > alsoNeedReadLength ? alsoNeedReadLength : bufferMaxLength;
        alsoNeedReadLength -= nextCanReadLength;
      }
      nowReadlength = inputStream.read(bufferBytes, 0, nextCanReadLength);
      if (nowReadlength >= 1) {
        outputStream.write(bufferBytes, 0, nowReadlength);
      }
    } while (alsoNeedReadLength >= 1 && nowReadlength != -1);
  }

  /**
   * 将输入流全部写入到输出流中
   */
  public static void ioRead2Writer(InputStream inputStream, OutputStream outputStream) throws Exception {
    byte[] bufferBytes = new byte[bufferMaxLength];
    int nowReadlength = 0;
    while ((nowReadlength = inputStream.read(bufferBytes, 0, bufferMaxLength)) != -1) {
      outputStream.write(bufferBytes, 0, nowReadlength);
    }
  }

  /**
   * 前置补零
   */
  public static String frontZerofill(BigDecimal bigDecimal, int length) {
    if (bigDecimal == null) {
      return "";
    }
    if (length <= 0) {
      return bigDecimal.toString();
    }
    String numberString = bigDecimal.toString();
    if (numberString.length() >= length) {
      return numberString;
    }
    final int mssingCount = length - numberString.length();
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < mssingCount; i++) {
      buffer.append("0");
    }
    return buffer.append(numberString).toString();
  }

  /**
   * 拼接字符串
   */
  public static String mosaicStrings(String separator, Object... objects) {
    if (objects == null || objects.length == 0) {
      return null;
    }
    if (null == separator) {
      separator = CommonFieldNameConstant.DEFAULT_CHARACTER_SEPARATOR;
    }

    if (objects.length == 1) {
      return objects[0].toString();
    }

    StringBuilder builder = new StringBuilder();
    if (objects.length >= 1) {
      builder.append(objects[0]);
      for (int i = 1; i < objects.length; i++) {
        builder.append(separator).append(objects[i]);
      }
    }

    return builder.toString();
  }

}
