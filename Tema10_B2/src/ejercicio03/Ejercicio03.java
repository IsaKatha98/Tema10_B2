package ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio03 {
	
	public static void main(String[] args) {
	
	//Creamos un buferReader para ir leyendo línea a línea
	BufferedReader br=null;
	
	//ASignamos la ubicación del fichero.
	try {
		br= new BufferedReader(new FileReader("src\\Ficheros\\Alumnos.txt"));
	
	
		//Creamos las variables necesarias.
		String[]alumnos=new String[0];
		
		List <String> nombre= new ArrayList<String>();
		int sumaEdad=0;//guarda la edad del alumno.
		double sumaAltura=0;//guarda la altura del alumno.
		int contador=0;
		double mediaEdad=0;
		double mediaAltura=0;
		
		//Leemos la primera línea.
		String linea= br.readLine(); //variable que guarda 1 línea leída por el bufer.
	
		
		//hacemos un bucle que lea el fichero.
		while (linea!=null){
			
			//Separamos la línea y la guardamos en alumnos.
			alumnos= linea.split(" ");
			
			nombre.add(alumnos[0]);
			
			sumaEdad+=Integer.parseInt(alumnos[1]);
			sumaAltura+=Double.parseDouble(alumnos[2]);
			contador++;
			
			//leemos otra línea.
			linea=br.readLine();
		}
		
		mediaEdad=sumaEdad/contador;
		mediaAltura=sumaAltura/contador;
		
		
		//Imprimimos los resultados.
		System.out.println(nombre);
		
		System.out.println("La suma de las edades es: "+sumaEdad+" años.");
		System.out.println("La media de las edades es: "+mediaEdad+" años.");
		System.out.println("La suma de las alturas es: "+sumaAltura+" cm.");
		System.out.println("La media de las alturas es: "+mediaAltura+" cm.");
		
	} catch (FileNotFoundException e) {
		System.out.println("Error al acceder al fichero.");
		e.getMessage();
		
		
		
	} catch (IOException e) {
		System.out.println("Error al leer al fichero.");
		e.getMessage();
	
	//Cerramos el búfer.
	} finally {
		
		try {
			br.close();
			
		} catch (IOException e) {
			System.out.println("Error al cerrar el búfer de lectura.");
			e.getMessage();
			
		}
	}
	
	}
}
