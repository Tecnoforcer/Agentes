package utilidades;

import java.util.Scanner;

import agentes.*;

/**
 * 
 * @author DM
 *
 * @version 0.1.0
 *
 */
public class Operaciones {
/**
 * 
 * @param vektor  (pisos[] o armas[])
 * @return int
 * 
 * recibe un vector y busca el primer hueco libre
 */
	private static int buscarEspacioBlanco(String vektor[]) {

		for (int i = 0; i < vektor.length; i++) {
			if (vektor[i] == null) {
				return i;

			}
		}

		return -1;
	}

	/**
	 * 
	 * @param pisos
	 * 
	 * 
	 * recibe el vector de pisos para darselo a buscarEspacioBlanco, a continuacion recibe pos (posicion) y agrega un nuevo piso en esa posicion
	 * 
	 */
	public static void nuevoPiso(String pisos[]) {
		Scanner read = new Scanner(System.in);
		String piso = "";
		int pos = buscarEspacioBlanco(pisos);

		if (pos >= 0) {
			try {
				System.out.println("escriba la direccion con el siguiente formato:  {ciudad},{calle} numero {numero del piso}");
				piso = read.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}

			pisos[pos] = piso;

		} else {
			System.out.println("no se pudo realizar la operacion");
		}

	}
	/**
	 * 
	 * @param pisos
	 * 
	 * 
	 * recibe el vector de armas para darselo a buscarEspacioBlanco, a continuacion recibe pos (posicion) y agrega un nuevo arma en esa posicion
	 * 
	 */
	public static void nuevoArma(String armas[]) {
		Scanner read = new Scanner(System.in);
		String arma = "";
		int pos = buscarEspacioBlanco(armas);

		if (pos >= 0) {
			try {
				System.out.println("escriba el nombre del arma");
				arma = read.nextLine().toUpperCase();
			} catch (Exception e) {
				// TODO: handle exception
			}

			armas[pos] = arma;

		} else {
			System.out.println("no se pudo realizar la operacion");
		}

	}
/**
 * 
 * @param a (agentes[])
 * @return int
 * 
 * recibe el vector y busca un espacio en blanco
 */
	private static int buscarEspacioA(Agente a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null) {
				return i;

			}
		}

		return -1;

	}
/**
 * 
 * @param agentes
 * 
 * 
 * recibe el vector agentes[] y se lo da a buscarEspacioA, recibe pos (posicion) y guarda un nuevo jefazo en esa posicion
 */
	public static void nuevoJefazo(Agente agentes[]) {
		Scanner readString = new Scanner(System.in);
		Scanner readInt = new Scanner(System.in);
		Scanner readDouble = new Scanner(System.in);
		String nombre = "";
		int edad = 0;
		String direccion = "";
		double salario = 0;
		int anyos_mandato = 0;
		int pos = buscarEspacioA(agentes);

		try {

			if (pos >= 0) {
				System.out.println("Introduzca el nombre");
				nombre = readString.nextLine();
				System.out.println("Introduzca la edad");
				edad = readInt.nextInt();
				System.out.println("Introduzca la direccion del agente");
				direccion = readString.nextLine();
				System.out.println("Introduzca el salario del agente");
				salario = readDouble.nextDouble();
				System.out.println("Introduzca los años de mandato");
				anyos_mandato = readInt.nextInt();

				Agente jef = new Jefazo(nombre, edad, direccion, salario, anyos_mandato);

				agentes[pos] = jef;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param agentes
	 * 
	 * 
	 * recibe el vector agentes[] y se lo da a buscarEspacioA, recibe pos (posicion) y guarda un nuevo agente de espionaje en esa posicion
	 */
	public static void nuevoEspia(Agente agentes[],String pisos[]) {
		Scanner readString = new Scanner(System.in);
		Scanner readInt = new Scanner(System.in);
		Scanner readDouble = new Scanner(System.in);
		String nombre = "";
		int edad = 0;
		String direccion = "";
		double salario = 0;
		
		int pos = buscarEspacioA(agentes);

		try {

			if (pos >= 0) {
				System.out.println("Introduzca el nombre");
				nombre = readString.nextLine();
				System.out.println("Introduzca la edad");
				edad = readInt.nextInt();
				System.out.println("Introduzca la direccion del agente");
				direccion = readString.nextLine();
				System.out.println("Introduzca el salario del agente");
				salario = readDouble.nextDouble();
				

				Agente esp = new Agente_E(nombre, edad, direccion, salario, pisos);

				agentes[pos] = esp;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param agentes
	 * 
	 * 
	 * recibe el vector agentes[] y se lo da a buscarEspacioA, recibe pos (posicion) y guarda un nuevo agente 007 en esa posicion
	 */
	public static void nuevo007(Agente agentes[],String armas[]) {
		Scanner readString = new Scanner(System.in);
		Scanner readInt = new Scanner(System.in);
		Scanner readDouble = new Scanner(System.in);
		String nombre = "";
		int edad = 0;
		String direccion = "";
		double salario = 0;
		int contMuertes = 0;
		int pos = buscarEspacioA(agentes);

		try {

			if (pos >= 0) {
				System.out.println("Introduzca el nombre");
				nombre = readString.nextLine();
				System.out.println("Introduzca la edad");
				edad = readInt.nextInt();
				System.out.println("Introduzca la direccion del agente");
				direccion = readString.nextLine();
				System.out.println("Introduzca el salario del agente");
				salario = readDouble.nextDouble();
				System.out.println("Introduzca el numero de enemigos elimidados");
				contMuertes = readInt.nextInt();

				Agente esp = new Agente_007(nombre, edad, direccion, salario, contMuertes, armas);

				agentes[pos] = esp;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
