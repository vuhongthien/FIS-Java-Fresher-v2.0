package com.pluralsight.persistence.module01.demo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Main.class, args);

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");


    EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
    em = emf.createEntityManager();

    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("module01-persistence-unit");
    //em = emf.createEntityManager();

    persistBook(new Book(5044L, "H2G2", "Best IT Scifi Book", 12.5f, "1234-5678-5678", 247));

    Book book = findBook(5044L);

    System.out.println("# " + book);
  }


  /**
   * Gets an entity manager
   */
  //private static EntityManagerFactory emf;
  private static EntityManager em;

  /**
   * Persists the book to the database
   */
  private static void persistBook(Book book) {
    em.persist(book);
  }

  /**
   * Finds the book from the database
   */
  private static Book findBook(Long id) {
    return em.find(Book.class, id);
  }
}