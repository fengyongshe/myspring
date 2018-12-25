package com.fys.spring.basic.annotation;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component("student")
public class Student {

  @Value("Tom")
  private String name;
  private Teacher teacher;

  @Autowired
  public Student(Teacher teacher) {
    this.teacher = teacher;
  }

}
