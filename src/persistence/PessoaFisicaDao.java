package persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.PessoaFisica;

public class PessoaFisicaDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	// Método para autenticar o usuario pelo Login e Senha
	public PessoaFisica autenticar(int ra, String senha, String tipo_acesso) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery("pessoaFisica.autenticar");
		query.setInteger("ra", ra);
		query.setString("senha", senha);
		query.setString("tipo_acesso", tipo_acesso);
		
		PessoaFisica pf = (PessoaFisica) query.uniqueResult();

		session.close();
		return pf; // retornar o usuario
	}
	
	public PessoaFisica listaPorId(int id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery("pessoaFisica.listaPorId");
		query.setInteger("id", id);
		
		PessoaFisica pf = (PessoaFisica) query.uniqueResult();

		session.close();
		return pf; // retornar o usuario
	}

}
