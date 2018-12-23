package com.fys.ioc.utils;

import java.lang.reflect.Method;

public class BeanUtil {

  public static Method getSetterMethod(Object obj, String name) {
    Method method = null;
    name = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    try {
      Method[] methods = obj.getClass().getMethods();
      //遍历该类的所有方法
      for(int i=0;i<methods.length;i++){
        Method m = methods[i];
        if(m.getName().equals(name)){
          method = obj.getClass().getMethod(name,m.getParameterTypes());
          break;
        }
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    return method;
  }

}
