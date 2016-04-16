package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Acesso;
import entity.PessoaFisica;

public class LoginDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	// Método para autenticar o usuario pelo Login e Senha
	public List listarPF() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM PessoaFisica");

		List<PessoaFisica> lista = query.list();

		session.close();
		return lista; // retornar o usuario
	}

}
