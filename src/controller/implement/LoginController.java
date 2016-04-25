package controller.implement;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.PessoaFisica;
import persistence.LoginDao;

public class LoginController extends AbstractController {

	@Override
	public void execute() {

		try {
			String tipo_acesso = this.getRequest().getParameter("tipoAcesso");
			String ra = this.getRequest().getParameter("ra");
			String senha = this.getRequest().getParameter("senha");
			
			LoginDao ld = new LoginDao();
			
			PessoaFisica pf = ld.autenticar(Integer.parseInt(ra), senha, tipo_acesso);
			
			if(pf!= null){
				HttpSession session = this.getRequest().getSession();
				if(pf.getDisciplinaHorario() != null){
					session.setAttribute("lista", pf.getDisciplinaHorario());
				}else{
					throw new Exception("FODEU AQUI");
				}				
				session.setAttribute("pf", pf); //gravando o objeto usuario em sess�o!
				if(tipo_acesso.equals("aluno")){
					this.setReturnPage("/homeAluno.jsp");
				}else if(tipo_acesso.equals("professor")){
					this.setReturnPage("/homeProfessor.jsp");
				}else{
					throw new Exception("Usu�rio desconhecido. Tente novamente.");
				}

			}else{
				throw new Exception("Usu�rio n�o encontrado.");
			}
			


		} catch (Exception e) {
			this.setReturnPage("/login.jsp");
			this.getRequest().setAttribute("msg", e.getMessage());
		}

	}

}
