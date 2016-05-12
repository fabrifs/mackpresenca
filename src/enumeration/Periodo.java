package enumeration;

import java.util.Calendar;

public enum Periodo {

	PRIMEIRO(1), SEGUNDO(2), TERCEIRO(3), QUARTO(4), QUINTO(5), SEXTO(6), SETIMO(7), OITAVO(8), NONO(9);

	private int periodo;

	private Periodo(int periodo) {
		this.periodo = periodo;
	}

	public int toInt() {
		return this.periodo;
	}

	public Calendar iniciarComeca() {
		Calendar inicio = Calendar.getInstance();
		if (periodo == 1) {
			inicio.set(Calendar.HOUR_OF_DAY, 7);
			inicio.set(Calendar.MINUTE, 25);
		} else if (periodo == 2) {
			inicio.set(Calendar.HOUR_OF_DAY, 8);
			inicio.set(Calendar.MINUTE, 55);
		} else if (periodo == 3) {
			inicio.set(Calendar.HOUR_OF_DAY, 10);
			inicio.set(Calendar.MINUTE, 25);
		} else if (periodo == 4) {
			inicio.set(Calendar.HOUR_OF_DAY, 12);
			inicio.set(Calendar.MINUTE, 55);
		} else if (periodo == 5) {
			inicio.set(Calendar.HOUR_OF_DAY, 14);
			inicio.set(Calendar.MINUTE, 25);
		} else if (periodo == 6) {
			inicio.set(Calendar.HOUR_OF_DAY, 15);
			inicio.set(Calendar.MINUTE, 55);
		} else if (periodo == 7) {
			inicio.set(Calendar.HOUR_OF_DAY, 18);
			inicio.set(Calendar.MINUTE, 25);
		} else if (periodo == 8) {
			inicio.set(Calendar.HOUR_OF_DAY, 19);
			inicio.set(Calendar.MINUTE, 55);
		} else if (periodo == 9) {
			inicio.set(Calendar.HOUR_OF_DAY, 21);
			inicio.set(Calendar.MINUTE, 25);
		}  else {
			inicio = null;
		}
		return inicio;
	}

	public Calendar finalizarComeca() {
		Calendar inicio = Calendar.getInstance();
		if (periodo == 1) {
			inicio.set(Calendar.HOUR_OF_DAY, 7);
			inicio.set(Calendar.MINUTE, 45);
		} else if (periodo == 2) {
			inicio.set(Calendar.HOUR_OF_DAY, 9);
			inicio.set(Calendar.MINUTE, 15);
		} else if (periodo == 3) {
			inicio.set(Calendar.HOUR_OF_DAY, 10);
			inicio.set(Calendar.MINUTE, 45);
		} else if (periodo == 4) {
			inicio.set(Calendar.HOUR_OF_DAY, 13);
			inicio.set(Calendar.MINUTE, 15);
		} else if (periodo == 5) {
			inicio.set(Calendar.HOUR_OF_DAY, 14);
			inicio.set(Calendar.MINUTE, 45);
		} else if (periodo == 6) {
			inicio.set(Calendar.HOUR_OF_DAY, 16);
			inicio.set(Calendar.MINUTE, 15);
		} else if (periodo == 7) {
			inicio.set(Calendar.HOUR_OF_DAY, 18);
			inicio.set(Calendar.MINUTE, 45);
		} else if (periodo == 8) {
			inicio.set(Calendar.HOUR_OF_DAY, 20);
			inicio.set(Calendar.MINUTE, 15);
		} else if (periodo == 9) {
			inicio.set(Calendar.HOUR_OF_DAY, 21);
			inicio.set(Calendar.MINUTE, 45);
		}  else {
			inicio = null;
		}
		return inicio;
	}

	public Calendar finalizarFinaliza() {
		Calendar fim = Calendar.getInstance();
		if (periodo == 1) {
			fim.set(Calendar.HOUR_OF_DAY, 9);
			fim.set(Calendar.MINUTE, 15);
		} else if (periodo == 2) {
			fim.set(Calendar.HOUR_OF_DAY, 10);
			fim.set(Calendar.MINUTE, 45);
		} else if (periodo == 3) {
			fim.set(Calendar.HOUR_OF_DAY, 12);
			fim.set(Calendar.MINUTE, 15);
		} else if (periodo == 4) {
			fim.set(Calendar.HOUR_OF_DAY, 14);
			fim.set(Calendar.MINUTE, 45);
		} else if (periodo == 5) {
			fim.set(Calendar.HOUR_OF_DAY, 16);
			fim.set(Calendar.MINUTE, 15);
		} else if (periodo == 6) {
			fim.set(Calendar.HOUR_OF_DAY, 17);
			fim.set(Calendar.MINUTE, 45);
		} else if (periodo == 7) {
			fim.set(Calendar.HOUR_OF_DAY, 20);
			fim.set(Calendar.MINUTE, 15);
		} else if (periodo == 8) {
			fim.set(Calendar.HOUR_OF_DAY, 21);
			fim.set(Calendar.MINUTE, 45);
		} else if (periodo == 9) {
			fim.set(Calendar.HOUR_OF_DAY, 23);
			fim.set(Calendar.MINUTE, 15);
		}  else {
			fim = null;
		}
		return fim;
	}

}
