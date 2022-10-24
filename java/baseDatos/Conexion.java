package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	public static Connection getConexion(String nombre) {
		Connection con=null; 
		final String URL="jdbc:mysql://localhost/"+nombre;
		final String USER="root";
		final String PASS="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("classforname");
			e1.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(URL,USER,PASS);
		} catch (SQLException e) {
			System.out.println("no me pude conectar");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public static void close(PreparedStatement con) {
		try {
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public static void close(ResultSet con) {
		try {
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
}
