package com.fys.springioc.xml;

import com.fys.springioc.bean.Address;
import com.fys.springioc.bean.User;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestXMLDI {

  public static void main(String[] args) {

    FileSystemXmlApplicationContext context =
        new FileSystemXmlApplicationContext("//root/trunk/myspring/springioc/src/main/resources/application-context.xml");
    User user = (User) context.getBean("user");
    Address address = (Address) context.getBean("address");
    System.out.println("User Info: " + user.toString());
    System.out.println("Address Info: " + address.toString());

  }
}
