package agencia;

import java.util.Scanner;

import agentes.*;
import utilidades.*;

/**
 * 
 * @author DM
 * 
 * @version 0.1.0
 *
 */
public class Main {

	public static void main(String[] args) {
		boolean encripado = false;
		int opc = 0;
		int opcAgente = 0;

		Agente agentes[] = new Agente[100];
		String armas[] = new String[100];
		String pisos[] = new String[100];

		armas = IOdatos.cargarArma();
		for (int i = 0; i < armas.length; i++) {
			if (armas[i] != null) {
				System.out.println(armas[i]);
			}

		}
		armas[3] = "MP5";
		armas[4] = "COLT";
		armas[5] = "PANZERFAUST";
		IOdatos.guardarArmas(armas);

		do {
			opc = Menu.meñuPrincipal();
			switch (opc) {
			case 1:
				if (!encripado) {
					for (int i = 0; i < agentes.length; i++) {
						if (agentes[i] != null) {
							System.out.println(agentes[i].toString());
						}
					}
				}
				break;
			case 2:
				if (!encripado) {
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
				if (!encripado) {
					Operaciones.nuevoPiso(pisos);
				}
				break;
			case 4:
				if (!encripado) {
					Operaciones.nuevoArma(armas);
				}
				break;
			case 5:
				if (!encripado) {
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
					} while (opcAgente != 4);
				}
				break;
			case 6:
				IOdatos.encriptarInfo(pisos, armas);
				encripado = true;
				break;
			case 7:
				if (encripado) {
					IOdatos.desEncriptar(pisos, armas);
					encripado = false;
				} else {
					System.out.println("no hay datos que desencriptar");
				}
				break;
			case 8:

				break;
			}
		} while (opc != 8);
	}

}
