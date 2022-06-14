package coreservlets.dao;

import coreservlets.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MySQLBookLibraryDAO implements IBookLibraryDAO {

	public List<Book> search(String title) {
		System.out.println("MySQL");
		return new ArrayList<Book>();
	}

}
