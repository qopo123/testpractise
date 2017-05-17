package com.ych.pdfservice;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

import java.io.File;
import java.util.Properties;

/**
 * Created by Administrator on 2017/3/27.
 */
public class OfficeToPdf {
  private static final int wdFormatPDF = 17;
  private static final String WINODWSOPERATESYSTEM = "windows";
  private static final String LINUXOPERATESYSTEM = "linux";
  private static final String DESTFILEPATH = "D:\\test";
  private static String getOSType() {
    Properties prop = System.getProperties();
    String osName = prop.getProperty("os.name");
    if (osName == null || osName.trim().length() == 0) {
      return null;
    }
    if (osName.toLowerCase().startsWith("win")) {
      return WINODWSOPERATESYSTEM;
    } else if (osName.toLowerCase().contains("linux") || osName.toLowerCase().contains("unix")) {
      return LINUXOPERATESYSTEM;
    }

    return null;
  }

  private static void officeToPDF(String filePath){
    String suffix = getFileSufix(filePath);
    String sourceFile = filePath;
    String destFile = DESTFILEPATH + File.separator + filePath.replace(suffix,".pdf");
    if (suffix.equals("doc") || suffix.equals("docx")) {
      word2PDF(sourceFile, destFile);
    } else if (suffix.equals("ppt") || suffix.equals("pptx")) {
      ppt2PDF(sourceFile, destFile);
    } else if (suffix.equals("xls") || suffix.equals("xlsx")) {
      excel2PDF(sourceFile, destFile);
    }
  }
  private static String getFileSufix(String fileName) {
    int splitIndex = fileName.lastIndexOf(".");
    return fileName.substring(splitIndex + 1);
  }

  private static void word2PDF(String inputFile,String pdfFile){
    try {
      // 打开word应用程序
      ActiveXComponent app = new ActiveXComponent("Word.Application");
      // 设置word不可见
      app.setProperty("Visible", false);
      // 获得word中所有打开的文档,返回Documents对象
      Dispatch docs = app.getProperty("Documents").toDispatch();
      // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
      Dispatch doc = Dispatch.call(docs, "Open", inputFile, false, true).toDispatch();
      // 调用Document对象的SaveAs方法，将文档保存为pdf格式
      /*
       * Dispatch.call(doc, "SaveAs", pdfFile, wdFormatPDF //word保存为pdf格式宏，值为17 );
       */
      Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF // word保存为pdf格式宏，值为17
      );
      // 关闭文档
      Dispatch.call(doc, "Close", false);
      // 关闭word应用程序
      app.invoke("Quit", 0);
    } catch (Exception e) {
    }
  }

  private static void ppt2PDF(String inputFile,String pdfFile){

  }
  private static void excel2PDF(String inputFile,String pdfFile){

  }
}
