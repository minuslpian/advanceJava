package dao;

import pojos.Author;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public String addAuthorWithBooks(Author auth) {
		String mesg = "Adding  failed !!!!!!!!";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(auth);// auth : persistent
			tx.commit();
			mesg = "Added successfully!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;

	}

}
