package ejercicio07;

/**
* Clase que lanza una excepcion en caso de que el nombre ya exista.
* Extiende la clase Exception
* 
* @author isabelkatharinaloerzer
*
*/
public class SameNameException extends Exception {

	/**
	 * Función que devuelve el mensaje de una excepción.
	 * 
	 * @return res mensaje de la excepción.
	 */
	public String getMessage() {
		
		String res="";
		
		res="El nombre ya existe.";
		
		return res;
	}
}
