package controller.implement;

import java.util.List;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.DisciplinaHorario;
import entity.PessoaFisica;
import persistence.PessoaFisicaDao;
import utils.ValidaPeriodo;

public class LoginController extends AbstractController {

	@Override
	public void execute() {
		try {
			String tipo_acesso = this.getRequest().getParameter("tipoAcesso");
			if (tipo_acesso.equals("professor")) {
				LoginProfessor();
			} else if (tipo_acesso.equals("aluno")) {
				LoginAluno();
			}else{
				throw new Exception("Tipo indefinido. Tente novamente.");
			}
		} catch (Exception e) {
			this.setReturnPage("/login.jsp");
			this.getRequest().setAttribute("msg", e.getMessage());
		}
	}

	public void LoginAluno() throws Exception{

		String tipo_acesso = this.getRequest().getParameter("tipoAcesso");
		String ra = this.getRequest().getParameter("ra");
		String senha = this.getRequest().getParameter("senha");

		PessoaFisicaDao pdf = new PessoaFisicaDao();

		PessoaFisica pf = pdf.autenticar(Integer.parseInt(ra), senha, tipo_acesso);

		if (pf != null) {
			HttpSession session = this.getRequest().getSession();
			if (pf.getDisciplinaHorario() != null) {
				session.setAttribute("lista", pf.getDisciplinaHorario());
			}
			session.setAttribute("pf", pf); // gravando o objeto usuario em
											// sessão!

			this.setReturnPage("/homeAluno.jsp");

		} else {
			
			throw new Exception("Aluno não encontrado.");
		}

	}

	public void LoginProfessor() throws Exception {

		ValidaPeriodo vp = new ValidaPeriodo();

		String tipo_acesso = this.getRequest().getParameter("tipoAcesso");
		String ra = this.getRequest().getParameter("ra");
		String senha = this.getRequest().getParameter("senha");

		PessoaFisicaDao pdf = new PessoaFisicaDao();

		PessoaFisica pf = pdf.autenticar(Integer.parseInt(ra), senha, tipo_acesso);

		if (pf != null) {
			HttpSession session = this.getRequest().getSession();
			if (pf.getDisciplinaHorario() != null) {
				DisciplinaHorario dh = vp.validaDisciplinaPossivel(pf.getDisciplinaHorario());
				if (dh != null) {
					session.setAttribute("dhAgora", dh);
				} else {
					dh = vp.validaDisciplinaSemComeco(pf.getDisciplinaHorario());
					if (dh != null) {
						session.setAttribute("dhAgora", dh);
					}
				}
				List<DisciplinaHorario> listaDH = pf.getDisciplinaHorario();
				for (DisciplinaHorario discHor : listaDH) {
					if (discHor.getTurma().equals("TESTE")) {
						session.setAttribute("DHTESTE", discHor);
					}
				}

				session.setAttribute("lista", listaDH);
			}
			session.setAttribute("pf", pf); // gravando o objeto usuario em
											// sessão!
			this.setReturnPage("/homeProfessor.jsp");

		} else {
			
			throw new Exception("Professor não encontrado.");
		}

	}

}
