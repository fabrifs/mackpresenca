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

	//Método para autenticar o usuario pelo Login e Senha
		public List autenticar(String login, String senha, String tipo_acesso) 
			throws Exception{
			session = HibernateUtil.getSessionFactory().openSession();		
			

			//query = session.getNamedQuery("acesso.autenticar"); 
			//query = session.createQuery("FROM PessoaFisica");
			query = session.createQuery("FROM Acesso ac inner join a.pessoaFisica as pf where a.login='31401627'");
			//query.setString("login", login); 
			//query.setString("senha", senha); 
			//query.setString("tipo_acesso", tipo_acesso);
			
			/*List<Acesso> al = query.list();
			Acesso a = null;
			if(al ==  null){
				for(Acesso a1 : al){
					a = a1;			}
				System.out.println("Peguei A");// + a.getLogin());
			}*/
			//retorna 1 unico registro ou null
			/*PessoaFisica pf = (PessoaFisica) query.uniqueResult();
			Acesso a = pf.getAcesso();
			a.setPessoaFisica(pf);*/
			
			List<PessoaFisica> lista = query.list();
			
			session.close();
			return lista; //retornar o usuario
		}



}
