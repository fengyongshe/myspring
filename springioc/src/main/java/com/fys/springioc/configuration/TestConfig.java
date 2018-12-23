package com.fys.springioc.configuration;

import com.fys.springioc.bean.Address;
import com.fys.springioc.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(BeanConfiguration.class);
    User user = (User) context.getBean("user");
    Address address = (Address) context.getBean("address");
    System.out.println("User Info: " + user.toString());
    System.out.println("Address Info: " + address.toString());
  }
}
