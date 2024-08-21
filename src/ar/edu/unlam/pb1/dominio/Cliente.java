package ar.edu.unlam.pb1.dominio;

public class Cliente {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String correo;
	private Decodificador deco;
	
	public Cliente() {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.deco = deco;
	}

	public Decodificador getDeco() {
		return deco;
	}

	public void setDeco(Decodificador deco) {
		this.deco = deco;
	}
	
	
}
