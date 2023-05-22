package ejercicio01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		//Creamos un scanner, inicializado a null.
		Scanner sc= null;
		
		//Asignamos la ubicación del fichero.
		try {
			sc= new Scanner( new FileReader("src\\ejercicio01\\NumerosReales.txt"));
			
			//Creamos las variables necesarias.
			double suma=0;
			double media=0;
			int contador=0;
			
			//Recorremos el fichero y vamos sumando cada número.
			while (sc.hasNext()) {
				suma+=sc.nextDouble();
				
				contador++;
			}
			
			//Cuando termine el bucle hacemos la media y la mostramos.
			media=suma/contador;
			
			System.out.println("Suma: "+suma);
			System.out.println("Media: "+media );
			
		} catch (FileNotFoundException e) {
			System.out.println("Error al encontrar el fichero.");
			e.getMessage();
		
		//En el bloque finally, cerramos todo lo que haya abierto.
		} finally {
			
			if (sc!=null) {
				sc.close();
			}
		}

	}

}
