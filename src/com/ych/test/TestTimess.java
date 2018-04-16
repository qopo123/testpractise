package com.ych.test;

import java.text.ParseException;

/**
 * Created by yangchuanhua on 2017/5/31.
 */
public class TestTimess {
  public static void main(String[] args) throws ParseException {
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    Date date = sdf.parse("2017-02-27");
//    System.out.println(date);
//    Date date1 = new Date();
//    String name = "PZ_001_201702_1_记-0002.PDF";
//    System.out.println(name.substring(0, name.lastIndexOf(".")));
//    Long longs = 33234L;
//    System.out.println(String.valueOf(longs));
    String type = "XMZZ";
    String strings = type.split("_")[0];
    System.out.println(strings);
  }
}
