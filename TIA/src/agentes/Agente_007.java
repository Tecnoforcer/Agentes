package agentes;

/**
 * 
 * @author DM
 * 
 * @version 0.1.1
 *
 */
public class Agente_007 extends Agente {
	private int contMuertes;
	private String armas[];

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 * @param contMuertes
	 * @param armas
	 */
	public Agente_007(String nombre, int edad, String direccion, double salario, int contMuertes, String[] armas) {
		super(nombre, edad, direccion, salario);
		this.contMuertes = contMuertes;
		this.armas = armas;
	}

	/**
	 * 
	 * @param armas
	 * recibe el vector (para actualizar)
	 */
	public void setArmas(String[] armas) {
		this.armas = armas;
	}




	/**
	 * sobreescribe el toString del padre (por defecto) y muestra este
	 */
	public void mostrarInfo() {
		System.out.println("Agente: " + nombre + "\n" + "Edad: " + edad + "\n" + "Dirección: " + direccion + "\n"
				+ "salario: " + salario);
		System.out.println("Muertes: " + contMuertes);
		System.out.println("Armas: ");
		for (int i = 0; i < this.armas.length; i++) {
			if (armas[i]!=null) {
				System.out.println(this.armas[i]);
			}
			
		}

	}

}
