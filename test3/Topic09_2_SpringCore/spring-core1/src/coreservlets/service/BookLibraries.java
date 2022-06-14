package coreservlets.service;

import coreservlets.dao.IBookLibraryDAO;
import coreservlets.dao.MemBookLibraryDAO;

public class BookLibraries {

  public static IBookLibraryDAO newInstance(){
    return new MemBookLibraryDAO();
  }
  
}
