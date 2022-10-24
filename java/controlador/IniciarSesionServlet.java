package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import baseDatos.UsuariosDAO;
import modelo.Usuario;

/**
 * Servlet implementation class IniciarSesionServlet
 */
@WebServlet
public class IniciarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	     Usuario user=UsuariosDAO.buscarID(request.getParameter("user"));	
	     
	  if(user==null){
	    	 String m="El usuario "+request.getParameter("user") +" no pertenece a nuestra base";
	    	 request.setAttribute("mensaje", m);	
	    	 request.getRequestDispatcher("index.jsp").forward(request, response);
	    	
	     }
	     else {
	    	 if(request.getParameter("pass").equals(user.getPass())) {
	    		 request.getSession().setAttribute("usuario", user); // guardo el nombre del usuario en la sesión
	    		 response.sendRedirect("home.jsp");
	          }
	    	 else {
	    		 request.setAttribute("mensaje","contraseña incorrecta" );	    		 
		    	 request.getRequestDispatcher("index.jsp").forward(request, response);
	    	 }
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
