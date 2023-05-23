package ejercicio05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ejercicio05 {

	public static void main(String[] args) {

		// Creamos un BufferedWriter para leer lo que se introduce por consola.
		BufferedWriter bw = null;

		// Me creo una variable ruta que guarde la ruta del fichero.
		String ruta = new File("datos.txt").getAbsolutePath();

		// Me creo un escáner para escribir cosas desde la consola.
		Scanner sc = new Scanner(System.in);

		// Creamos un HashMap que nos guarde el nombre y la edad.
		Map<String, Integer> gente = new HashMap<String, Integer>();
		String nombre = "";
		int edad;

		// Pedimos los datos por primera vezz.
		System.out.println("Introduzca un nombre: ");
		nombre = sc.nextLine();

		System.out.println("Introduzca una edad: ");
		edad = sc.nextInt();

		// Hacemos un bucle que vaya leyendo hasta que detecta la palabra fin.
		while (edad != 0) {

			// Añadimos ambos valores a una posición del mapa.
			gente.put(nombre, edad);

			// Volvemos a pedir los datos por primera vezz.
			sc.nextLine();
			System.out.println("Introduzca un nombre: ");
			nombre = sc.nextLine();

			System.out.println("Introduzca una edad: ");
			edad = sc.nextInt();

		}

		// Creamos un fichero con la ruta que hemos definido al principio.
		File fichero = new File(ruta);

		// Comprobamos si el fichero yaexiste.
		try {
			if (fichero.createNewFile()) {

				// Creamos el fichero de escritura y le asignamos la ruta de fichero.
				bw = new BufferedWriter(new FileWriter(ruta));

				// Recorremos el mapa.
				for (String nom : gente.keySet()) {

					// Asignamos el valor de las variables.
					nombre = nom;
					edad = gente.get(nom);

					// Escribimos la línea que toca.
					bw.write(nombre + " " + edad);

					// Saltamos a la siguiente línea.
					bw.newLine();
				}

				bw.flush();

			} else {

				// Asignamos la ubicación del fichero y ponemos true, para que se vayan
				// añadiendo las cosas.

				bw = new BufferedWriter(new FileWriter(
						"/Users/isabelkatharinaloerzer/git/Tema10_B2/Tema10_B2/src/Ficheros/datos.txt", true));

				// Recorremos el mapa.
				for (String nom : gente.keySet()) {

					// Asignamos el valor de las variables.
					nombre = nom;
					edad = gente.get(nom);

					// Escribimos la línea que toca.
					bw.write(nombre + " " + edad);

					// Saltamos a la siguiente línea.
					bw.newLine();
				}

				// Guardamos el fichero.
				bw.flush();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			if (bw != null) {
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
