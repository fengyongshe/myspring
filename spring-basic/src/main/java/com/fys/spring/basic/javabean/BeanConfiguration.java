package com.fys.spring.basic.javabean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public Student student() {
    Student student = new Student();
    student.setName("Tom");
    student.setTeacher(teacher());
    return student;
  }

  @Bean
  public Teacher teacher() {
    Teacher teacher = new Teacher();
    teacher.setName("Jerry");
    return teacher;
  }

}
