package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.DisciplinaHorario;

public class DisciplinaHorarioDao {
	
	private Session session;
	private Transaction transaction;
	private Query query;
	
	public List<DisciplinaHorario> listaPorId(int idDH) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery("disciplinaHorario.listarPorID");
		query.setInteger("id", idDH);
		List<DisciplinaHorario> dh = query.list();

		session.close();
		return dh; // 
	}
	
	public List<DisciplinaHorario> listaPorIdPf(int idPF) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery("disciplinaHorario.listarPorIDPF");
		query.setInteger("idpf", idPF);
		List<DisciplinaHorario> dh = query.list();

		session.close();
		return dh; // 
	}

}
