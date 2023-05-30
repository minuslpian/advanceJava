package dao;

import pojos.Book;

public interface BookDao {
//add a new book to existing author
	String addNewBook(String authEmail,Book newBook);
}
