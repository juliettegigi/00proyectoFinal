package modelo;

public class Usuario {

	String user;
	String pass;
	
	
	public Usuario() {
		super();
		
	}
	public Usuario(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public String getUsuario() {
		return user;
	}
	public void setUsuario(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Usuario [user=" + user + ", pass=" + pass + "]";
	}
	
	
	
	
}
