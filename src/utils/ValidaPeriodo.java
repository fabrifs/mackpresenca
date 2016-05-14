package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import entity.DisciplinaHorario;

public class ValidaPeriodo {

	public DisciplinaHorario validaDisciplinaPossivel(List<DisciplinaHorario> listaDh) {
		Calendar cal = new GregorianCalendar();
		for (DisciplinaHorario dh : listaDh) {
			if (dh.getDiaSemana().toInt() == cal.getTime().getDay()) {
				if (validaPeriodo(dh)) {
					return dh;
				}
			}
		}
		return null;
	}

	public boolean validaPeriodo(DisciplinaHorario dh) {
		boolean valida = false;

		Calendar inicio = dh.getPeriodo().iniciarComeca();
		Calendar fim = dh.getPeriodo().finalizarComeca();

		Calendar agora = Calendar.getInstance();

		if (inicio.before(agora) && fim.after(agora)) {
			valida = true;
		}

		return valida;
	}
	
	public DisciplinaHorario validaDisciplinaSemComeco(List<DisciplinaHorario> listaDh) {
		Calendar cal = new GregorianCalendar();
		for (DisciplinaHorario dh : listaDh) {
			if (dh.getDiaSemana().toInt() == cal.getTime().getDay()) {
				if (validaPeriodoSemComeco(dh)) {
					return dh;
				}
			}
		}
		return null;
	}
	
	public boolean validaPeriodoSemComeco(DisciplinaHorario dh) {
		boolean valida = false;

		Calendar inicio = dh.getPeriodo().iniciarComeca();
		Calendar fim = dh.getPeriodo().finalizarFinaliza();
				
		Calendar agora = Calendar.getInstance();

		if (inicio.before(agora) && fim.after(agora)) {
			valida = true;
		}

		return valida;
	}


}