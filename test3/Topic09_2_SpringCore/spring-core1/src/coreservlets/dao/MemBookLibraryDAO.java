package coreservlets.dao;

import coreservlets.model.Book;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MemBookLibraryDAO implements IBookLibraryDAO {

  private List<Book> books;

  public MemBookLibraryDAO() {
    this.books = Arrays.<Book>asList(
      new Book("Core Servlets and JavaServer Pages"),
      new Book("More Servlets and JavaServer Pages"));
  }

  public List<Book> search(String title) {
    List<Book>results = new ArrayList<Book>();
    for(Book book : books){
      if(book.getTitle().contains(title)){
        results.add(book);
      }
    }
    return results;
  }
}
