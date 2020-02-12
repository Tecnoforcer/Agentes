package agencia;

/**
 * 
 * @author DM
 * 
 * @version 0.1.0
 *
 */
public class Jefazo extends Agente {
	private int anyos_mandato;

	public Jefazo(String nombre, int edad, String direccion, double salario, int anyos_mandato) {
		super(nombre, edad, direccion, salario);
		this.anyos_mandato = anyos_mandato;
	}

	public int getAnyos_mandato() {
		return anyos_mandato;
	}

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
