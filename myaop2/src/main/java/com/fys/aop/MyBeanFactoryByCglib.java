package com.fys.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyBeanFactoryByCglib {

  public static UserService createService() {
    final UserServiceImpl userService = new UserServiceImpl();
    final MyAspect myAspect = new MyAspect();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(userService.getClass());
    enhancer.setCallback(
        new MethodInterceptor() {
          public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            myAspect.before();
            Object obj = method.invoke(userService, args);
            methodProxy.invokeSuper(proxy, args);
            myAspect.after();
            return obj;
          }
        }
    );
    UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
    return proxyService;
  }

}
