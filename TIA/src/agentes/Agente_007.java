package agentes;

/**
 * 
 * @author DM
 * 
 * @version 0.1.0
 *
 */
public class Agente_007 extends Agente {
	private int contMuertes;
	private String armas[];

	public Agente_007(String nombre, int edad, String direccion, double salario, int contMuertes, String[] armas) {
		super(nombre, edad, direccion, salario);
		this.contMuertes = contMuertes;
		this.armas = armas;
	}

	public void setArmas(String[] armas) {
		this.armas = armas;
	}

	
	
	public String[] getArmas() {
		return armas;
	}

	public void setContMuertes(int contMuertes) {
		this.contMuertes += contMuertes;
	}

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
