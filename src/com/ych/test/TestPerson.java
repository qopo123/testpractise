package com.ych.test;

import java.lang.reflect.Field;

/**
 * Created by yangchuanhua on 2017/7/11.
 */
public class TestPerson {

  public static void main(String[] args) throws IllegalAccessException {
    Person person = new Person();
    person.setName("hhh");
    Field[] fields = Person.class.getDeclaredFields();
    for(Field field : fields){
      field.setAccessible(true);
      String fieldValue = (String)field.get(person);
      System.out.println(fieldValue);
    }
  }
}
