package coreservlets.demo02;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import coreservlets.model.Book;
import coreservlets.service.BookReader;

public class Main {
  public static void main(String[] args) {

    BeanFactory beanFactory = new ClassPathXmlApplicationContext(
        "/coreservlets/demo02/applicationContext.xml");

    BookReader client = (BookReader) beanFactory.getBean("bookReader");

    List<Book> books = client.read();

    System.out.printf("Client read: %s books%n", books.size());
    
  }
}
