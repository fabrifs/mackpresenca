package persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Presenca;

public class PresencaDao {
	private Session session;
	private Transaction transaction;
	private Query query;
	
	
	public int save (Presenca p) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		
		int id = (int)session.save(p);
		transaction.commit();
		session.close();
		return id;		
	}
}
