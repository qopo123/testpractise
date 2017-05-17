package com.ych.pdfservice;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.ych.entity.PdfEntity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/3/27.
 */
public class PictureToPdf {
  private static final String destPath = "D:\\test\\";
  public static void getPdfEntity(String filePath) throws Exception{
    File file = new File(filePath);
    if(!file.exists()){
      System.out.println("没有此文件");
      return;
    }
    if(file.isDirectory()){
      System.out.println("文件不能为");
      return;
    }
    convertToPdf(file);
  }

  public static void convertToPdf(File file) throws Exception{
    String targetFileName = destPath + file.getName().substring(0, file.getName().lastIndexOf(".")) + ".pdf";
    Document doc = new Document(PageSize.A4, 10, 10, 10, 10);
//    ByteArrayOutputStream bos = null;
    OutputStream outputStream = null;
    try {
      //      bos = new ByteArrayOutputStream();
      File targeFile = new File(targetFileName);
      outputStream = new FileOutputStream(targeFile);
      PdfWriter.getInstance(doc, outputStream);
      doc.open();
      doc.newPage();
      Image image = Image.getInstance(file.getAbsolutePath());
      float heigth = image.getHeight();
      float width = image.getWidth();
      int percent = getPercent2(heigth, width);
      image.setAlignment(Image.MIDDLE);
      image.scalePercent(percent + 3);// 表示是原来图像的比例;
      doc.add(image);
      doc.close();
//      bos.writeTo(outputStream);
//      bos.flush();
    } catch (Exception e) {

    } finally {
      if (outputStream != null) {
        outputStream.close();
      }
    }
  }

  private static int getPercent2(float h, float w) {
    int p = 0;
    float p2 = 0.0f;
    p2 = 530 / w * 100;
    p = Math.round(p2);
    return p;
  }

  public static void main(String[] args) throws Exception{
    String sourceName = "D:\\test\\2017021702180.jpg";
    getPdfEntity(sourceName);
  }
}
