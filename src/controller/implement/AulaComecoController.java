package controller.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.Aula;
import entity.DisciplinaHorario;
import entity.PessoaFisica;
import persistence.AulaDao;
import persistence.DisciplinaHorarioDao;
import persistence.PessoaFisicaDao;

public class AulaComecoController extends AbstractController {

	public void execute() {
		try {

			insereAlunos();
			getProfessor();
			createAula();

			this.setReturnPage("/aula.jsp");

		} catch (Exception e) {
			this.setReturnPage("/homeProfessor.jsp");
			this.getRequest().setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}

	}

	public void insereAlunos() throws Exception {

		HttpSession session = this.getRequest().getSession();

		// ID DA DH SELECIONADA
		String idAulaDH = this.getRequest().getParameter("dhagoraid");

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
						break;
					} else {
						throw new Exception("Alunos não encontrados, tente novamente.");
					}
				} else {
					throw new Exception("Alunos não encontrados, tente novamente.");
				}
			} else {
				throw new Exception("Aula não encontrada.");
			}
		}

	}

	public void getProfessor() throws Exception {
		HttpSession session = this.getRequest().getSession();

		// ID DA PF LOGADA
		String idProfessor = this.getRequest().getParameter("pflogada");

		// BUSCA PF
		PessoaFisicaDao pfd = new PessoaFisicaDao();
		PessoaFisica pf = pfd.listaPorId(Integer.parseInt(idProfessor));

		if (pf != null) {
			session.setAttribute("pf", pf);
		} else {
			throw new Exception("Professor não encontrada.");
		}

	}

	public void createAula() throws Exception {
		HttpSession session = this.getRequest().getSession();

		// ID DA PF LOGADA
		String idProfessor = this.getRequest().getParameter("pflogada");
		// ID DA DH SELECIONADA
		String idAulaDH = this.getRequest().getParameter("dhagoraid");
		session.setAttribute("idDh", idAulaDH);
		// Dia hoje
		Date dataInicio = new Date();
		dataInicio.setHours(0);
		dataInicio.setMinutes(0);
		dataInicio.setSeconds(0);

		System.out.println();

		AulaDao ad = new AulaDao();
		List<Aula> listaAula = ad.achaAulaHoje(Integer.parseInt(idProfessor), Integer.parseInt(idAulaDH));
		//VARIÁVEL PARA CONTROLAR AULA JA INICIADA
		boolean novaAula = true;

		if (listaAula != null && listaAula.size() > 0) {
			for (Aula au : listaAula) {
				if (dataInicio.before(au.getData()) && au.getData().before(new Date())) {
					session.setAttribute("idAula", au.getId());
					novaAula = false;
				}
			}
		}

		if (novaAula) {
			PessoaFisicaDao pfd = new PessoaFisicaDao();
			PessoaFisica pf = pfd.listaPorId(Integer.parseInt(idProfessor));

			DisciplinaHorarioDao dhd = new DisciplinaHorarioDao();
			List<DisciplinaHorario> listaDH = dhd.listaPorId(Integer.parseInt(idAulaDH));

			String salaReal = this.getRequest().getParameter("sala");
			String predioReal = this.getRequest().getParameter("predio");

			Aula aula = new Aula();
			aula.setData(new Date());
			aula.setPredioReal(Integer.parseInt(predioReal));
			aula.setSalaReal(Integer.parseInt(salaReal));
			aula.setDisciplinaHorario(listaDH.get(0));
			aula.setProfessor(pf);

			int idAulaSaved = ad.save(aula);
			session.setAttribute("idAula", idAulaSaved);
		}

	}

}
