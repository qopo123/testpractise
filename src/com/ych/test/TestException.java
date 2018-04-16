package com.ych.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangchuanhua on 2017/7/10.
 */
public class TestException {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(4);
    list.add(3);
//    sortList(list);
    System.out.println(list);
    File file = new File("hello.ss");
    OutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream(file);
      outputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      if(outputStream != null){
        try {
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static void sortList(List<Integer> list){
    Collections.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
  }
}
