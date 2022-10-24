package interfaces;

import javax.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	
	public static String saveFile(Part part,File pathUploads){// recibe un File(ruta)
		String fileName="";
	try{  
	  Path path=Paths.get(part.getSubmittedFileName());//nombre del archivo q suben
	  //pero part,getsub... ya retorna el nombre del archivo, ej: 3.jpg
	  fileName=path.getFileName().toString(); // el nombre del archivo q suben
	InputStream input=part.getInputStream();// el input va atener la imagen

	if(input!=null){
	File file=new File(pathUploads, fileName); //
	Files.copy(input,file.toPath());
	}
	}catch(Exception e){
	  e.printStackTrace();
	}
	
	//return (srcImg+fileName);//file name es... el nombre del archivo que suben 
	return(fileName);
	}
	
	
	static boolean isExtension(String fileName, String[] extensions) {
		for(String et : extensions) {
			if(fileName.toLowerCase().endsWith(et)) {
				return true;
			}
		}
		
		return false;
	}
	
	
}
