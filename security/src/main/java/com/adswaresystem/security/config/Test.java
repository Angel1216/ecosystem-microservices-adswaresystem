package com.adswaresystem.security.config;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
//		 
//        System.out.println(objDate); 
//        String strDateFormat = "hh:mm:ss'T'dd-MMM-aaaa"; // El formato de fecha está especificado  
//        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
//        System.out.println(objSDF.format(objDate)); // El formato de fecha se aplica a la fecha actual
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d = sdf.parse(sdf.toString());
//		String formattedTime = output.format(d);
		
		
//		String DATE_FORMAT_I = "yyyy-MM-dd'T'HH:mm:ss";
//		String DATE_FORMAT_O = "yyyy-MM-dd";
//
//
//		SimpleDateFormat formatInput = new SimpleDateFormat(DATE_FORMAT_I);
//		SimpleDateFormat formatOutput = new SimpleDateFormat(DATE_FORMAT_O);
//
//		Date date = formatInput.parse(member.getString("date"));
//		String dateString = formatOutput.format(date);
		
		
//		String date = "2009-07-16T19:20:30-05:00";
//		String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
//		DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
//		DateTime dateTime = dtf.parseDateTime(date);
//		System.out.println(dateTime); // 2009-07-16T19:20:30-05:00
		
		
		
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//	    System.out.println(f.format(new Date()));
//	    
//	    
//	    syso
	    
		System.out.println(new Test().getFecha());

	}
	
	public ZonedDateTime getFecha() {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    fecha.format(new Date());

	    ZoneId timeZone = ZoneId.systemDefault();
	    ZonedDateTime zonedDateTime = LocalDateTime.parse(fecha.format(new Date()), 
	      DateTimeFormatter.ISO_DATE_TIME).atZone(timeZone);
	    
	    return zonedDateTime;
	}

}
