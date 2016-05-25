package utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args){
		
		Date data = new Date();
		data.setHours(0);
		data.setMinutes(0);
		data.setSeconds(0);

		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Date depois: " + sdf.format(data));

		Time time = new Time(1);
		System.out.println(time.getHours());
		

	}

}
