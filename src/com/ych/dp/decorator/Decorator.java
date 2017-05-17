package com.ych.dp.decorator;

/**
 * Created by Administrator on 2017/4/9.
 */
public abstract class Decorator extends Component {

  private Component component = null;
  public Decorator(Component component) {
    this.component = component;
  }

  //委托给装饰器执行
  @Override
  public void operate() {
    this.component.operate();
  }
}
