package dao;

import pojos.Author;
import pojos.Book;

import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class BookDaoImpl implements BookDao {

	@Override
	public String addNewBook(String authEmail, Book newBook) {
		String jpql = "select a from Author a where a.email=:email";
		String mesg = "Adding  failed !!!!!!!!";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			Author author = session.createQuery(jpql, Author.class).setParameter("email", authEmail).getSingleResult();
			// author : persistent
			// simply call helper to establish bi dir asso.
			author.addBook(newBook);
			tx.commit();// Hib performs dirty chking --session.flush -->
			//inserting a rec in books n assigns FK
			mesg = "Added successfully!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;

	}

}
