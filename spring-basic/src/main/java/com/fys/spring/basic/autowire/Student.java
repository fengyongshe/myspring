package com.fys.spring.basic.autowire;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {

  private String name;
  private Teacher teacher;

}
