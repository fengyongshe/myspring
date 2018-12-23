package com.fys.springioc.configuration;

import com.fys.springioc.bean.Address;
import com.fys.springioc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public User user() {
    User user = new User();
    user.setUserName("Tom");
    user.setAddress(address());
    return user;
  }
  @Bean
  public Address address() {
    Address addr = new Address();
    addr.setCity("suzhou");
    return addr;
  }}