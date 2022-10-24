package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import baseDatos.CerrosDAO;

/**
 * Servlet implementation class EditarServlet
 */
@MultipartConfig
@WebServlet
public class EditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFiles="C:\\xampp\\htdocs\\img\\";
	private String srcImg="http://localhost/img/";
	private File uploads=new File(pathFiles);
	private String[] extens={".png",".jpg"}; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        int id=(int) request.getSession().getAttribute("idEditar");
		
		Part part = request.getPart("file");
		if(!(part==null)) {
			if(isExtension(part.getSubmittedFileName(), extens)) {			
				
				String photo=saveFile(part,uploads);			
				CerrosDAO.update("img", photo, id);
				
				}
		}
		String fecha=request.getParameter("fecha");		
		CerrosDAO.update("fechaSubida", fecha, id);
		
		String descripcion=request.getParameter("descripcion");
		
		descripcion=descripcion.replace("\n", "<br>");
		if(descripcion.equals("")) {
			descripcion=(String) request.getSession().getAttribute("descripcion");
			descripcion=descripcion.replace("\n", "<br>");
		}
			CerrosDAO.update("titulo",request.getParameter("titulo"), id);
		CerrosDAO.update("descripcion", descripcion, id);
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String saveFile(Part part,File pathUploads){
		String fileName="";
	try{
	  Path path=Paths.get(part.getSubmittedFileName());
	  fileName=path.getFileName().toString();
	  System.out.println(fileName);
	InputStream input=part.getInputStream();

	if(input!=null){
	File file=new File(pathUploads, fileName);
	Files.copy(input,file.toPath());
	}
	}catch(Exception e){
	  e.printStackTrace();
	}
	
	return (srcImg+fileName);
	}
	
	private boolean isExtension(String fileName, String[] extensions) {
		for(String et : extensions) {
			if(fileName.toLowerCase().endsWith(et)) {
				return true;
			}
		}
		
		return false;
	}
	

}
