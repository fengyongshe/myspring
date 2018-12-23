package com.fys.ioc.config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlConfig {

  public static Map<String,Bean> getConfig(String path) {
    Map<String,Bean> configMap = new HashMap<String, Bean>();
    Document doc = null;
    SAXReader reader = new SAXReader();
    try {
      InputStream in = new FileInputStream(new File(path));
      doc = reader.read(in);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("Check XMLConfig path:" + path);
    }
    String xpath = "//bean";
    List<Element> list = doc.selectNodes(xpath);
    if(list != null) {
      for(Element beanEle: list) {
        Bean bean = new Bean();
        String id = beanEle.attributeValue("id");
        bean.setId(id);
        bean.setClassName(beanEle.attributeValue("class"));
        List<Element> proList = beanEle.elements("property");
        if(proList != null) {
          for (Element proEle : proList) {
            Property prop = new Property();
            prop.setName(proEle.attributeValue("name"));
            prop.setValue(proEle.attributeValue("value"));
            prop.setRef(proEle.attributeValue("ref"));
            bean.getProperties().add(prop);
          }
        }
        if(configMap.containsKey(id)) {
          throw new RuntimeException("Bean redefined in config:" + id);
        }
        configMap.put(id,bean);
      }
    }
    return configMap;
  }
}
