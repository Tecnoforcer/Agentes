package agentes;

import java.util.Arrays;

/**
 * 
 * @author DM
 * 
 * @version 0.1.0
 *
 */
public class Agente_E extends Agente {
	private String pisos[];

	public Agente_E(String nombre, int edad, String direccion, double salario, String[] pisos) {
		super(nombre, edad, direccion, salario);
		this.pisos = pisos;
	}

	public void setPisos(String[] pisos) {
		this.pisos = pisos;
	}

	public void mostrarInfo() {
		System.out.println("Agente: " + nombre + "\n" + "Edad: " + edad + "\n" + "Dirección: " + direccion + "\n"
				+ "salario: " + salario);
		System.out.println("Pisos:");
		for (int i = 0; i < pisos.length; i++) {
			System.out.println(pisos[i]);
		}

	}

}
