package com.ych;


import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/10.
 */
public class Person implements Serializable{
  
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static void main(String[] args) {
    Integer i = 1 >>> 3;
    String str = Integer.toOctalString(i);
    System.out.println(str);
    System.out.println(i);
  }
}
