package agentes;

import java.util.Arrays;

/**
 * 
 * @author DM
 * 
 * @version 0.1.1
 *
 */
public class Agente_E extends Agente {
	private String pisos[];

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 * @param pisos
	 */
	public Agente_E(String nombre, int edad, String direccion, double salario, String[] pisos) {
		super(nombre, edad, direccion, salario);
		this.pisos = pisos;
	}
/**
 * 
 * @param pisos
 * 
 * recibe el vector (para actualizar)
 */
	public void setPisos(String[] pisos) {
		this.pisos = pisos;
	}


	/**
	 * sobreescribe el toString del padre (por defecto) y muestra este
	 */
	public void mostrarInfo() {
		System.out.println("Agente: " + nombre + "\n" + "Edad: " + edad + "\n" + "Dirección: " + direccion + "\n"
				+ "salario: " + salario);
		System.out.println("Pisos:");
		for (int i = 0; i < pisos.length; i++) {
			if (pisos!=null) {
				System.out.println(pisos[i]);
			}
			
		}

	}

}
