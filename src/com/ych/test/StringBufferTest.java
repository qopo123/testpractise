package com.ych.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by yangchuanhua on 2017/7/21.
 */
public class StringBufferTest {

  public static void main(String[] args) throws UnsupportedEncodingException {
    String ss = URLEncoder.encode("预约二维码", "UTF-8");
    System.out.println(ss);
  }
}
