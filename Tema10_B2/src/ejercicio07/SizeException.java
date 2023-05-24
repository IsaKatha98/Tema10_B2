package ejercicio07;

/**
* Clase que lanza una excepcion en caso de que el tamaño no sea correcta.
* Extiende la clase Exception
* 
* @author isabelkatharinaloerzer
*
*/
public class SizeException extends Exception{

	/**
	 * Función que devuelve el mensaje de una excepción.
	 * 
	 * @return res mensaje de la excepción.
	 */
	public String getMessage() {
		
		String res="";
		
		res="No puede tener un tamaño superior a 20.";
		
		return res;
	}
}
