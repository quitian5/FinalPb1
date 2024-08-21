package ar.edu.unlam.pb1.dominio;

public class CompaniaDeTelevision {
	private Decodificador decodificador;
	private Cliente cliente;
	private Canal[] canales;

	public CompaniaDeTelevision() {

		this.canales = new Canal[20];
		this.inicializarCanales();
	}

	public Canal[] getCanales() {
		return canales;
	}

	 public boolean  asignarDecoAlCliente(Decodificador deco,Cliente cliente) {
		 boolean asignado = false;
		 cliente.setDeco(deco);
		 asignado = true;
		 return asignado;
	 }
	public boolean agregarCanal(int numero,Decodificador deco) {
		boolean agregado = false;
		int i=0;
		while(i<this.canales.length) {
			if(this.canales[i]!=null&&this.canales[i].getNumero()==numero&&!agregado) {
				Canal canalConNro = getCanalPorNumero(numero);
				if(canalConNro!=null) {
					if(deco.agregarAlDeco(canalConNro)) {
						agregado = true;
					}
					
				}
			}
			
			i++;
		}
		
		return agregado;
	}
	
	
	public Canal getCanalPorNumero(int numero) {
		Canal canalConNro = null;
		int i = 0;
		while(i<this.canales.length) {
			if(this.canales[i]!=null&&this.canales[i].getNumero()==numero) {
				canalConNro = this.canales[i];
				
			}
			
			i++;
		}
		
		
		return canalConNro;
	}
	
	
	
	public String generarContrasenia() {
		String contrasenia = "";
        char num = obtenerCaracterAleatorio(48,57);
		contrasenia += num;
		char mayus  = obtenerCaracterAleatorio(65,90);
		contrasenia += mayus;
		char minus  = obtenerCaracterAleatorio(97,122);
		contrasenia += minus;
		char minus2 = obtenerCaracterAleatorio(97,122);
		contrasenia += minus2;
		return contrasenia;
	}

	private char obtenerCaracterAleatorio(int posicionInicial, int posicionFinal) {
		char aleatorio = (char) ((int) (Math.random() * (posicionFinal - posicionInicial) + posicionInicial));

		return aleatorio;
	}

	private Canal crearCanal(int numero, String nombre, TipoDeCanal tipoDeCanal, boolean habilitado) {

		return new Canal(numero, nombre, tipoDeCanal, habilitado);
	}

	private void inicializarCanales() {
		for (int i = 0; i < 5; i++) {
			if (this.canales[i] == null) {
				this.canales[i] = crearCanal((i + 1), "Noticias " + (i + 1), TipoDeCanal.NOTICIAS, true);
			}
		}
		for (int i = 5; i < 10; i++) {
			if (this.canales[i] == null) {
				this.canales[i] = crearCanal((i + 1), "Infantil " + (i + 1), TipoDeCanal.INFATIL, true);
			}
		}
		for (int i = 10; i < 15; i++) {
			if (this.canales[i] == null) {
				this.canales[i] = crearCanal((i + 1), "Deportes " + (i + 1), TipoDeCanal.DEPORTES, true);
			}
		}
		for (int i = 15; i < 20; i++) {
			if (this.canales[i] == null) {
				this.canales[i] = crearCanal((i + 1), "Varios " + (i + 1), TipoDeCanal.VARIOS, true);
			}
		}
	}

}
