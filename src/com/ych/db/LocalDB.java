package com.ych.db;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/20.
 */
public class LocalDB implements Serializable{
  private static final Map<String,String> datas = new HashMap<>();
  static{
    System.out.println(datas.size());
    String oldValue = datas.put("1","1");
    System.out.println(oldValue);
    oldValue = datas.put("1","22");
    System.out.println(oldValue);
  }

  public static void main(String[] args) {
  }
}
