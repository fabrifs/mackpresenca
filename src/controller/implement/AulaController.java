package controller.implement;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.DisciplinaHorario;
import entity.PessoaFisica;
import persistence.DisciplinaHorarioDao;
import persistence.PessoaFisicaDao;

public class AulaController extends AbstractController {

	public void execute() {
		try {
			// ID DA DH SELECIONADA
			String idAulaDH = this.getRequest().getParameter("dhagoraid");

			// ID DA PF LOGADA
			String idProfessor = this.getRequest().getParameter("pflogada");

			insereAlunos();
			getProfessor(Integer.parseInt(idProfessor));

		} catch (Exception e) {
			this.setReturnPage("/login.jsp");
			this.getRequest().setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}

	}

	public void insereAlunos() throws Exception {

		HttpSession session = this.getRequest().getSession();

		// ID DA DH SELECIONADA
		String idAulaDH = this.getRequest().getParameter("dhagoraid");

		// ID DA PF LOGADA
		String idPF = this.getRequest().getParameter("pflogada");

		DisciplinaHorarioDao dhd = new DisciplinaHorarioDao();
		List<DisciplinaHorario> listaDh = dhd.listaPorId(Integer.parseInt(idAulaDH));

		for (DisciplinaHorario dh : listaDh) {
			if (dh != null) {
				// VALIDA SE TEM ALUNOS
				if (dh.getPessoaFisica() != null && dh.getPessoaFisica().size() > 0) {
					// REMOVE O PROFESSOR
					List<PessoaFisica> alunos = new ArrayList<>();
					for (PessoaFisica pf : dh.getPessoaFisica()) {
						if (!pf.getTipo_acesso().equals("professor")) {
							alunos.add(pf);
						}
					}
					if (alunos.size() > 0) {
						session.setAttribute("alunos", alunos);
						this.setReturnPage("/aula.jsp");
						break;
					} else {
						this.setReturnPage("/login.jsp");
						throw new Exception("Alunos não encontrados, tente novamente.");
					}
				} else {
					this.setReturnPage("/login.jsp");
					throw new Exception("Alunos não encontrados, tente novamente.");
				}
			} else {
				this.setReturnPage("/login.jsp");
				throw new Exception("Aula não encontrada.");
			}
		}

	}

	public void getProfessor(int id) throws Exception {
		HttpSession session = this.getRequest().getSession();
		// BUSCA PF
		PessoaFisicaDao pfd = new PessoaFisicaDao();
		PessoaFisica pf = pfd.listaPorId(id);

		if (pf != null) {
			session.setAttribute("pf", pf);
		} else {
			this.setReturnPage("/login.jsp");
			throw new Exception("Professor não encontrada.");
		}

	}

}
