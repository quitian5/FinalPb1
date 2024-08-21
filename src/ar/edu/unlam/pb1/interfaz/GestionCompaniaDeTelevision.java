package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;
import ar.edu.unlam.pb1.dominio.*;

public class GestionCompaniaDeTelevision {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CompaniaDeTelevision compania = new CompaniaDeTelevision();
		Cliente cliente = new Cliente();
		String contrasenia = compania.generarContrasenia();
		mostrarPorPantalla("Su contrasenia es: " + contrasenia);
		Decodificador deco = new Decodificador();
		deco.setContrasenia(contrasenia);
		boolean sesionIniciada = false;
		do {
			String contraseniaIngresada = ingresarString("Ingrese la contrasenia de su decodificador");
			if (contraseniaIngresada.equals(deco.getContrasenia())) {
				sesionIniciada = true;

			}

		} while (!sesionIniciada);

		menuPrincipal(compania, deco,cliente);

	}

	private static void menuPrincipal(CompaniaDeTelevision compania, Decodificador deco,Cliente cliente) {

		MenuPrincipal opcion = null;
		do {
			opcion = ingresarMenuPrincipal();
			switch (opcion) {
			case AGREGAR_CANAL_AL_DECO:
				mostrarCanales(compania.getCanales());
				int numero = ingresarInt("Ingrese el numero del canal que quiere agregar");
				if (compania.agregarCanal(numero, deco)) {
					mostrarPorPantalla("Canal agregado correctamente");

				} else {
					mostrarPorPantalla("No se pudo agregar el canal");
				}
				break;
			case HABILITAR_DESABILITAR: 
				subMenu(compania, deco,cliente);
				break;
			case ASIGNAR_CLIENTE_AL_DECO:
				asignarDecoAlCliente(compania,deco,cliente);
				break;
			case MOSTRAR_CANAL_MAYOR_POR_TIPO:
				mostrarCanalMayorPorTipo(deco);

				break;
			case MOSTRAR_CANALES_DISPONIBLES:
				mostrarCanales(deco.getCanalesDeco());
				break;
			case MOSTRAR_CANALES_ORDENADOS_POR_NOMBRE:
				mostrarCanalesOrdenadosPorNombre(deco);
				break;

			case SALIR:
				mostrarPorPantalla("Hasta luego");
				break;

			}

		} while (!opcion.equals(MenuPrincipal.SALIR));

	}
  private static void asignarDecoAlCliente(CompaniaDeTelevision compania,Decodificador deco,Cliente cliente) {
	 if( compania.asignarDecoAlCliente(deco, cliente)) {
		 mostrarPorPantalla("Decodificador asignado correctamente");
	 }else {
		 mostrarPorPantalla("No se pudo asignar");
	 }
	  
	  
	  
  }
	private static void subMenu(CompaniaDeTelevision compania, Decodificador deco,Cliente cliente) {
		final int HABILITAR = 1;
		final int DESHABILITAR = 2;
		final int SALIR = 3;

		int opcion = 0;

		do {
			mostrarPorPantalla("Ingrese \n1.Habilitar \n2.Deshabilitar \n3.Salir");
			opcion = ingresarInt("");
			switch (opcion) {
			case HABILITAR:
				mostrarCanales(deco.getCanalesDeco());
				int nro = ingresarInt("Ingrese el numero de canal a habilitar del deco");
				if (deco.habilitarCanal(nro)) {
					mostrarPorPantalla("Canal habilitado");

				} else {
					mostrarPorPantalla("No se pudo habilitar el canal");
				}

				break;
			case DESHABILITAR:
				mostrarCanales(deco.getCanalesDeco());
				int numero = ingresarInt("Ingrese el numero de canal a deshabilitar del deco");
				if (deco.deshabilitarCanal(numero)) {
					mostrarPorPantalla("Canal deshabilitado");

				} else {
					mostrarPorPantalla("No se pudo deshabilitar el canal");
				}

				break;
			case SALIR:
				menuPrincipal(compania, deco,cliente);
				break;

			}
		} while (opcion != SALIR);
	}

	private static void mostrarCanalMayorPorTipo(Decodificador deco) {
		TipoDeCanal tipoDeCanal = ingresarTipoDeCanal();
		Canal canalMayorPorTipo = deco.obtenerCanalMayorPorTipo(tipoDeCanal);
		mostrarCanal(canalMayorPorTipo);

	}

	private static void mostrarCanalesOrdenadosPorNombre(Decodificador deco) {
		mostrarCanales(deco.obtenerCanalesOrdenadosPorNombre());

	}

	private static TipoDeCanal ingresarTipoDeCanal() {
		mostrarTipoDeCanal();
		int opcion = ingresarInt("Ingrese una opcion: ");
		return TipoDeCanal.values()[opcion - 1];
	}

	private static void mostrarTipoDeCanal() {
		for (int i = 0; i < TipoDeCanal.values().length; i++) {
			mostrarPorPantalla((i + 1) + "." + TipoDeCanal.values()[i]);
		}

	}

	private static void mostrarCanal(Canal canal) {
		if (canal != null) {
			mostrarPorPantalla(canal.toString());
		} else {
			mostrarPorPantalla("No hay canales para mostrar");
		}
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

	private static String ingresarString(String mensaje) {
		System.out.println(mensaje);
		return teclado.next();
	}

	private static int ingresarInt(String mensaje) {
		System.out.println(mensaje);
		return teclado.nextInt();
	}

	private static void mostrarCanales(Canal[] canal) {
		int contador = 0;
		for (int i = 0; i < canal.length; i++) {
			if (canal[i] != null) {
				System.out.println(canal[i].toString());
			} else if (canal[i] == null) {
				contador++;
			}

		}
		if (contador == canal.length) {
			System.out.println("No hay canales para mostrar");
		}
	}

	private static MenuPrincipal ingresarMenuPrincipal() {
		mostrarMenuPrincipal();
		int opcion = ingresarInt("Ingrese una opcion: ");
		return MenuPrincipal.values()[opcion - 1];
	}

	private static void mostrarMenuPrincipal() {
		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			mostrarPorPantalla((i + 1) + MenuPrincipal.values()[i].getDescripcion());
		}
	}
}
