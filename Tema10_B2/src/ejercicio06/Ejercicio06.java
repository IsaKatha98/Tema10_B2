package ejercicio06;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio06 {

	public static void main(String[] args) {

		//Primero tenemos que leer el fichero NumDesordenados e ir guardando los números en un TreeSet.
		//Nos creamos un escáner que es el que va a leer el fichero.
		Scanner sc=null;
		
		BufferedWriter bw= null;
		
		//Asignamos la ubicación del fichero.
		
		try {
			sc= new Scanner (new FileReader ("/Users/isabelkatharinaloerzer/git/Tema10_B2/Tema10_B2/src/Ficheros/NumDesordenados.txt"));
		
			//Nos creamos las variables necesarias.
			int num; //guarda cada número que lea el escáner.
	
			Set<Integer> numeros= new TreeSet <Integer>();
			
			//Recorremos el fichero y vamos sumando cada número.
			while (sc.hasNextInt()) {
				
				num=sc.nextInt();
				
				//Ese número lo guardamos en el TreeSet.
				numeros.add(num);
			}
			
			
			System.out.println(numeros);
			
			//Ahora, vamos a escribir el TreeSet en el fichero correspondiente.
			//Asignamos la ubicación del fichero.
			
			bw= new BufferedWriter (new FileWriter("/Users/isabelkatharinaloerzer/git/Tema10_B2/Tema10_B2/src/Ficheros/NumOrdenados.txt"));
		
			String linea;
			//Recorremos el TreeSet con un for-each.
			for(Integer n: numeros) {
				
				//lo pasamos a un string porque sino, no lo imprime bien.
				linea= n.toString();
				
				//Lo escribimos en el fichero.
				bw.write(linea);
				
				//Pasamos a la siguiente línea.
				bw.newLine();
				
			}
			
			//Guardamos lo escrito.
			bw.flush();
		
		} catch (IOException e) {
			
			System.out.println("Error al encontrar el fichero.");
			e.getMessage();
		
		} finally {
			
			if (sc!=null) {
				
				sc.close();
			}
			
			if (bw!=null) {
				
				try {
					bw.close();
				} catch (IOException e) {
					
					System.out.println("Error al cerrar el búfer de escritura.");
					e.getMessage();
					
				}
			}
		}
		
	}
	


}
