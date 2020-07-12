package com.hanxin.commons.utils;

import com.hanxin.commons.constant.ParameterConstant;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * 输入流与输出流操作工具单位类
 *
 * @Author: hanxin
 * @Date: 2020/7/11 12:29
 * @Version 1.0
 */
@Slf4j
public class IoUtils {

  /**
   * 判断输出
   *
   * @param writer
   */
  public static void closeWriter(Writer writer) {
    if (null != writer) {
      try {
        writer.close();
      } catch (Exception e) {
        if (log.isErrorEnabled()) {
          log.error(e.getMessage(), e);
        }
      }
    }
  }

  /**
   * 关闭读取
   *
   * @param reader
   */
  public static void closeReader(Reader reader) {
    if (null != reader) {
      try {
        reader.close();
      } catch (Exception e) {
        if (log.isErrorEnabled()) {
          log.error(e.getMessage(), e);
        }
      }
    }
  }

  /**
   * 关闭输入流
   *
   * @param inputStream
   */
  public static void closeInputStream(InputStream inputStream) {
    if (null != inputStream) {
      try {
        inputStream.close();
      } catch (Exception e) {
        if (log.isErrorEnabled()) {
          log.error(e.getMessage(), e);
        }
      }
    }
  }

  /**
   * 关闭输出流
   *
   * @param outputStream
   */
  public static void closeOutputStream(OutputStream outputStream) {
    if (null != outputStream) {
      try {
        outputStream.close();
      } catch (Exception e) {
        if (log.isErrorEnabled()) {
          log.error(e.getMessage(), e);
        }
      }
    }
  }

  /**
   * 将StringBuilder列表输出,每个占一行
   *
   * @param sbs
   * @return
   * @throws Exception
   */
  public static File writerStringBuilders(List<StringBuilder> sbs) throws Exception {
    File tempSaveDirectory = readTempSaveDirectory(ParameterConstant.TEMP_SAVE_DIRECTORY_EXPORT);
    File file = File.createTempFile("tmp", ".tmp", tempSaveDirectory);
    Writer writer = null;
    try {
      writer = new FileWriter(file);
      if (sbs == null || sbs.isEmpty()) {
        return file;
      }
      for (int index = 0; index < sbs.size(); index++) {
        writer.write(sbs.get(index).toString() + "\n");
      }
      writer.flush();
      return file;
    } finally {
      closeWriter(writer);
    }
  }

  /**
   * 读取临时目录,根据标识
   *
   * @param identification
   * @return
   */
  public static File readTempSaveDirectory(final String identification) {
    File tempSaveDirectory = new File(PropertyUtils.readUserHomeDirectory(), ".tempsave");
    if (!tempSaveDirectory.exists()) {
      tempSaveDirectory.mkdirs();
    }
    return tempSaveDirectory;
  }
  
}
