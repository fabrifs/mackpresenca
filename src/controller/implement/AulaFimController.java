package controller.implement;

import java.util.Date;
import java.util.List;

import controllers.AbstractController;
import entity.Aula;
import entity.DisciplinaHorario;
import entity.PessoaFisica;
import entity.Presenca;
import persistence.AulaDao;
import persistence.DisciplinaHorarioDao;
import persistence.PessoaFisicaDao;
import persistence.PresencaDao;
import utils.EnviaEmail;

public class AulaFimController extends AbstractController {

	@Override
	public void execute() {
		try {
			daFalta();
			atualizaAula();
			enviaEmail();
			this.setReturnPage("/homeProfessor.jsp");
		} catch (Exception e) {
			this.setReturnPage("/homeProfessor.jsp");
			this.getRequest().setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}
	}

	public void atualizaAula() throws Exception {
		int idAula = Integer.parseInt(this.getRequest().getParameter("idAula"));

		String comentario = this.getRequest().getParameter("comentario");

		AulaDao ad = new AulaDao();
		Aula au = ad.findById(idAula);
		au.setAulaFinalizada(true);
		au.setComentario(comentario);

		ad.update(au);
	}
	
	public void enviaEmail() throws Exception{
		String comentario = this.getRequest().getParameter("comentario");
		String alunos[] = this.getRequest().getParameterValues("alunos_faltantes");
		int idDh = Integer.parseInt(this.getRequest().getParameter("idDh"));
		
		DisciplinaHorario dh = null;
		List<DisciplinaHorario> listaDh = new DisciplinaHorarioDao().listaPorId(idDh);
		if (listaDh.size() > 0) {
			dh = listaDh.get(0);
		} else {
			throw new Exception("Disciplina não encontrada. Tente novamente.");
		}
		
		for (int i = 0; alunos != null && i < alunos.length; i++) {
			PessoaFisicaDao pfd = new PessoaFisicaDao();
			PessoaFisica pf = pfd.listaPorId(Integer.parseInt(alunos[i]));
			EnviaEmail email = new EnviaEmail();
			email.enviarEmail("Aula dia:" + new Date() + " - Disciplina:" + dh.getDisciplina().getNomeDisciplina(), 
					"Sr(a)" + pf.getNome()+"\n"
							+ "\n"
							+ "Não registramos sua presença na aula do dia de hoje. Por tal, uma falta foi registrada.\n"
							+ "\n"
							+ "O conteúdo dado em aula foi:\n"
							+ "'" + comentario+"'\n"
							+ "\n"
							+ "Att,\n"
							+ "\n"
							+ "MackPresença.", 
							pf.getEmail());

		}
		
	}

	public void daFalta() throws Exception {
		int idDh = Integer.parseInt(this.getRequest().getParameter("idDh"));
		int idAula = Integer.parseInt(this.getRequest().getParameter("idAula"));
		if (aulaFinalizada()) {
			this.getRequest().setAttribute("msg", "Aula já havia sido finalizada.");
		} else {

			DisciplinaHorario dh = null;
			List<DisciplinaHorario> listaDh = new DisciplinaHorarioDao().listaPorId(idDh);
			if (listaDh.size() > 0) {
				dh = listaDh.get(0);
			} else {
				throw new Exception("Disciplina não encontrada. Tente novamente.");
			}

			PresencaDao pd = new PresencaDao();

			String alunos[] = this.getRequest().getParameterValues("alunos_faltantes");
			for (int i = 0; alunos != null && i < alunos.length; i++) {
				Presenca pres = new Presenca();
				pres.setIdAluno(Integer.parseInt(alunos[i]));
				pres.setIdAula(idAula);
				pres.setIdDisciplina(dh.getDisciplina().getId());
				pd.save(pres);

			}
		}
	}

	public boolean aulaFinalizada() {
		int idAula = Integer.parseInt(this.getRequest().getParameter("idAula"));
		AulaDao ad = new AulaDao();
		Aula aula = ad.findById(idAula);
		if(aula != null && aula.getAulaFinalizada() != null){
			return aula.getAulaFinalizada();
		}
		return false;
	}

}
