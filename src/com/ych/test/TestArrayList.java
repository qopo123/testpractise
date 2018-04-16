package com.ych.test;

import java.util.ArrayList;

/**
 * Created by yangchuanhua on 2017/7/3.
 */
public class TestArrayList {

  void print(ArrayList<Integer> arrayList){
    arrayList.add(2);
    arrayList = new ArrayList<>();
    arrayList.add(3);
    arrayList.add(4);
  }

  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    TestArrayList testArrayList = new TestArrayList();
    testArrayList.print(arrayList);
    System.out.println(arrayList.get(1));
  }
}
