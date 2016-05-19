package controller.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import controllers.AbstractController;
import entity.Disciplina;
import entity.DisciplinaHorario;
import persistence.DisciplinaHorarioDao;
import persistence.PresencaDao;

public class VerificaFaltaController extends AbstractController{
	
	List<Disciplina> disciplinas = new ArrayList<>();
	
	public void execute(){
		
		try{
			listaDisciplinas();
			verificaFalta();
			this.setReturnPage("/faltasAluno.jsp");
			
		}catch(Exception e){
			this.setReturnPage("/homeAluno.jsp");
			this.getRequest().setAttribute("msg", e.getMessage());
		}
		
	}
	
	public void listaDisciplinas() throws Exception{
		int idAluno = Integer.parseInt(this.getRequest().getParameter("idAluno"));
		
		DisciplinaHorarioDao dhd = new DisciplinaHorarioDao();
		List<DisciplinaHorario> listaDh = dhd.listaPorIdPf(idAluno);
		for(DisciplinaHorario dh : listaDh){
			if(!disciplinas.contains(dh.getDisciplina())){
				disciplinas.add(dh.getDisciplina());
			}
		}
	}
	
	public void verificaFalta() throws Exception{
		int idAluno = Integer.parseInt(this.getRequest().getParameter("idAluno"));

		
		PresencaDao pd = new PresencaDao();
		
		Map<String, Integer> discFalta = new HashMap<>();
		
		for(Disciplina dis : disciplinas){
			int faltas = pd.listaFaltas(idAluno, dis.getId());			
			discFalta.put(dis.getNomeDisciplina(), faltas);
		}
		
		HttpSession session = this.getRequest().getSession();
		session.setAttribute("disciplinas", discFalta);
		
	}

}
