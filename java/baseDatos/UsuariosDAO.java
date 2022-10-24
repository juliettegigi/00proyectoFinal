package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuariosDAO {

	private final static String BASE_DATO="trekkingweb";
	private final static String USUARIOS_TABLA="usuarios";

	public static  Usuario buscarID(String user) {
		
		Usuario usuario=null;
		try {
		Connection con=Conexion.getConexion(BASE_DATO);		
		String sql="Select * from usuarios where usuario=?";	
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user);
		
		ResultSet resultado=ps.executeQuery();
	
		
		if(resultado.next()) {
			
			usuario=new Usuario(); 
			usuario.setUsuario(resultado.getString("usuario"));
			usuario.setPass(resultado.getString("clave"));
		 
			}
		ps.close();
		}
		catch(Exception e) {
			System.out.println("Problema baseDato");
		}
		
			
		
		return usuario;
	}
	
	
	public static boolean insertar(Usuario elemento) {
		try {
		Connection con=Conexion.getConexion(BASE_DATO);
		String sql="insert into usuarios values(?,?)";
		           
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, elemento.getUsuario());
		ps.setString(2,elemento.getPass());
		
		ps.execute();
	
		System.out.println(elemento.getUsuario());
		System.out.println(elemento.getPass());
		ps.close();
		return true;

		}
		catch(Exception e) {
			System.out.println("Problema al insertar");
		}
		return false;
		
	}
	
	
	public static  boolean eliminar(Usuario elemento) {
		try {
			Connection con=Conexion.getConexion(BASE_DATO);
			String sql="delete from "+USUARIOS_TABLA+" where usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, elemento.getUsuario());
			
			ps.execute();
			
			ps.close();
			return true;

			}
			catch(Exception e) {
				//System.out.println("Problema al insertar");
			}
			return false;
	
	}
	public static boolean actualizar(Usuario elemento) {
		
		try {
			Connection con=Conexion.getConexion(BASE_DATO);
			String sql="update "+USUARIOS_TABLA+" set usuario=?, clave=? where usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, elemento.getUsuario());
			ps.setString(2, elemento.getPass());
			ps.setString(3, elemento.getUsuario());
			ps.execute();
			
			ps.close();
			return true;

			}
			catch(Exception e) {
				//System.out.println("Problema al insertar");
			}
			return false;
		
	}
	
	public  static List<Usuario> listar(){
		List<Usuario> listaIniciarSesion=new ArrayList<Usuario>();
		
		
		try {
		Connection con=Conexion.getConexion(BASE_DATO);
		
		String sql="Select * from ".concat(USUARIOS_TABLA) ;
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet resultado=ps.executeQuery(sql);
		if(resultado.next()) {
			Usuario usuario=new Usuario();
			usuario.setUsuario(resultado.getString("usuario"));
			usuario.setPass(resultado.getString("clave"));
			listaIniciarSesion.add(usuario);
			}
		ps.close();
		}
		catch(Exception e) {
			System.out.println("Problema baseDato");
		}
		
			
		
		return listaIniciarSesion;
	}
	
	
}
