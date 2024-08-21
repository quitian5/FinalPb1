package ar.edu.unlam.pb1.dominio;



public class Canal {
	private int numero;
	private String nombre;
	private  TipoDeCanal tipoDeCanal;
	private boolean habilitado;
	 public Canal(int numero,String nombre,TipoDeCanal tipoDeCanal,boolean habilitado) {
		 this.numero = numero;
		 this.nombre = nombre;
		 this.tipoDeCanal = tipoDeCanal;
		 this.habilitado = habilitado; // ? 
		 
	 }
	 
	 
	 
	 
	public TipoDeCanal getTipoDeCanal() {
		return tipoDeCanal;
	}




	public void setTipoDeCanal(TipoDeCanal tipoDeCanal) {
		this.tipoDeCanal = tipoDeCanal;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public int getNumero() {
		return numero;
	}




	public void setNumero(int numero) {
		this.numero = numero;
	}




	public boolean isHabilitado() {
		return habilitado;
	}




	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}




	@Override
	public String toString() {
		return "Canal [numero=" + numero + ", nombre=" + nombre + ", tipoDeCanal=" + tipoDeCanal + ", habilitado="
				+ habilitado + "]";
	}
	 
	 
	 
	 
	 

}
