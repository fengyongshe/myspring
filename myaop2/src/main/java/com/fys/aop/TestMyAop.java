package com.fys.aop;

public class TestMyAop {

  public static void main(String[] args) {
    UserService userService = MyBeanFactoryByCglib.createService();
    userService.sayHello("Tom");
  }
}
