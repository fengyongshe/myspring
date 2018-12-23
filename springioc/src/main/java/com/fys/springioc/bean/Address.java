package com.fys.springioc.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Setter
@Getter
@ToString
@Controller("address")
public class Address {

  @Value("suzhou")
  private String city;

}
