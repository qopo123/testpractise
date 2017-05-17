package com.ych.dp.decorator;

/**
 * Created by Administrator on 2017/4/9.
 */
public class ConcreteDecorator extends Decorator {


  public ConcreteDecorator(Component component) {
    super(component);
  }

  //定义自己的修饰方法
  private void method(){
    System.out.println("mehtod 修饰");
  }

  @Override
  public void operate() {
    this.method();
    super.operate();
  }
}
