package utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args){
		
		Calendar cal = Calendar.getInstance();
		
		
		
		String dataInicio = "1996-12-25";
		String dataFim = "2000-07-05";
		
		int ano = Integer.parseInt(dataInicio.substring(0, 4));
		int mes = Integer.parseInt(dataInicio.substring(5, 7));
		int dia = Integer.parseInt(dataInicio.substring(8, 10));
		System.out.println(ano + " " + mes +" " +  dia);
		
		cal.set(ano, mes-1, dia, 0, 0, 0);
		Date data = new Date();
		
		data.setTime(cal.getTimeInMillis());

		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Date depois: " + sdf.format(data));
		

	}

}
