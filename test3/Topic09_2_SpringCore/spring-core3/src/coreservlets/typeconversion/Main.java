package coreservlets.typeconversion;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) { 
    
    new ClassPathXmlApplicationContext(
      "/coreservlets/typeconversion"
      + "/applicationContext.xml");    
    
  }  
}
