package ejercicio08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio08 {
	
	 //Creamos el fichero y guardamos su ruta.
	private static File fichero= new File ("Temperatura.txt");
	private static final String RUTA= ("/Users/isabelkatharinaloerzer/git/Tema10_B2b/Tema10_B2/src/Ficheros/Temperatura.txt");
	
	//Creamos un escáner y los búferes necesarios.
	static Scanner sc= new Scanner (System.in);
	static BufferedWriter bw= null;
	static BufferedReader br= null;
			
	// Declaramos las variables necesarias.
	private static int opcion = 0;
	private static String fecha;
	private static double tempMax;
	private static double tempMin;
	
	//Al ser máximo y mínimo hay que iniciacializarlas.
	private static double tempMinTotal=Double.MAX_VALUE;
	private static double tempMaxTotal=Double.MIN_VALUE;

	public static void main(String[] args) {
		
		// Hacemos un bucle que se repita hasta que nos salgamos del programa.
		do {

			// Presentamos el menú.
			menu();

			// Preguntamos la opción que quiere el usuario.
			System.out.println("Introduzca la opción que desea: ");
			opcion = sc.nextInt();

			// Hacemos un switch.
			switch (opcion) {

			case 1 -> {

				// Función de registrar una temperatura nueva.
				nuevoRegistro();

			}

			case 2 -> {

				// Función que muestras el historial de registros.
				historial();
			}

			case 3 -> {
					
				//salir
				System.out.println("Ha salido del programa.");
			}

			default -> {

				System.err.println("Opción introducida incorrecta");
			}
			}

		} while (opcion != 3);
	}

	/**
	 * Función que presenta el menú.
	 */
	private static void menu() {

		System.out.println(
				"Termómetro" + "" + "\n===================" + "\n1. Registra nueva temperatura" + "\n2. Mostrar historial de registros" + "\n3. Salir");

	}

	/**
	 * Función que añade un nuevo registro de temperaturas.
	 */
	private static void nuevoRegistro() {
		
		//Abrimos el fichero con el búfer de escritura.
		try {
			
			bw= new BufferedWriter(new FileWriter(RUTA, true));
			
			//Pedimos los datos.
			sc.nextLine();
			System.out.println("Introduzca una fecha (AAAA-MM-DD): ");
			fecha=sc.nextLine();
			
			System.out.println("Introduzca la temperutra mínima: ");
			tempMin=sc.nextDouble();
			
			System.out.println("Introduzca la temperatura máxima: ");
			tempMax=sc.nextDouble();
			
			//Lo escribimos.
			bw.write(fecha+", "+tempMin+", "+tempMax);
			
			//Pasamos de línea.
			bw.newLine();
			
			//Guardamos
			bw.flush();
			
			
		} catch (IOException e) {
			
			System.out.println("Error al acceder al fichero.");
			e.getMessage();
		
		} finally {
			
			//Cerramos el búfer.
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
	
	/**
	 * Función que presenta el historial de registros.
	 */
	private static void historial () {
		
		//Abrimos el búfer de lectura.
		try {
			br= new BufferedReader (new FileReader (RUTA));
			
			String linea; //variable para guardar el contenido de una línea del fichero.
			String[] datos; //array en el que guardamos los 

			
			//Leemos la primera línea (en este caso nos la queremos saltar.
			br.readLine();
			
			//Abrimos un bucle while para recorrer el resto del fichero.
			linea=br.readLine();
			
			//Recorremos el fichero y vamos imprimiendo línea a línea.
			while (linea!=null) {
				
				//Separamos la línea.
				datos= linea.split(",");
				
				System.out.println("Fecha: "+datos[0]);
				
				tempMin=Double.parseDouble(datos[1]);
				tempMax=Double.parseDouble(datos[2]);
				
				System.out.println("Temperatura mínima: "+ tempMin);
				System.out.println("Temperatura máxima: "+tempMax);
				System.out.println("--------------------------------------------------");

				//Registramos las temperaturas máximas.
				if (tempMinTotal>tempMin) {
					tempMinTotal=tempMin;
				}
				
				if (tempMaxTotal<tempMax) {
					tempMaxTotal=tempMax;
				}
				
				//Leemos otra línea.
				linea=br.readLine();
			}
			
			//Imprimimos las temperaturas máximas.
			System.out.println("Temperatura mínima registrada: "+tempMinTotal);
			System.out.println("Temperatura máxima registrada: "+tempMaxTotal);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Error al acceder al fichero.");
			e.getMessage();
		 
		} catch (IOException e) {
			
			System.out.println("Error al leer el fichero.");
			e.getMessage();
			
		}
		
	}
	

}
