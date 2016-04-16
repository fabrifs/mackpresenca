package controller.implement;

import java.util.List;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.Acesso;
import entity.PessoaFisica;
import persistence.LoginDao;

public class LoginController extends AbstractController {

	@Override
	public void execute() {

		try {
			String tipoAcesso = this.getRequest().getParameter("tipoAcesso");
			String ra = this.getRequest().getParameter("ra");
			String senha = this.getRequest().getParameter("senha");
			LoginDao ld = new LoginDao();
			
			List<PessoaFisica> pessoas = ld.autenticar(ra, senha, tipoAcesso);
			if (pessoas != null) { // se tem usuários!
				for(PessoaFisica pf : pessoas){
					if(pf.getAcesso().getTipoAcesso().equals(tipoAcesso)){
						if(pf.getAcesso().getLogin().equals(ra)){
							if(pf.getAcesso().getSenha().equals(senha)){
								Acesso ac = pf.getAcesso();
								HttpSession session = this.getRequest().getSession();
								session.setAttribute("acesso", ac);
								this.setReturnPage("/homeProfessor.jsp");
								this.getRequest().setAttribute("acesso", ac);
								break;
							}
						}
					}
				}
				
			} else {
				throw new Exception("Acesso Negado. Tente novamente.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
