package ar.edu.unlam.pb1.dominio;

public class Decodificador {
	private String contrasenia;
	private Canal[] canalesDeco;

	public Decodificador() {
		this.contrasenia = contrasenia;
		this.canalesDeco = new Canal[20]; // viene vacio y se le pueden cargar canales

	}

	public Canal[] getCanalesDeco() {
		return canalesDeco;
	}

	public void setCanalesDeco(Canal[] canalesDeco) {
		this.canalesDeco = canalesDeco;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;

	}

	public boolean agregarAlDeco(Canal canal) {
		boolean agregado = false;
		int i = 0;
		while (i < this.canalesDeco.length) {
			if (this.canalesDeco[i] == null && !agregado) {
				this.canalesDeco[i] = canal;
				agregado = true;
			}

			i++;
		}
		return agregado;
	}

	public boolean deshabilitarCanal(int nro) {
		boolean deshabilitado = false;

		int i = 0;
		while (i < this.canalesDeco.length) {
			if (this.canalesDeco[i] != null && this.canalesDeco[i].isHabilitado() == true && !deshabilitado) {
				this.canalesDeco[i].setHabilitado(false);
				deshabilitado = true;
			}
			i++;
		}

		return deshabilitado;

	}
	 public boolean habilitarCanal(int nro) {
		boolean habilitado = false;

		int i = 0;
		while (i < this.canalesDeco.length) {
			if (this.canalesDeco[i] != null && this.canalesDeco[i].isHabilitado() == false && !habilitado) {
				this.canalesDeco[i].setHabilitado(true);
				habilitado = true;
			}
			i++;
		}

		return habilitado;

	}

	public Canal obtenerCanalMayorPorTipo(TipoDeCanal tipoDeCanal) {
		Canal canalMayor = null;
		for (int i = 0; i < this.canalesDeco.length; i++) {
			if (this.canalesDeco[i] != null && this.canalesDeco[i].getTipoDeCanal().equals(tipoDeCanal)
					&& (canalMayor == null || canalMayor.getTipoDeCanal().equals(tipoDeCanal)
							&& this.canalesDeco[i].getNumero() > canalMayor.getNumero())) {
				canalMayor = this.canalesDeco[i];
			}
		}
		return canalMayor;
	}

	public Canal[] obtenerCanalesOrdenadosPorNombre() {
		Canal[] canalesOrdenados = new Canal[this.canalesDeco.length];
		for (int k = 0; k < this.canalesDeco.length; k++) {
			if (this.canalesDeco[k] != null) {
				canalesOrdenados[k] = this.canalesDeco[k];
			}
		}
		for (int i = 0; i < canalesOrdenados.length; i++) {
			for (int j = 0; j < canalesOrdenados.length - i - 1; j++) {
				if (canalesOrdenados[j] != null && canalesOrdenados[j + 1] != null
						&& canalesOrdenados[j].getNombre().compareTo(canalesOrdenados[j + 1].getNombre()) > 0) {
					Canal aux = canalesOrdenados[j];
					canalesOrdenados[j] = canalesOrdenados[j + 1];
					canalesOrdenados[j + 1] = aux;
				}
			}

		}
		return canalesOrdenados;
	}

}
