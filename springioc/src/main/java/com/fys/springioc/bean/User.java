package com.fys.springioc.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Getter
@Setter
@ToString
@Component("user")
public class User {

  @Value("tome")
  private String userName;
  @Resource
  private Address address;

}
