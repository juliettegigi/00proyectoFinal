package modelo;

import java.util.Date;

public class Cerro {
	
	private int id;
	private String usuario;
	private String titulo;
	private String img;
	private String descripcion;
	private Date fechaSubida;
	public Cerro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cerro(int id, String usuario, String titulo, String img, String descripcion, Date fechaSubida) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.img = img;
		this.descripcion = descripcion;
		this.fechaSubida = fechaSubida;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaSubida() {
		return fechaSubida;
	}
	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}
	
	
	@Override
	public String toString() {
		return "Cerro [id=" + id + ", usuario=" + usuario + ", titulo=" + titulo + ", img=" + img + ", descripcion="
				+ descripcion + ", fechaSubida=" + fechaSubida + "]";
	}
	
	

	

}
