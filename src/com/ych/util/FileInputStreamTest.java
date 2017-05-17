package com.ych.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/15.
 */
public class FileInputStreamTest {
  public static void main(String[] args) {
    FileInputStream input = null;
    try {
      File file = new File("C://Users//Administrator//Downloads//66050358.pdf");
      input = new FileInputStream(file);
      byte[] bytes = new byte[(int)file.length()];
      input.read(bytes);
      System.out.println("sssss");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
