package com.fys.ioc.core;

import com.fys.ioc.config.Bean;
import com.fys.ioc.config.Property;
import com.fys.ioc.config.XmlConfig;
import com.fys.ioc.utils.BeanUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext implements BeanFactory  {

  private Map<String,Object> ioc;
  private Map<String,Bean> config;

  public ClassPathXmlApplicationContext(String path) {
    ioc = new HashMap<String, Object>();
    config = XmlConfig.getConfig(path);
    if(config != null) {
      for(Map.Entry<String,Bean> entry: config.entrySet()) {
        String beanId = entry.getKey();
        Bean bean = entry.getValue();
        Object object = createBean(bean);
        System.out.println("IOC put: "+ bean+" => "+object.toString());
        ioc.put(beanId, object);
      }
    }
  }

  private Object createBean(Bean bean) {
    try {
      String beanId = bean.getId();
      String className = bean.getClassName();
      Class c = null;
      Object object = null;
      c = Class.forName(className);
      object = c.newInstance();
      if(bean.getProperties() != null) {
        for(Property p : bean.getProperties()) {
          if (p.getValue() != null) {
            Method getMethod = BeanUtil.getSetterMethod(object, p.getName());
            getMethod.invoke(object, p.getValue());
          }
          if(p.getRef() != null) {
            Method getMethod = BeanUtil.getSetterMethod(object, p.getName());
            Object obj = ioc.get(p.getRef());
            if(obj == null) {
              throw new RuntimeException("Cann't find dependency:" + p.getRef());
            } else {
              getMethod.invoke(object, obj);
            }
          }
        }
      }
      return object;
    } catch (Exception e) {
      throw new RuntimeException("Config Not Illegal",e);
    }
  }

  public Object getBean(String beanId) {
    return ioc.get(beanId);
  }
}
