package com.fys.aop;

public class MyAspect {

  public void before() {
    System.out.println("Invoked Before from MyAspect");
  }

  public void after(){
    System.out.println("Invoked After from MyAspect");
  }

}
