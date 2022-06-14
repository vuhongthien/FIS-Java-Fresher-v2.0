package coreservlets.dao;

import coreservlets.model.Book;

import java.util.List;

public interface IBookLibraryDAO {

  public List<Book> search(String title);

}
