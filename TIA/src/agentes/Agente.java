package agentes;

import java.io.Serializable;

/**
 * 
 * @author DM
 * 
 * @version 0.1.1
 *
 */
public abstract class Agente implements Serializable {
	protected String nombre;
	protected int edad;
	protected String direccion;
	protected double salario;
	
	
/**
 * 
 * @return salario (double)
 * devuelve el salario de lagente
 */
	public double getSalario() {
		return salario;
	}



	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 */
	public Agente(String nombre, int edad, String direccion, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salario = salario;
	}

	//no hace falta to string, todos los hijos tienen uno propio
}
