package com.fys.spring.basic.javabean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestJavaBean {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext  context =
        new AnnotationConfigApplicationContext(BeanConfiguration.class);
    Student student = (Student) context.getBean("student");
    Teacher teacher = (Teacher) context.getBean("teacher");

    System.out.println("Student Info:" + student.toString());
    System.out.println("Teacher Info:" + teacher.toString());
  }
}
