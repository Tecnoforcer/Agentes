package agentes;

/**
 * 
 * @author DM
 * 
 * @version 0.1.1
 *
 */
public class Jefazo extends Agente {
	private int anyos_mandato;

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 * @param anyos_mandato
	 */
	public Jefazo(String nombre, int edad, String direccion, double salario, int anyos_mandato) {
		super(nombre, edad, direccion, salario);
		this.anyos_mandato = anyos_mandato;
	}

	/**
	 * 
	 * @return anyos_mandato
	 */
	public int getAnyos_mandato() {
		return anyos_mandato;
	}

	/**
	 * sobreescribe el toString del padre (por defecto) y muestra este
	 */
	@Override
	public String toString() {

		return ("**************************************************" + "\n" 
				+ "Agente: " + nombre + "\n"
				+ "Años de mandato: " + anyos_mandato + "\n" 
				+ "Edad: " + edad + "\n" 
				+ "Dirección: " + direccion + "\n"
				+ "salario: " + salario + "\n" 
				+ "**************************************************");
	}

}
