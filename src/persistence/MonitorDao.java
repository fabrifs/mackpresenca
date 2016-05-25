package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Monitor;

public class MonitorDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	public int save(Monitor m) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		int id = (int) session.save(m);
		transaction.commit();
		session.close();
		return id;
	}

	public List<Monitor> listaPorDisciplina(int idDisciplina) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery("monitor.listarPorDisciplina");
		query.setInteger("id", idDisciplina);
		
		List<Monitor> monitor = query.list();
		
		session.close();
		return monitor;
	}
	
	public Monitor listaPorId(int id)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery("monitor.listaPorId");
		query.setInteger("id", id);
		
		Monitor monitor = (Monitor) query.uniqueResult();
		
		return monitor;
	}
	
	public void update(Monitor m)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.update(m);
		transaction.commit();
		session.close();
	}
	
	public void delete(Monitor m)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();
		session.delete(m);
		transaction.commit();
		session.close();
		
	}

}
