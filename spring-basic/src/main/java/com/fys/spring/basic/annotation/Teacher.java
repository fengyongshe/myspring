package com.fys.spring.basic.annotation;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component("teacher")
public class Teacher {

  @Value("Jerry")
  private String name;

}
