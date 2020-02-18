package utilidades;

import java.util.Scanner;

/**
 * 
 * @author DM
 * 
 * @version 0.1.0
 *
 */
public class Menu {
/**
 * 
 * @return int
 * devuelve la opcion elegida
 */
	public static int meñuPrincipal() {
		int opc = 0;
		Scanner read = new Scanner(System.in);
		boolean correct = true;

		do {
			System.out.println("1. Ver agentes");
			System.out.println("2. ver agentes con sueldo superior a (x)");
			System.out.println("3. Dar de alta un nuevo piso");
			System.out.println("4. Dar de alta un nuevo arma");
			System.out.println("5. Dar de alta un nuevo agente");
			System.out.println("6. Encriptar toda la información");
			System.out.println("7. Desencriptar toda la información");
			System.out.println("8. Salir");

			try {
				correct = true;
				opc = read.nextInt();
				if (opc < 1 || opc > 8)
					correct = false;
			} catch (Exception e) {
				correct = false;
			}
		} while (!correct);

		return opc;
	}
	/**
	 * 
	 * @return int
	 * devuelve la opcion elegida
	 */
	public static int menuAgregarAgente() {
		int opc = 0;
		Scanner read = new Scanner(System.in);
		boolean correct = true;

		do {
			System.out.println("1. Dar de alta un nuevo Jefazo");
			System.out.println("2. Dar de alta un nuevo Agente de Espionaje");
			System.out.println("3. Dar de alta un nuevo Agente de 007");
			System.out.println("4. Salir");

			try {
				correct = true;
				opc = read.nextInt();
				if (opc < 1 || opc > 4)
					correct = false;
			} catch (Exception e) {
				correct = false;
			}
		} while (!correct);

		return opc;

	}
}
