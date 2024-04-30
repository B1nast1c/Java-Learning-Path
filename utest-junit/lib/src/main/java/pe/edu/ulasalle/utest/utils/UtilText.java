package pe.edu.ulasalle.utest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilText {

	private static final String formato = "yyyy/MM/dd";

	private SenderEmail senderEmail;
	
	private SenderSms senderSms;
	
	private ReaderProperties readerProps;
	
	public UtilText() {
		senderEmail = new SenderEmail();
		senderSms = new SenderSms();
		readerProps = new ReaderProperties();
	}
	
	public String encriptar(String texto) {
		System.out.println("UtilText-encriptar");
		System.out.println("encriptar aun no implementado");
		return null;
	}
	
	public boolean enviarEmail(String email, String texto) {
		System.out.println("UtilText-enviarEmail");
		return senderEmail.sendEmail(email, texto);
	}
	
	public boolean enviarSms(String numero, String texto) {
		System.out.println("UtilText-enviarSms");
		return senderSms.sendSms(numero, texto);
	}
	
	public String leerPropiedad(String archivo, String propiedad) {
		System.out.println("UtilText-leerPropiedad");
		return readerProps.readProp(archivo, propiedad);
	}
	
	public Date aDate(String dateStr, int hora, int minuto) {
		if (hora >= 0 && hora <=23 && minuto >= 0 && minuto <= 59) {
			return aCalendar(dateStr, formato, hora, minuto).getTime();
		}
		return null; 
	}
	
	public Calendar aCalendar(String dateStr, String formato, int horaDelDia, int minuto) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		Date d = null;
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	    Calendar cal = Calendar.getInstance();
	    cal.setTimeInMillis(d.getTime());
	    cal.set(Calendar.HOUR_OF_DAY, horaDelDia);
	    cal.set(Calendar.MINUTE, minuto);
	    return cal;
	}
	
}
