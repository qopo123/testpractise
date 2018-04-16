package com.ych.test;

/**
 * Created by yangchuanhua on 2017/6/2.
 */
public enum BookNamesEnums {
  KMZZ("总账"), KMMXZ("科目明细账");
  private String name;
  private BookNamesEnums(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static String getName(String value){
//    return valueOf(value).;
    return null;
  }
}
