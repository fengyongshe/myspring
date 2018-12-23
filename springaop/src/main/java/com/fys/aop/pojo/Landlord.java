package com.fys.aop.pojo;

import org.springframework.stereotype.Component;

@Component("landlord")
public class Landlord {

  public void service(){
    System.out.println("Landlord : Contact, the rent");
  }

}
