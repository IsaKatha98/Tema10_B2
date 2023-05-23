package ejercicio04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		// Creamos un BufferedWriter para leer lo que se introduce por consola.
		BufferedWriter bw = null;
		
		//Me creo un escáner para escribir cosas desde la consola.
		Scanner sc= new Scanner (System.in);

		// ASignamos la ubicación del fichero.

		try {
			bw = new BufferedWriter(new FileWriter("/Users/isabelkatharinaloerzer/git/Tema10_B2/Tema10_B2/src/Ficheros/Escribir.txt"));
			
			//Creamos las variables necesarias.
			String texto="";
			
			//Leemos la primera línea.
			texto=sc.nextLine();
			
			//Hacemos un bucle que vaya leyendo hasta que detecta la palabra fin.
			while (!texto.equals("fin")) {
				
				//Escribimos en el fichero la primera línea leída por el escáner.
				bw.write(texto);
				
				//Pasamos a la siguiente línea y la leemos.
				bw.newLine();
				texto=sc.nextLine();
			}
			
			//Guardamos en el fichero.
			bw.flush();
			
		} catch (IOException e) {
			System.out.println("Error al acceder al fichero.");
			e.getMessage();
		
		//En el bloque finally, cerramos el búfer.
		} finally {
			
			try {
				bw.close();
				
			} catch (IOException e) {
				
				System.out.println("Error al cerrar el búfer de escritura.");
				e.getMessage();
			}
		}

	}

}
