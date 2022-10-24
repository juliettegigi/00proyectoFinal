package baseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.Constantes;
import modelo.Cerro;

public class CerrosDAO {

	 private final static String BASE_DATO="trekkingWeb";
	 
		public static boolean insertar(Cerro c) {
			Connection con=Conexion.getConexion(BASE_DATO);
		    String sql="insert into cerros values(0,?,?,?,?,?)";
		    try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, c.getUsuario());
				ps.setString(2, c.getTitulo());
				ps.setString(3, c.getImg());
				ps.setString(4,c.getDescripcion());	
				
				//ps.setString(5,Constantes.FechaString(c.getFechaSubida()));
				ps.setDate(5,new java.sql.Date(c.getFechaSubida().getTime()));
				ps.execute();
			
			    Conexion.close(ps);
			    Conexion.close(con);
			    return true;
			} catch (SQLException e) {
			     System.out.println("en el catch de cerroDAOOOOOOOOOOOOOOOOO");
				e.printStackTrace();
				Conexion.close(con);
				return false;
			}
			
		}
		
		public static List<Cerro> listar(String usuario){
			List<Cerro> l=null;
			Connection con=Conexion.getConexion(BASE_DATO);
			String sql="select * from cerros where usuario=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, usuario);			
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					l=new ArrayList<Cerro>();
					do {
						Cerro c=new Cerro();
						c.setId(rs.getInt("id"));
						c.setUsuario(rs.getString("usuario"));
						c.setTitulo(rs.getString("titulo"));
						c.setDescripcion(rs.getString("descripcion"));
						c.setImg(rs.getString("img"));
			
						c.setFechaSubida(Constantes.StringFecha(rs.getString("fechaSubida"),Constantes.f1));
						l.add(c);
					}while(rs.next());
					
					
					Conexion.close(ps);
					Conexion.close(rs);
					Conexion.close(con);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Conexion.close(con);
			}
			return l;
		}
		
		
		public static boolean eliminar(int id) {
			Connection con=Conexion.getConexion(BASE_DATO);
			String sql="delete from cerros where id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				Conexion.close(ps);
				Conexion.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Conexion.close(con);
			}
			
			return true;
		}
		
		public static Cerro buscarPorId(int id) {
			Cerro c=null;
			Connection con=Conexion.getConexion(BASE_DATO);
			String sql="select * from cerros where id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
				   c=new Cerro();
				   c.setId(rs.getInt("id"));
				   c.setTitulo(rs.getString("titulo"));
				   c.setDescripcion(rs.getString("descripcion"));
				   c.setImg(rs.getString("img"));
				   c.setUsuario(rs.getString("usuario"));
				   c.setFechaSubida(rs.getDate("fechaSubida"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Conexion.close(con);
			}
			
			return c;
		}
		
		public static void update(String campo, String nuevoValor,int id) {
			Connection con=Conexion.getConexion(BASE_DATO);
			//String sql="update cerro set "+campo+"="+"'"+nuevoValor+"'"+"where id="+id;
			String sql="update cerros set "+campo+"="+"? where id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, nuevoValor);
					ps.setInt(2, id);
					ps.execute();
					Conexion.close(ps);
					Conexion.close(con);
				} catch (SQLException e) {
					System.out.println("en el catch de update");
					e.printStackTrace();
				}
			}
		
		
	}
