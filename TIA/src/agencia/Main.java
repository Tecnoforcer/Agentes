package agencia;

import java.util.Scanner;

import agentes.*;
import utilidades.*;

/**
 * 
 * @author DM
 * 
 * @version 0.1.5
 *
 */
public class Main {

	public static void main(String[] args) {
		boolean encriptado = false;
		int opc = 0;
		int opcAgente = 0;

		Agente agentes[] = new Agente[100];
		String armas[] = new String[100];
		String pisos[] = new String[100];

		encriptado = IOdatos.isEncriptado();

		
		if (!encriptado) {
			try {
				armas = IOdatos.cargarArma();
				pisos = IOdatos.cargarPisos();
				agentes = IOdatos.cargarAgentes();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		do {
			opc = Menu.meñuPrincipal();
			switch (opc) {
			case 1:
				if (!encriptado) {
					for (Agente a : agentes) {
						if (a != null) {
							if (a instanceof Agente_007) {
								((Agente_007) a).mostrarInfo();
							} else if (a instanceof Agente_E) {
								((Agente_E) a).mostrarInfo();
							} else {
								a.toString();
							}
						}
					}
				}
				break;
			case 2:
				if (!encriptado) {
					double salarioMinimo = 0;
					Scanner readDouble = new Scanner(System.in);
					try {
						System.out.println("Mostar agentes con salario mayor a  {insertar salario}");
						salarioMinimo = readDouble.nextDouble();
					} catch (Exception e) {
						// TODO: handle exception
					}
					for (Agente a : agentes) {
						if (a != null && (a.getSalario() >= salarioMinimo)) {
							System.out.println(a.toString());
						}
					}
				}
				break;
			case 3:
				if (!encriptado) {
					Operaciones.nuevoPiso(pisos);
					IOdatos.guardarPisos(pisos);
					for (Agente a : agentes) {
						if (a instanceof Agente_E) {
							((Agente_E) a).setPisos(pisos);
						}
					}
				}
				break;
			case 4:
				if (!encriptado) {

					Operaciones.nuevoArma(armas);
					IOdatos.guardarArmas(armas);
					for (Agente a : agentes) {
						if (a instanceof Agente_007) {
							((Agente_007) a).setArmas(armas);
						}
					}
					IOdatos.guardarAgentes(agentes);
				}
				break;
			case 5:
				if (!encriptado) {
					do {
						opcAgente = Menu.menuAgregarAgente();
						switch (opcAgente) {
						case 1:
							Operaciones.nuevoJefazo(agentes);
							break;
						case 2:
							Operaciones.nuevoEspia(agentes, pisos);
							break;
						case 3:
							Operaciones.nuevo007(agentes, armas);
							break;
						}
						IOdatos.guardarAgentes(agentes);
					} while (opcAgente != 4);
				}
				break;
			case 6:
				IOdatos.encriptarInfo(pisos, armas, agentes);
				encriptado = true;
				break;
			case 7:
				if (encriptado) {
					IOdatos.desEncriptar(pisos, armas, agentes);
					encriptado = false;
				} else {
					System.out.println("no hay datos que desencriptar");
				}
				break;
			case 8:
				System.out.println("adew");
				break;
			}
		} while (opc != 8);
	}

}
