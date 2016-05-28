package utils;

import java.util.Calendar;
import java.util.Date;

public class Convert {

	public Date convertString(String data) {
		Calendar cal = Calendar.getInstance();


		int ano = Integer.parseInt(data.substring(0, 4));
		int mes = Integer.parseInt(data.substring(5, 7));
		int dia = Integer.parseInt(data.substring(8, 10));

		cal.set(ano, mes - 1, dia, 0, 0, 0);
		Date date = new Date();
		date.setTime(cal.getTimeInMillis());

		return date;

	}

}
