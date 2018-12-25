package com.fys.spring.basic.annotation;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestAnnotation {

  public static void main(String[] args) {

    FileSystemXmlApplicationContext  context =
        new FileSystemXmlApplicationContext("file:///root/myspring/spring-basic/src/main/resources/application-annotation-context.xml");
    Student student = (Student) context.getBean("student");
    Teacher teacher = (Teacher) context.getBean("teacher");

    System.out.println("Student Info:" + student.toString());
    System.out.println("Teacher Info:" + teacher.toString());

  }
}
