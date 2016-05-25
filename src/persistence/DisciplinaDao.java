package persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Disciplina;

public class DisciplinaDao {
	private Session session;
	private Transaction transaction;
	private Query query;

	public Disciplina listaPorId(int idDisc) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery("disciplina.listaPorId");
		query.setInteger("id", idDisc);
		Disciplina disc = (Disciplina) query.uniqueResult();

		session.close();
		return disc;
	}
}
