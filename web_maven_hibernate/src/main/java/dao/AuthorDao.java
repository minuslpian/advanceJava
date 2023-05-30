package dao;

import pojos.Author;

public interface AuthorDao {
//add a method to save author + books details
	String addAuthorWithBooks(Author auth);
}
