package interfaces;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Constantes {
	String RUTA_IMAGENES="C:\\xampp\\htdocs\\img\\";
	String SRC_IMG="http://localhost/img/";
	SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat f2=new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date StringFecha(String s, SimpleDateFormat f) {
		
		////1991-05-02
	
			
			Date date=null;
			try {
				date = f.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return date;
	}
	
	

	public static String FechaString(Date d,SimpleDateFormat f) {

	     return f.format(d);
	}
}
