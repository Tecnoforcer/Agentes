package agencia;

import java.io.*;
import java.util.Scanner;

import agentes.Agente;

/**
 * 
 * @author DM
 * 
 * @version 0.1.6
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
	
/**
 * 
 * @return String[]
 * 
 * carga de disco las armas (formato TXT) y las devuelve en un vector
 */
	public static String[] cargarArma() {
		String armas[] = new String[100];
		File file = new File(dirArmaTXT);
		Scanner read = null;

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
		}finally {
			read.close();
		}

		return armas;
	}
	/**
	 * 
	 * @return String[]
	 * 
	 * carga de disco los pisos (formato TXT) y los devuelve en un vector
	 */
	public static String[] cargarPisos() {
		String pisos[] = new String[100];
		File file = new File(dirPisoTXT);
		Scanner read = null;

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
		}finally {
			read.close();
		}

		return pisos;
	}

	/**
	 * 
	 * @return Agente[]
	 * 
	 * carga de disco los agentes y los devuelve en un vector
	 */
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
			// e.printStackTrace();
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

	/**
	 * 
	 * @param agentes (Agente[])
	 * 
	 * recibe el vector de agentes y lo guarda en disco
	 */
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

	/**
	 * 
	 * @param pisos (String[])
	 * 
	 * recibe el vector de pisos y lo guarda en disco con formato TXT
	 */
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
	/**
	 * 
	 * @param armas (String[])
	 * 
	 * recibe el vector de armas y lo guarda en disco con formato TXT
	 */
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
	/**
	 * 
	 * @param agentes (String[])
	 * 
	 * recibe el vector de armas y lo guarda en disco con formato DAT
	 */
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

	/**
	 * 
	 * @param agentes (String[])
	 * 
	 * recibe el vector de pisos y lo guarda en disco con formato DAT
	 */
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
	/**
	 * 
	 * @return String[]
	 * 
	 * carga de disco las armas (formato DAT) y las devuelve en un vector
	 */
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
	/**
	 * 
	 * @return String[]
	 * 
	 * carga de disco los pisos (formato DAT) y los devuelve en un vector
	 */
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
/**
 * 
 * @param pisos
 * @param armas
 * @param agentes
 * 
 * recive los vectores (pisos, armas, agentes) y los guarda en formato DAT (borra los TXT), y borra su contenido
 */
	public static void encriptarInfo(String pisos[], String armas[], Agente[] agentes) {//problem
		

		IOdatos.guardarArmasBin(armas);
		IOdatos.guardarPisosBin(pisos);
		guardarAgentes(agentes);

		pisos = null;
		armas = null;
		agentes = null;

		File armaTXT = new File(dirArmaTXT);
		File pisoTXT = new File(dirPisoTXT);
	
		pisoTXT.delete();
			
		
		armaTXT.delete();

		setEncriptado();

	}
/**
 * 
 * @param pisos
 * @param armas
 * @param agentes
 * 
 * recibe los vectores (armas, pisos, agentes) y los carga de disco (elimina DAT y crea TXT)
 * 
 */
	public static void desEncriptar(String pisos[], String armas[], Agente[] agentes) {
		File armaBIN = new File(dirArmaBIN);
		File pisoBIN = new File(dirPisoBIN);
		File armaTXT = new File(dirArmaTXT);
		File pisoTXT = new File(dirPisoTXT);

		if (checkPaswrd().equalsIgnoreCase("true")) {
			armas = cargarArmasBIN();
			pisos = cargarPisosBIN();
			agentes = cargarAgentes();

			guardarPisos(pisos);
			guardarArmas(armas);

			armaBIN.delete();
			pisoBIN.delete();
			
			setDESEncriptado();
		}

	}
/**
 * 
 * @return inserted (String)
 * 
 * comprueba quese introduzca la contaseña correcta
 */
	private static String checkPaswrd() {// falta modificar un poco
		String pswrd = "asdfg1234";
		String inserted = "";
		Scanner readS = null;
		Scanner readI = null;
		int cont = 0;
		int opc = 0;

		while (cont != 6) {
			System.out.println("1. introducir contraseña");
			System.out.println("2.salir");
			readI = new Scanner(System.in);
			try {
				opc = readI.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}

			if (opc == 1) {
				try {
					readS = new Scanner(System.in);
					inserted = readS.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (inserted.contentEquals(pswrd)) {
					return "true";
				} else {
					cont++;
				}
			} else {
				return "false";
			}
		}
		
		return "false";
	}
/**
 * 
 * @return boolean
 * 
 * comprueba si esta encriptado
 */
	public static boolean isEncriptado() {
		boolean encriptado = false;
		int marca = 0;

		File est = new File(dirEstado);

		FileInputStream fis = null;
		DataInputStream dis = null;

		if (!est.exists()) {
			try {
				est.createNewFile();
				setDESEncriptado();
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

		if (marca == 31) {
			return true;
		} else {
			return false;
		}

	}
/**
 * cambia el estado a encriptado
 */
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

			dos.writeInt(31);

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

	/**
	 * cambia el estado a desencriptado
	 */
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
