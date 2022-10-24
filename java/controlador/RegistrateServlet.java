package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseDatos.UsuariosDAO;
import modelo.Usuario;

/**
 * Servlet implementation class RegistrateServlet
 */
public class RegistrateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u;
		String m="";
		u=UsuariosDAO.buscarID(request.getParameter("user"));
	    if(u!=null) {
	    	m="Ese usuario ya existe";
	    	request.setAttribute("mensaje", m);	
	    	request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
	    }
	    	
	    else {
	    	u=new Usuario(request.getParameter("user"),request.getParameter("pass"));
	    	UsuariosDAO.insertar(u);
	   	 request.setAttribute("mensaje","usuario creado, ahora podés ingresar" );	    		 
    	 request.getRequestDispatcher("index.jsp").forward(request, response);
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
