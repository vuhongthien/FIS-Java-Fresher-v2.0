package coreservlets.service;

import java.util.List;

import coreservlets.dao.IBookLibraryDAO;
import coreservlets.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

public class BookReader {

  //@Autowired
  private IBookLibraryDAO bookLibrary;
  
  
  public BookReader(IBookLibraryDAO bookLibrary) {
    this.bookLibrary =
            bookLibrary;
  }

  public List<Book> read() {
    List<Book> books = bookLibrary.search("Java");
    for(Book book : books){
      System.out.printf("Reading: %s%n", book);
    }
    return books;
  }
}