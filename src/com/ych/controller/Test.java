package com.ych.controller;

/**
 * Created by Administrator on 2017/3/31.
 */
import plat.action.*;

import java.util.Currency;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

  private static final Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    int a = -1;
    Thread thread1 = new Threads();
    Thread thread2 = new Threads();
    Thread thread3 = new Threads();
    Thread thread4 = new Threads();
    Thread thread5 = new Threads();
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
  }
  static class Threads extends Thread{

    @Override
    public void run() {
      if(lock.tryLock()){
                  System.out.println("我获取到锁了。" + this.currentThread().getName());
        //        try {
        //        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
      }else{
        System.out.println("没获取到返回了");
        return;
      }
      try{

      }finally {
        System.out.println("解锁");
        lock.unlock();
      }
    }
  }
}


