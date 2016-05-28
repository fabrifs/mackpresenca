package controller.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.Aula;
import entity.Disciplina;
import entity.DisciplinaHorario;
import entity.PessoaFisica;
import persistence.AulaDao;
import persistence.PessoaFisicaDao;
import utils.Convert;

public class ListarAulaController extends AbstractController {

	PessoaFisica pessoa = new PessoaFisica();

	public void execute() {

		try {
			String operacao = this.getRequest().getParameter("operacao");

			if (operacao.equals("listarDisciplina")) {
				listaDisciplina();
				this.setReturnPage("/historicoAula.jsp");
			} else if (operacao.equals("listarAula")) {
				listaDisciplina();
				listarAula();
				this.setReturnPage("/historicoAula.jsp");
			}

		} catch (Exception e) {
			String tipoAcesso = this.getRequest().getParameter("tipoAcesso");
			this.getRequest().setAttribute("msg", e.getMessage());
			if (tipoAcesso.equals("aluno")) {
				this.setReturnPage("/homeAluno.jsp");
			} else if (tipoAcesso.equals("professor")) {
				this.setReturnPage("/homeProfessor.jsp");
			} else {
				this.setReturnPage("/login.jsp");
			}
		}

	}

	public void listarAula() throws Exception {
		int idPf = Integer.parseInt(this.getRequest().getParameter("idPf"));
		PessoaFisicaDao pfd = new PessoaFisicaDao();
		this.pessoa = pfd.listaPorIdComDh(idPf);

		String idDisciplinaSt = this.getRequest().getParameter("idDisciplina");
		List<DisciplinaHorario> listaDh = new ArrayList<>();

		if (idDisciplinaSt != null && !idDisciplinaSt.equals("DEFAULT")) {
			int idDisciplina = Integer.parseInt(idDisciplinaSt);
			for (DisciplinaHorario dh : this.pessoa.getDisciplinaHorario()) {
				if (!listaDh.contains(dh) && dh.getDisciplina().getId() == idDisciplina) {
					listaDh.add(dh);
				}
			}
			if (listaDh.size() > 0) {
				buscaAulas(listaDh);
			}

		} else {
			for (DisciplinaHorario dh : this.pessoa.getDisciplinaHorario()) {
				if (!listaDh.contains(dh)) {
					listaDh.add(dh);
				}
			}
			if (listaDh.size() > 0) {
				buscaAulas(listaDh);
			}
		}
	}

	public void buscaAulas(List<DisciplinaHorario> listaDh) throws Exception {
		AulaDao ad = new AulaDao();

		String dataInicio = this.getRequest().getParameter("dataInicio");
		String dataFim = this.getRequest().getParameter("dataFim");
		Convert convert = new Convert();
		Date dateInicio = convert.convertString(dataInicio);
		Date dateFim = convert.convertString(dataFim);

		List<Aula> aulas = new ArrayList<>();
		for (DisciplinaHorario dh : listaDh) {
			List<Aula> aulaTemporaria = ad.achaAulaPorDataDis(dateInicio, dateFim, dh.getId());
			if (aulaTemporaria != null && aulaTemporaria.size() > 0) {
				for (Aula au : aulaTemporaria) {
					if (!aulas.contains(au)) {
						aulas.add(au);
					}
				}
			}
		}
		
		if(aulas.size() > 0){
			HttpSession session = this.getRequest().getSession();
			session.setAttribute("aulas", aulas);
		}else{
			throw new Exception("Aula(s) não encontrada(s). Tente novamente.");
		}
	}

	public void listaDisciplina() throws Exception {
		int idPf = Integer.parseInt(this.getRequest().getParameter("idPf"));

		PessoaFisicaDao pfd = new PessoaFisicaDao();
		this.pessoa = pfd.listaPorIdComDh(idPf);

		List<Disciplina> disciplinas = new ArrayList<>();

		for (DisciplinaHorario dh : this.pessoa.getDisciplinaHorario()) {
			if (!disciplinas.contains(dh.getDisciplina())) {
				disciplinas.add(dh.getDisciplina());
			}
		}

		if (disciplinas != null && disciplinas.size() > 0) {
			HttpSession session = this.getRequest().getSession();
			session.setAttribute("disciplinas", disciplinas);
		} else {
			throw new Exception("Disciplinas não encontradas. Tente novamente.");
		}

	}
}
