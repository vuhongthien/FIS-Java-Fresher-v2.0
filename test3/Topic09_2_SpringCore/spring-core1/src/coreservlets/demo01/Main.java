package coreservlets.demo01;

import coreservlets.dao.IBookLibraryDAO;
import coreservlets.dao.MemBookLibraryDAO;

import coreservlets.service.BookReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
				"/coreservlets/demo01/applicationContext.xml");

//		IBookLibraryDAO dao = (IBookLibraryDAO)beanFactory.getBean("bookLibrary");
//		BookReader client = new BookReader(dao);
//		System.out.println(client.read());


		BookReader book = (BookReader) beanFactory.getBean("bookReader");
		System.out.println(book.read());
	}


//	public static void main(String[] args) {
//		IBookLibraryDAO dao = new MemBookLibraryDAO();
//		BookReader client = new BookReader(dao);
//
//		System.out.println(client.read());
//	}
}
