package agencia;

import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author DM
 * 
 * @version 0.1.0
 *
 */
public class IOdatos {
	private static final String dirArmaTXT = "recursos/armas.txt";
	private static final String dirArmaBIN = "recursos/armas.dat";
	private static final String dirPisoTXT = "recursos/pisos.txt";
	private static final String dirPisoBIN = "recursos/pisos.dat";
	// private static final String dirAgenteTXT = "recursos/agente.txt";
	private static final String dirAgenteBIN = "recursos/agente.dat";

	public static String[] cargarArma() {
		String armas[] = new String[100];
		File file = new File(dirArmaTXT);
		Scanner read;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			read = new Scanner(file);
			for (int i = 0;; i++) {
				armas[i] = read.nextLine();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return armas;
	}

	public static String[] cargarPisos() {
		String pisos[] = new String[100];
		File file = new File(dirPisoTXT);
		Scanner read;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			read = new Scanner(file);
			for (int i = 0;; i++) {
				pisos[i] = read.nextLine();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return pisos;
	}

	public static Agente[] cargarAgentes() {
		Agente agentes[] = new Agente[100];
		File file = new File(dirAgenteBIN);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			agentes = (Agente[]) ois.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return agentes;
	}

	public static void guardarAgentes(Agente agentes[]) {
		File file = new File(dirAgenteBIN);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(agentes);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void guardarPisos(String pisos[]) {
		File file = new File(dirPisoTXT);
		FileWriter fw = null;
		PrintWriter pw = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);

			for (String p : pisos) {
				pw.write(p);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				pw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void guardarArmas(String armas[]) {
		File file = new File(dirArmaTXT);
		FileWriter fw = null;
		PrintWriter pw = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);

			for (String a : armas) {
				pw.write(a);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				pw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
