package com.fys.ioc.core;

import com.fys.ioc.bean.Address;
import com.fys.ioc.bean.User;
import org.junit.Assert;
import org.junit.Test;

public class IOCTest {

  @Test
  public void testBean() {
    //path <= absolute xml bean
    BeanFactory bf = new ClassPathXmlApplicationContext("/root/trunk/myspring/myioc/src/test/resources/application-context.xml");
    User user = (User) bf.getBean("user");
    Assert.assertEquals("tom",user.getUserName());
    Address address = (Address) bf.getBean("address");
    Assert.assertEquals("suzhou",address.getCity());
    Assert.assertEquals(user.getAddress().hashCode(), address.hashCode());
  }

}
