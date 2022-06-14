package coreservlets.service;

import coreservlets.dao.IBookLibraryDAO;
import coreservlets.dao.MemBookLibraryDAO;

public class BookLibraryFactory {

  public IBookLibraryDAO newInstance(){
    return new MemBookLibraryDAO();
  }
  
}
