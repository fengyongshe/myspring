package com.fys.aop;

import com.fys.aop.pojo.Landlord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Landlord landlord = (Landlord)context.getBean("landlord", Landlord.class);
    landlord.service();
  }
  
}
