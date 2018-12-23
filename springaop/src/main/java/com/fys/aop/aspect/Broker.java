package com.fys.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Broker {

  @Before("execution(* com.fys.aop.pojo.Landlord.service())")
  public void before() {
    System.out.println("Broker: Bring a Renter, and Give the price");
  }

  @After("execution(* com.fys.aop.pojo.Landlord.service())")
  public void after() {
    System.out.println("Borker: Hand the Key");
  }

}
