package agencia;

import java.io.*;
import java.util.Scanner;

import agentes.Agente;

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
	private static final String dirEstado = "recursos/estado.dat";

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
				if (read.hasNextLine()) {
					armas[i] = read.nextLine();
				} else {
					break;
				}

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

				if (read.hasNextLine()) {
					pisos[i] = read.nextLine();
				} else {
					break;
				}
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
				if (p != null) {
					pw.println(p);
				}

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
				if (a != null) {
					pw.println(a);

				}
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

	// *************************************************************************************
	private static void guardarArmasBin(String armas[]) {
		File file = new File(dirArmaBIN);
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);

			for (String s : armas) {
				if (s != null) {
					dos.writeUTF(s);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void guardarPisosBin(String pisos[]) {
		File file = new File(dirPisoBIN);
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);

			for (String s : pisos) {
				if (s != null) {
					dos.writeUTF(s);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static String[] cargarArmasBIN() {
		String armas[] = new String[100];
		File file = new File(dirArmaBIN);
		FileInputStream fis = null;
		DataInputStream dis = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);

			for (int i = 0;; i++) {
				armas[i] = dis.readUTF();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			try {
				dis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return armas;
	}

	private static String[] cargarPisosBIN() {
		String pisos[] = new String[100];
		File file = new File(dirPisoBIN);
		FileInputStream fis = null;
		DataInputStream dis = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);

			for (int i = 0;; i++) {

				pisos[i] = dis.readUTF();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			try {
				dis.close();
				fis.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return pisos;
	}

	public static void encriptarInfo(String pisos[], String armas[], Agente[] agentes) {
		File armaTXT = new File(dirArmaTXT);
		File pisoTXT = new File(dirPisoTXT);

		IOdatos.guardarArmasBin(armas);
		IOdatos.guardarPisosBin(pisos);
		guardarAgentes(agentes);

		pisos = null;
		armas = null;
		agentes = null;

		pisoTXT.delete();
		armaTXT.delete();

		setEncriptado();

	}

	public static void desEncriptar(String pisos[], String armas[], Agente[] agentes) {
		File armaBIN = new File(dirArmaBIN);
		File pisoBIN = new File(dirPisoBIN);
		File armaTXT = new File(dirArmaTXT);
		File pisoTXT = new File(dirPisoTXT);
		if (!armaTXT.exists()) {
			try {
				armaTXT.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!pisoTXT.exists()) {
			try {
				armaTXT.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		armas = cargarArmasBIN();
		pisos = cargarPisosBIN();
		agentes = cargarAgentes();

		guardarPisos(pisos);
		guardarArmas(armas);

		armaBIN.delete();
		pisoBIN.delete();
		setDESEncriptado();

	}

	public static boolean isEncriptado() {
		boolean encriptado = false;
		int marca = 0;

		File est = new File(dirEstado);

		FileInputStream fis = null;
		DataInputStream dis = null;

		if (!est.exists()) {
			try {
				est.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fis = new FileInputStream(est);
			dis = new DataInputStream(fis);

			marca = dis.readInt();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (marca == -13) {
			encriptado = true;
		} else {
			encriptado = false;
		}
		setEncriptado();

		return encriptado;
	}

	private static void setEncriptado() {
		File est = new File(dirEstado);
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		if (!est.exists()) {
			try {
				est.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fos = new FileOutputStream(est);
			dos = new DataOutputStream(fos);

			dos.writeInt(-13);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void setDESEncriptado() {
		File est = new File(dirEstado);
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		if (!est.exists()) {
			try {
				est.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fos = new FileOutputStream(est);
			dos = new DataOutputStream(fos);

			dos.writeInt(13);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
