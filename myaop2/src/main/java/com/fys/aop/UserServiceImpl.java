package com.fys.aop;

public class UserServiceImpl implements UserService {

  public void sayHello(String user) {
    System.out.println("Hello " + user);
  }

}