package agentes;

import java.io.Serializable;

/**
 * 
 * @author DM
 * 
 * @version 0.1.0
 *
 */
public abstract class Agente implements Serializable {
	protected String nombre;
	protected int edad;
	protected String direccion;
	protected double salario;

	public Agente(String nombre, int edad, String direccion, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getSalario() {
		return salario;
	}

	@Override
	public String toString() {

		return ("Agente: " + nombre + "\n" + "Edad: " + edad + "\n" + "Dirección: " + direccion + "\n" + "salario: "
				+ salario);
	}

}
