package com.ych.entity;

/**
 * Created by Administrator on 2017/3/27.
 */
public class PdfEntity {

  private String fileName;
  private byte[] datas;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public byte[] getDatas() {
    return datas;
  }

  public void setDatas(byte[] datas) {
    this.datas = datas;
  }
}
