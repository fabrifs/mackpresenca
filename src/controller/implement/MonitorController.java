package controller.implement;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.Disciplina;
import entity.DisciplinaHorario;
import entity.Monitor;
import enumeration.DiaSemana;
import persistence.DisciplinaDao;
import persistence.DisciplinaHorarioDao;
import persistence.MonitorDao;

public class MonitorController extends AbstractController {

	List<Disciplina> disciplinas = new ArrayList<>();
	List<Monitor> monitores = new ArrayList<>();


	MonitorDao md = new MonitorDao();

	public void execute() {
		try {
			String op = this.getRequest().getParameter("operacao");
			if (op.equals("listar")) {
				listarMonitor();
				this.setReturnPage("/monitoria.jsp");
			} else if (op.equals("excluir")) {
				excluirMonitor();
				listarMonitor();
				this.setReturnPage("/monitoria.jsp");
			}else if (op.equals("editarCarrega")) {
				carregaMonitor();
				this.setReturnPage("/editarMonitor.jsp");
			} else if (op.equals("alterar")) {
				alterarMonitor();
				this.setReturnPage("/monitoria.jsp");
			} else if (op.equals("incluir")) {
				incluir();
				listarMonitor();
				this.setReturnPage("/monitoria.jsp");
			} else {
				throw new Exception("Operação não reconhecida. Tente novamente.");
			}
		} catch (Exception e) {
			String tipoAcesso = this.getRequest().getParameter("tipoAcesso");
			this.getRequest().setAttribute("msg", e.getMessage());
			e.printStackTrace();
			if (tipoAcesso.equals("aluno")) {
				this.setReturnPage("/homeAluno.jsp");
			} else if (tipoAcesso.equals("professor")) {
				this.setReturnPage("/homeProfessor.jsp");
			} else {
				this.setReturnPage("/login.jsp");
			}
			
		}
	}

	public void incluir() throws Exception{
		int idDisciplina = Integer.parseInt(this.getRequest().getParameter("idDisciplina"));
		String nomeAluno = this.getRequest().getParameter("nomeMonitor");
		String diaSemana = this.getRequest().getParameter("diaSemana");
		String horario = this.getRequest().getParameter("horario");
		
		Monitor monitor = new Monitor();
		monitor.setNomeAluno(nomeAluno);
		
		DisciplinaDao dd = new DisciplinaDao();
		Disciplina disciplina = dd.listaPorId(idDisciplina);
		if(disciplina != null){
			monitor.setDisciplina(disciplina);
		}else{
			throw new Exception("Disciplina não encontrada. Tente novamente.");
		}
		if(diaSemana.equals("SEGUNDA")){
			monitor.setDia_semana(DiaSemana.SEGUNDA);
		}else if(diaSemana.equals("TERCA")){
			monitor.setDia_semana(DiaSemana.TERÇA);
		}else if(diaSemana.equals("QUARTA")){
			monitor.setDia_semana(DiaSemana.QUARTA);
		}else if(diaSemana.equals("QUINTA")){
			monitor.setDia_semana(DiaSemana.QUINTA);
		}else if(diaSemana.equals("SEXTA")){
			monitor.setDia_semana(DiaSemana.SEXTA);
		}else{
			throw new Exception("Dia da semana inválido. Tente novamente.");
		}
		monitor.setHorario(horario);
		
		MonitorDao md = new MonitorDao();
		md.save(monitor);
		
	}

	public void alterarMonitor() throws Exception {
		int idMonitor = Integer.parseInt(this.getRequest().getParameter("idMonitor"));
		Monitor monitor = md.listaPorId(idMonitor);
		if (monitor != null) {
			md.update(monitor);
		} else {
			throw new Exception("Monitor não encontrado. Tente novamente.");
		}
	}
	
	public void carregaMonitor() throws Exception {
		HttpSession session = this.getRequest().getSession();
		int idMonitor = Integer.parseInt(this.getRequest().getParameter("idMonitor"));
		Monitor monitor = md.listaPorId(idMonitor);
		if (monitor != null) {
			session.setAttribute("monitor", monitor);
		} else {
			throw new Exception("Monitor não encontrado. Tente novamente.");
		}
	}

	public void excluirMonitor() throws Exception {
		int idMonitor = Integer.parseInt(this.getRequest().getParameter("idMonitor"));
		Monitor monitor = md.listaPorId(idMonitor);
		if (monitor != null) {
			md.delete(monitor);
		} else {
			throw new Exception("Monitor não encontrado. Tente novamente.");
		}
	}

	public void listarMonitor() throws Exception {
		listaDH();
		selecionaMonitor();
		String tipoAcesso = this.getRequest().getParameter("tipoAcesso");
		if (tipoAcesso.equals("professor"))
			listaMonitorCoordenador();
		
	}

	public void listaDH() throws Exception {
		HttpSession session = this.getRequest().getSession();
		int idPf = Integer.parseInt(this.getRequest().getParameter("idPf"));

		DisciplinaHorarioDao dhd = new DisciplinaHorarioDao();
		List<DisciplinaHorario> listaDH = dhd.listaPorIdPf(idPf);
		for (DisciplinaHorario dh : listaDH) {
			this.disciplinas.add(dh.getDisciplina());
		}
		if(this.disciplinas.size() > 0 && this.disciplinas != null){
			session.setAttribute("disciplinas", this.disciplinas);
		}
	}

	public void selecionaMonitor() throws Exception {
		HttpSession session = this.getRequest().getSession();
		for (Disciplina dis : this.disciplinas) {
			List<Monitor> monitor = md.listaPorDisciplina(dis.getId());
			if (monitor.size() > 0 && monitor.get(0) != null) {
				this.monitores.add(monitor.get(0));
			}
		}
		if(this.monitores != null && this.monitores.size() > 0){
			session.setAttribute("monitorGeral", this.monitores);
		}else{
			throw new Exception("Monitor não encontrado. Tente novamente.");
		}
	}

	public void listaMonitorCoordenador() {
		HttpSession session = this.getRequest().getSession();
		session.setAttribute("professorValido", "valido");
		
		
		int idPf = Integer.parseInt(this.getRequest().getParameter("idPf"));
		List<Monitor> monitorCoord = new ArrayList<>();
		for (Monitor mor : this.monitores) {
			if (mor.getDisciplina().getProfessorCoordenador() == idPf) {
				monitorCoord.add(mor);
			}
		}
		if (monitorCoord.size() != 0) {
			session.setAttribute("monitorCoord", monitorCoord);
		}
	}
}
