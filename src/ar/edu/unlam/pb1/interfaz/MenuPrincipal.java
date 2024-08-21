package ar.edu.unlam.pb1.interfaz;

public enum MenuPrincipal {
	
	AGREGAR_CANAL_AL_DECO(" Agregar canal al decodificador"),
	HABILITAR_DESABILITAR("Habilitar o deshabilitar un canal para el decodificador."),
	 ASIGNAR_CLIENTE_AL_DECO("Asignar un cliente al decodificador."),
	 MOSTRAR_CANAL_MAYOR_POR_TIPO("Mostrar el canal cuyo número de canal sea el máximo para un tipo de canal"),
	 MOSTRAR_CANALES_DISPONIBLES("Mostrar todos los canales disponibles (habilitados) en un decodificador."),
	 MOSTRAR_CANALES_ORDENADOS_POR_NOMBRE("Mostrar los canales ordenados nombre de canal."),
	 SALIR("Salir");
	 
	 private String descripcion;
	 MenuPrincipal(String descripcion)  {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
    
}
