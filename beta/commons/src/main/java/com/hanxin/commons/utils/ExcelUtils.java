package com.hanxin.commons.utils;

import com.hanxin.commons.constant.ParameterConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * excel工具
 *
 * @Author: hanxin
 * @Date: 2020/7/11 12:25
 * @Version 1.0
 */
public class ExcelUtils {

  /**
   * 判断是否为空行
   *
   * @param data
   * @return
   */
  public static boolean isEmptyRow(List<Object> data) {
    return isEmptyRow(data, true, true);
  }

  /**
   * 判断是否为空行
   *
   * @param data
   *            一行数据
   * @param isCheckEmptyString
   *            是否空字符串
   * @param isCheckStringTrim
   *            是否去掉左右空格判断
   * @return
   */
  public static boolean isEmptyRow(List<Object> data, boolean isCheckEmptyString, boolean isCheckStringTrim) {
    if (null == data) {
      return true;
    }
    int count = 0;
    for (int index = 0; index < data.size(); index++) {
      Object value = data.get(index);
      if (null == value) {
        continue;
      }
      if (isCheckEmptyString) {
        String sValue = null;
        if (value instanceof String) {
          sValue = (String) value;
        } else {
          sValue = value.toString();
        }
        if (isCheckStringTrim) {
          sValue = sValue.trim();
        }
        if ("".equals(sValue)) {
          continue;
        }
      }
      count++;
    }

    return count <= 0;
  }

  /**
   * 读取所有记录并一次返回
   *
   * @param excelFile
   * @return
   * @throws Exception
   */
  public static List<List<Object>> read(File excelFile) throws Exception {
    return read(excelFile, 0);
  }

  /**
   * 读取所有记录并一次返回
   *
   * @param excelFile
   * @param readSheetIndex
   * @return
   * @throws Exception
   */
  public static List<List<Object>> read(File excelFile, int readSheetIndex) throws Exception {
    Iterator<List<Object>> iterator = readIterator(excelFile, readSheetIndex);
    List<List<Object>> datas = new ArrayList<List<Object>>();
    while (iterator.hasNext()) {
      datas.add(iterator.next());
    }
    return datas;
  }

  /**
   * 读取所有记录并一次返回
   *
   * @param inputStream
   * @return
   * @throws Exception
   */
  public static List<List<Object>> read(InputStream inputStream) throws Exception {
    return read(inputStream, 0);
  }

  /**
   * 读取所有记录并一次返回
   *
   * @param inputStream
   * @return
   * @throws Exception
   */
  public static List<List<Object>> read(InputStream inputStream, int readSheetIndex) throws Exception {
    Iterator<List<Object>> iterator = readIterator(inputStream, readSheetIndex, 0, 0);
    List<List<Object>> datas = new ArrayList<List<Object>>();
    while (iterator.hasNext()) {
      datas.add(iterator.next());
    }
    return datas;
  }

  /**
   * 读取所有记录并一次返回
   *
   * @param inputStream
   * @return
   * @throws Exception
   */
  public static List<List<Object>> read(InputStream inputStream, int readSheetIndex, final int readStartRow, final int readStartColumn) throws Exception {
    Iterator<List<Object>> iterator = readIterator(inputStream, readSheetIndex, readStartRow, readStartColumn);
    List<List<Object>> datas = new ArrayList<List<Object>>();
    while (iterator.hasNext()) {
      datas.add(iterator.next());
    }
    return datas;
  }

  /**
   * Iterator读取EXCEL记录,由调用侧逐个处理,只支持XLS格式的EXCEL
   *
   * @param excelFile
   * @return
   * @throws Exception
   */
  public static Iterator<List<Object>> readIterator(File excelFile) throws Exception {
    return readIterator(excelFile, 0);
  }

  /**
   * Iterator读取EXCEL记录,由调用侧逐个处理,只支持XLS格式的EXCEL
   *
   * @param excelFile
   * @return
   * @throws Exception
   */
  public static Iterator<List<Object>> readIterator(File excelFile, int readSheetIndex) throws Exception {
    return readIterator(excelFile, readSheetIndex, 0, 0);
  }

  /**
   * Iterator读取EXCEL记录,由调用侧逐个处理,只支持XLS格式的EXCEL
   *
   * @param excelFile
   * @param readSheetIndex
   * @return
   * @throws Exception
   */
  public static Iterator<List<Object>> readIterator(File excelFile, int readSheetIndex, final int readStartRow, final int readStartColumn) throws Exception {
    InputStream inputStream = null;
    if (null == excelFile || !excelFile.exists() || !excelFile.isFile()) {
      throw new Exception("选择的EXCEL文件不正确或者不存在.");
    }
    try {
      // 1. 读取文件
      inputStream = new FileInputStream(excelFile);
      return readIterator(inputStream, readSheetIndex, readStartRow, readStartColumn);
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
    }
  }

  /**
   * Iterator读取EXCEL记录,由调用侧逐个处理,只支持XLS格式的EXCEL
   *
   * @param inputStream
   * @return
   * @throws Exception
   */
  public static Iterator<List<Object>> readIterator(InputStream inputStream) throws Exception {
    return readIterator(inputStream, 0, 0, 0);
  }

  /**
   * Iterator读取EXCEL记录,由调用侧逐个处理,只支持XLS格式的EXCEL
   *
   * @param inputStream
   * @param sheetIndex
   * @return
   * @throws Exception
   */
  public static Iterator<List<Object>> readIterator(InputStream inputStream, int sheetIndex) throws Exception {
    return readIterator(inputStream, sheetIndex, 0, 0);
  }

  /**
   * Iterator读取EXCEL记录,由调用侧逐个处理,只支持XLS格式的EXCEL
   */
  public static Iterator<List<Object>> readIterator(InputStream inputStream, final int readSheetIndex, final int readStartRow, final int readStartColumn) throws Exception {
    // 1. 读取文件
    Workbook workbook = Workbook.getWorkbook(inputStream);
    // 2. 读取SHEET
    final int sheetCount = workbook.getSheets().length;
    int sheetIndex = readSheetIndex <= 0 ? 0 : (readSheetIndex >= sheetCount ? sheetCount - 1 : sheetCount); // 超过最大读取最后一个;小于最小,读取第一个
    final Sheet sheet = workbook.getSheet(sheetIndex); // 默认读取第一个sheet
    // 3. 返回Iterator
    return new Iterator<List<Object>>() {

      private final int columns = sheet.getColumns();
      private final int rows = sheet.getRows();
      private int currentRow = readStartRow <= 0 ? 0 : (readStartRow >= rows ? rows : readStartRow); // 如果超过总行数,则代表没有读取的必要了
      private int startColumn = readStartColumn <= 0 ? 0 : (readStartColumn >= columns ? columns : readStartColumn);

      @Override
      public boolean hasNext() {
        return rows > currentRow;
      }

      @Override
      public List<Object> next() {
        List<Object> datas = new ArrayList<Object>();
        for (int column = startColumn; column < columns; column++) {
          datas.add(sheet.getCell(column, currentRow).getContents());
        }
        this.currentRow++;
        return datas;
      }

      @Override
      public void remove() {
      }
    };
  }

  /**
   * 输出
   *
   * @param title
   *            标题(SHEET的名称)
   * @param keyTitles
   *            数据标题头
   * @param keys
   *            数据中键名顺序(基于mybatis只能返回map)
   * @param datas
   *            数据
   * @return 返回生成的文件
   */
  public static File writer(String title, String[] keyTitles, String[] keys, List<Map<String, Object>> datas) throws Exception {
    if (datas == null || datas.isEmpty()) {
      datas = Collections.emptyList();
    }
    OutputStream outputStream = null;
    File outputFile = null;
    try {
      // 1. 创建文件
      File tmpSaveDirectory = readTmpSaveDirectory();
      if (!tmpSaveDirectory.exists()) {
        tmpSaveDirectory.mkdirs();
      }
      outputFile = File.createTempFile("excel", ".xls", tmpSaveDirectory);
      outputStream = new FileOutputStream(outputFile);
      WritableWorkbook workbook = Workbook.createWorkbook(outputStream);
      // 2. 写入标题
      WritableSheet sheet = workbook.createSheet(title, 0);
      if (null != keyTitles && keyTitles.length >= 1) {
        Label titleLable = null;
        for (int index = 0; index < keyTitles.length; index++) {
          titleLable = new Label(index, 0, keyTitles[index]);
          sheet.addCell(titleLable);
        }
      }
      // 3. 写入数据
      {
        final int rows = datas.size();
        for (int row = 1; row <= rows; row++) {
          Map<String, Object> map = datas.get(row - 1);
          final int columns = map.size();
          Label label = null;
          for (int column = 0; column < columns; column++) {
            Object value = map.get(keys[column]);
            if (value == null) {
              label = new Label(column, row, "");
            } else if (value instanceof String) {
              label = new Label(column, row, (String) value);
            } else {
              label = new Label(column, row, value.toString());
            }
            sheet.addCell(label);
          }
        }
      }
      // 4. 输出文档
      workbook.write();
      workbook.close();
    } finally {
      if (null != outputStream) {
        try {
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return outputFile;
  }

  private static File readTmpSaveDirectory() {
    return IoUtils.readTempSaveDirectory(ParameterConstant.TEMP_SAVE_DIRECTORY_EXPORT);
  }

}
