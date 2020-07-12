package com.hanxin.commons.utils.resource;

import com.hanxin.commons.utils.CommonUtils;
import com.hanxin.commons.utils.PropertyUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 操作系统文件系统实现
 *
 * @Author: hanxin
 * @Date: 2020/7/11 18:02
 * @Version 1.0
 */
public class FileResource implements Resource {

  private final String AGREEMENT_START_WITH = "file:";

  @Override
  public InputStream getInputStream(String agreement) throws Exception {
    File file = this.analysisAgreement(agreement);
    if (file.exists()) {
      InputStream in = new FileInputStream(file);
      return in;
    }
    return null;
  }

  public boolean isExists(String agreement) throws Exception {
    File file = this.analysisAgreement(agreement);
    return file.exists();
  }

  @Override
  public String store(InputStream inputStream) throws Exception {
    FileOutputStream fileOutputStream = null;
    try {
      File tmpSaveDirectory = new File(PropertyUtils.readUserHomeDirectory(), "resource");
      if (!tmpSaveDirectory.exists()) {
        tmpSaveDirectory.mkdirs();
      }
      File storeFile = File.createTempFile("resource", ".tmp", tmpSaveDirectory);
      fileOutputStream = new FileOutputStream(storeFile);
      CommonUtils.ioRead2Writer(inputStream, fileOutputStream);
      return AGREEMENT_START_WITH + storeFile.toString();
    } finally {
      if (null != fileOutputStream) {
        fileOutputStream.flush();
        fileOutputStream.close();
      }
    }
  }

  private File analysisAgreement(String agreement) throws Exception {
    if (CommonUtils.isNullOrEmpty(agreement)) {
      throw new Exception("agreement is null.");
    }
    if (agreement.length() == 0) {
      throw new Exception("agreement is emptry!");
    }

    String agreementStartString = agreement.substring(0, AGREEMENT_START_WITH.length());
    if (!agreementStartString.equalsIgnoreCase(AGREEMENT_START_WITH)) {
      throw new Exception("agreement: " + agreement + " not supper!");
    }

    String agreementStartContext = agreement.substring(AGREEMENT_START_WITH.length());

    return new File(agreementStartContext);
  }

  @Override
  public boolean isAnalysis(String agreement) {
    try {
      return this.analysisAgreement(agreement) != null;
    } catch (Exception e) {
    }
    return false;
  }

  @Override
  public boolean remove(String agreement) throws Exception {
    File resource = this.analysisAgreement(agreement);
    if (resource.exists()) {
      return resource.delete();
    }
    return true; // 不存在,相当于已经删除了
  }

}
