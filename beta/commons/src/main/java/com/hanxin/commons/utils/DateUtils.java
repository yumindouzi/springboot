package com.hanxin.commons.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期格式化工具类
 *
 * @Author: hanxin
 * @Date: 2020/7/11 12:13
 * @Version 1.0
 */
public class DateUtils {

  public static final SimpleDateFormat FORMAT_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
  public static final SimpleDateFormat FORMAT_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
  public static final SimpleDateFormat FORMAT_yyyy_MM_dd_HH24_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public static final SimpleDateFormat FORMAT_ch_yyyy_MM_dd_HH24_mm_ss = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss", Locale.CHINESE);
  public static final SimpleDateFormat FORMAT_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
  public static final SimpleDateFormat FORMAT_HH_mm_ss = new SimpleDateFormat("HH:mm:ss");

  public static Date getDate(String dataStringValue, DateFormat dateFormat) throws ParseException {
    return dateFormat.parse(dataStringValue);
  }

  public static String getString(DateFormat dateFormat) {
    return dateFormat.format(new Date());
  }

  public static String getString(DateFormat dateFormat, Date date) {
    return dateFormat.format(date);
  }

  public static Date getYesterdayDate() throws ParseException {
    Date date = new Date(System.currentTimeMillis() - 86400000);
    return FORMAT_yyyy_MM_dd.parse(FORMAT_yyyy_MM_dd.format(date));
  }

  public static Date getTodayDate() throws ParseException {
    return FORMAT_yyyy_MM_dd.parse(FORMAT_yyyy_MM_dd.format(new Date()));
  }

  public static java.sql.Time getTime(String time, DateFormat dateFormat) throws ParseException {
    return getTime(dateFormat.parse(time));
  }

  public static java.sql.Time getTime(Date date) {
    return new java.sql.Time(date.getTime());
  }

}
