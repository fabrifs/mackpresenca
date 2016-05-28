package persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Aula;

public class AulaDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	public int save(Aula a) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		int id = (int) session.save(a);
		transaction.commit();
		session.close();
		return id;
	}


	public Aula findById(int id) {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		query = session.getNamedQuery("aula.findById");
		query.setInteger("id", id);
		Aula aula = (Aula) query.uniqueResult();
		transaction.commit();
		session.close();
		return aula;

	}

	public void update(Aula a) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();
		session.update(a);
		transaction.commit();
		session.close();
	}

	public List<Aula> achaAulaHoje(int idProfessor, int idDh) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		query = session.getNamedQuery("aula.validaInicio");
		query.setInteger("idDh", idDh);
		query.setInteger("idProfessor", idProfessor);

		List<Aula> aula = query.list();
		transaction.commit();
		session.close();
		return aula;
	}
	
	public List<Aula> achaAulaPorData(Date dataInicio, Date dataFim) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		query = session.getNamedQuery("aula.findByDate");
		query.setDate("dataInicio", dataInicio);
		query.setDate("dataFim", dataFim);

		List<Aula> aula = query.list();
		transaction.commit();
		session.close();
		return aula;
	}
	
	public List<Aula> achaAulaPorDataDis(Date dataInicio, Date dataFim, int idDh) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		query = session.getNamedQuery("aula.findByDateDisc");
		query.setInteger("idDh", idDh);
		query.setDate("dataInicio", dataInicio);
		query.setDate("dataFim", dataFim);

		List<Aula> aula = query.list();
		transaction.commit();
		session.close();
		return aula;
	}

}
