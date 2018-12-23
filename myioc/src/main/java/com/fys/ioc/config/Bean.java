package com.fys.ioc.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Bean {

  private String id;
  private String className;

  private List<Property> properties = new ArrayList<Property>();

}
