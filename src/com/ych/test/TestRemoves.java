package com.ych.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangchuanhua on 2017/6/5.
 */
public class TestRemoves {
  public static void main(String[] args) {
    List<String> stringList = new ArrayList<String>();
    stringList.add("111");
    stringList.add("222");
    stringList.add("333");
    System.out.println(isExist(stringList));
  }

  public static boolean isExist(List<String> stringList) {
    for (int i = 0; i < stringList.size(); i++) {
      if ("111".equals(stringList.get(i))) {
        stringList.remove(i);
        return true;
      }
    }
    return false;
  }
}
