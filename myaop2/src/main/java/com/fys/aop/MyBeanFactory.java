package com.fys.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

  public static UserService createService() {

    final UserService userService = new UserServiceImpl();
    final MyAspect myAspect = new MyAspect();

    UserService proxyService = (UserService) Proxy.newProxyInstance(
        MyBeanFactory.class.getClassLoader(),
        userService.getClass().getInterfaces(),
        new InvocationHandler() {
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            myAspect.before();
            Object obj = method.invoke(userService, args);
            myAspect.after();
            return obj;
          }
        }
    );
    return proxyService;
  }

}
