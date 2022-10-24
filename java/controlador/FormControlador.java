package controlador;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import baseDatos.CerrosDAO;
import interfaces.Constantes;
import modelo.Cerro;
import modelo.Usuario;

@MultipartConfig
@WebServlet//("/FormControlador")
public class FormControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFiles="C:\\xampp\\htdocs\\img\\";
	private String srcImg="http://localhost/img/";	
	//private String srcImg="C:\\xampp\\htdocs\\img\\";
	
	//private String pathFiles="C:\\Users\\julie\\eclipse-workspace\\00proyectoFinal\\src\\main\\webapp\\imagenesSubidas\\";
	private File uploads=new File(pathFiles);
	private String[] extens={".png",".jpg"};
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FormControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		
	
		Cerro cerro=null;
		
		    Usuario u=(Usuario)session.getAttribute("usuario");
            String titulo = request.getParameter("titulo");
			Part part = request.getPart("file");			
			String descripcion=request.getParameter("descripcion");
			descripcion=descripcion.replace("\n", "<br>");
			Date fecha=Constantes.StringFecha(request.getParameter("fecha"),Constantes.f1);
			if(Constantes.isExtension(part.getSubmittedFileName(), extens)) {			
				
					String photo=Constantes.saveFile(part,uploads);			
					
					 cerro=new Cerro(0,u.getUsuario(),titulo,photo,descripcion,fecha);
					CerrosDAO.insertar(cerro);
					}
					

				
		request.setAttribute("objetoCerro", cerro);
        request.getRequestDispatcher("home.jsp").forward(request,response);
	
	}
	




	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
