package ejercicio07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Utils {
	
	//Nos creamos un mapa para guardar los contactos.
	private static Map<String, String> agenda= new TreeMap <String, String>();
	
	//Nos creamos un archivo y su ruta correspondiente.
	private static final String RUTA= ("src\\Ficheros\\Agenda.txt");
	
	/**
	 * Función que carga el fichero en el mapa.
	 */
	public static void abrirFichero() {
		
		//Creo un búfer de lectura.
		BufferedReader br= null;
		String linea;
		String[] datos;
		String nombre;
		String tlf;
		
		//Asignamos el búfer a un fichero.
		
		try {
			
			br= new BufferedReader(new FileReader (RUTA));
			
			//Recorremos el fichero y lo guardamos en agenda.
			linea=br.readLine();
			
			while (linea!=null&&!linea.equals("")) {
				
				datos=linea.split(";");
				
				nombre= datos[0];
				tlf= datos[1];
				
				agenda.put(nombre, tlf);
				
				//Leemos la siguiente línea.
				linea= br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Error al abrir el fichero.");
			e.getMessage();
		
		} catch (IOException e) {
			
			System.out.println("Error al leer el fichero");
			e.getMessage();
		
		} finally {
			
			try {
				if (br!=null) {
				
					br.close();
				
				}
				
			} catch (IOException e) {
				
				System.out.println("Error al cerrar el búfer de lectura");
				e.getMessage();
			}
		}
		
		
	}
	
	
	/**
	 * Función que presenta el menú.
	 */
	public static void menu() {

		System.out.println(
				 "\n===================" + "\n1. Nuevo contacto" + "\n2. Buscar por nombre" + "\n3. Mostrar todos"+"\n4. Salir");

	}
	
	/**
	 * Función que crea un contacto nuevo en la agenda.
	 * 
	 * @param nombre Nombre del contacto
	 * @param tlf Teléfono del contacto.
	 * @throws SizeException lanza la excepción cuando se quieren introducir más contactos de los que se pueden.
	 * @throws SameNameException lanza la excepción cuando el nombre de un contacto es igual a un nombre que ya existe en la agenda
	 */
	public static void nuevoContacto (String nombre, String tlf) throws SizeException, SameNameException {
		
		//En caso de que la agenda ya tenga 20 registros, lanzamos una excepción de tamaño.
		if (agenda.size()>20) {
			
			throw new SizeException();
		
		//En caso de que el nombre ya exista en agenda, lanzamos una excepción
		} else if (agenda.containsKey(nombre)) {
			
			throw new SameNameException();
			
		//En caso de que todo esté bien, añadimos los datos a agenda.
		} else {
			
			agenda.put(nombre, tlf);
		}
	}
	
	/**
	 * Función que busca el teléfono de un contacto en la agenda.
	 * 
	 * @param nombre Nombre del contacto a buscar.
	 */
	public static void buscarContacto(String nombre) {
		
		String tlf;
		
		if (agenda.containsKey(nombre)) {

			tlf=agenda.get(nombre);
			System.out.println("Tlf: "+tlf);
		
		} else {
			
			System.out.println("El contacto no existe.");
		}

	}
	
	/**
	 * Función que muestra todos los contactos de la agenda.
	 */
	public static void mostrar() {
		
		//Recorremos agenda con un for-each y la imprimimos.
		for (String contacto: agenda.keySet()) {
			
			System.out.println("Contacto: "+contacto+"; tlf: "+agenda.get(contacto));
		}
	}
	
	public static void guardar() {
		
		//Creamos un búfer de escritura.
		BufferedWriter bw= null;
		
		//Abrimos el fichero con el búfer de escritura.
		try {
			
			bw= new BufferedWriter (new FileWriter(RUTA));
			
			//Recorremos la agenda y vamos guardando línea a línea.
			for (String contacto: agenda.keySet()) {
				
				bw.write(contacto+"; "+agenda.get(contacto));
				
				//Pasamos de línea.
				bw.newLine();

			}
			
			//Guardamos todo.
			bw.flush();
			
		} catch (IOException e) {
			
			System.out.println("Error al acceder al fichero.");
			e.getMessage();
		
		} finally {
			
			try {
				if (bw!=null) {
				
					bw.close();
				
				}
				
			} catch (IOException e) {
				
				System.out.println("Error al cerrar el búfer de escritura.");
				e.getMessage();
			}
		}
		
	}

}
