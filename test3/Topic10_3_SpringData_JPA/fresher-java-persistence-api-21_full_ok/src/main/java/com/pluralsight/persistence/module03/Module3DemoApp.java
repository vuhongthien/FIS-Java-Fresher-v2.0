package com.pluralsight.persistence.module03;

import com.pluralsight.persistence.module03.demo01.Demo1Main;
import com.pluralsight.persistence.module03.demo02.Demo2Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class Module3DemoApp {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    ApplicationContext context = SpringApplication.run(Module3DemoApp.class, args);

    //new Demo1Main(context).test();
    new Demo2Main(context).test();
  }
}