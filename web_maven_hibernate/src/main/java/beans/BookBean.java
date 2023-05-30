package beans;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.BookDaoImpl;
import pojos.Book;

public class BookBean {
	private String email;
	private String title;
	private String pubDate;
	private BookDaoImpl book;
	private String msg;
	
	public BookBean() throws SQLException {
		// create dao instance
		book = new BookDaoImpl();
		System.out.println("user bean created....");
	}
	public String addBook() {
		LocalDate d= LocalDate.parse(pubDate);
		LocalDate today = LocalDate.now();
		if(d.getYear()==today.getYear()) {
			msg=book.addNewBook(email, new Book(title));
		}else {
			msg="Invalid pub date, Book can't be added";
		}
		return "status";
	}
}
