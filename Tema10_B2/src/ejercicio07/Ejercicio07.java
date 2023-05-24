package ejercicio07;

import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {

		// Creamos un escáner y los búferes necesarios.
		Scanner sc = new Scanner(System.in);
		
		//Creamos las variables necesarias.
		int opcion;
		String nombre;
		long tlf;
		String respuesta;
		
		//Llamamos a la función abrirFichero.
		Utils.abrirFichero();
		
		System.out.println("Bienvenido/a a su agenda.");
		
		// Hacemos un bucle que se repita hasta que nos salgamos del programa.
		do {

			// Presentamos el menú.
			Utils.menu();

			// Preguntamos la opción que quiere el usuario.
			System.out.println("Introduzca la opción que desea: ");
			opcion = sc.nextInt();

			// Hacemos un switch.
			switch (opcion) {

			case 1 -> {
				
				//Pedimos los datos.
				sc.nextLine();
				System.out.println("Introduzca su nombre: ");
				nombre=sc.nextLine();
				System.out.println("Introduzca su teléfono: ");
				tlf=sc.nextLong();
				
				// Función que añade un contacto nuevo.
				try {
				
					Utils.nuevoContacto(nombre, tlf);
					
				} catch (SizeException e) {
					
					System.out.println(e.getMessage());
					
				
				} catch (SameNameException e) {
					
					System.out.println(e.getMessage());
					
				}	
				
			}

			case 2 -> {

				//Pedimos datos.
				sc.nextLine();
				System.out.println("Introduzca el nombre del contacto:");
				nombre=sc.nextLine();
				
				// Función que busca el número de un contacto por su nombre.
				Utils.buscarContacto(nombre);
			}
			
			case 3-> {
				
				//Función que muestra los contactos.
				Utils.mostrar();
			}

			case 4-> {
				
				sc.nextLine();
				System.out.println("¿Quiere guardar la agenda?");
				respuesta= sc.nextLine();
				
				if (respuesta.equalsIgnoreCase("si")) {
					
					//Llamamos a la función de guardar.
					Utils.guardar();
					
				}
				
				// salir
				System.out.println("Ha salido del programa.");
				
			}

			default -> {

				System.err.println("Opción introducida incorrecta");
			}
			}
			
			System.out.println();

		} while (opcion != 4);

	}

}
