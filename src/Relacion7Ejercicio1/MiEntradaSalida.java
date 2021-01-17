package Relacion7Ejercicio1;

import java.util.Scanner;

/**
 * Crea una clase llamada MiEntradaSalida que tenga los siguientes m�todos est�ticos.
 * 
 * @author Tamara Guzm�n.
 *
 */

public class MiEntradaSalida {
	
	//CONSTANTES
	
	private static final String SI = null;
	private static final String NO = null;
	
	private static Scanner teclado = new Scanner(System.in);
	
	

	/**
	 * M�todo que solicita un numero entero, que reciba por par�metro cadena con un
	 * mensaje, lo muestre y devuelva un n�mero entero le�do del teclado. Si se
	 * produce alg�n error volver� a solicitarlo.
	 * 
	 * @param msg
	 * @return int numeroEntero.
	 */
	public static int solicitarNumeroEntero(String msg) {
		int numeroEntero = 0;
		boolean hayError = true;

		do {
			try {
				System.out.println(msg);
				numeroEntero = Integer.parseInt(teclado.nextLine());
				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("No es un n�mero.");
				hayError = true;

			}

		} while (hayError);

		return numeroEntero;

	}

	/**
	 * M�todo que solicita un numero entero positivo, que reciba por par�metro
	 * cadena con un mensaje, lo muestre y devuelva un n�mero entero positivo le�do
	 * del teclado. Si se produce alg�n error volver� a solicitarlo.
	 * 
	 * @param msg
	 * @return
	 */
	public static int solicitarEnteroPositivo(String msg) {
		int numeroPositivo = 0;
		boolean hayError = true;

		do {
			try {
				System.out.println(msg);
				numeroPositivo = Integer.parseInt(teclado.nextLine());

				if (numeroPositivo < 0) {
					System.out.println("El n�mero no puede ser ni negativo ni cero.");
					hayError = true;
				}

				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("No es un n�mero.");
				hayError = true;
			}
		} while (hayError);

		return numeroPositivo;
	}

	/**
	 * M�todo que solicita un numero entero en rango, que reciba por par�metro cadena con un
	 * mensaje, y dos n�meros enteros correspondientes al l�mite inferior y superior
	 * del rango. El m�todo debe mostrar el mensaje y devuelva un n�mero entero
	 * le�do por teclado en el rango indicado. Si se produce alg�n error volver� a
	 * solicitarlo.
	 * 
	 * @param msg
	 * @return
	 */
	public static int solicitarEnteroEnRango(String msg, int limiteInferior, int limiteSuperior) {
		int numeroEnRango = 0, numeroAuxiliar;
		boolean hayError = true;

		// Si el limiteInferior es mayor al limiteSuperior se intercambian con el
		// auxiliar.
		if (limiteInferior > limiteSuperior) {
			numeroAuxiliar = limiteInferior;
			limiteInferior = limiteSuperior;
			limiteSuperior = numeroAuxiliar;
		}

		do {
			try {
				System.out.println(msg);
				numeroEnRango = Integer.parseInt(teclado.nextLine());

				// Si el numero esta fuera de rango, salta el error.
				if (numeroEnRango < limiteInferior || numeroEnRango > limiteSuperior) {
					System.out.println("Numero fuera de rango.");
					hayError = true;
				}

				hayError = false;

			} catch (NumberFormatException e) {
				System.out.println("No es un n�mero.");
				hayError = true;
			}
		} while (hayError);

		return numeroEnRango;
	}
	
	/**
	 * M�todo que solicita un caracter por teclado, que reciba por par�metro cadena con un mensaje,
	 * lo muestre y devuelva un car�cter le�do por teclado.
	 * Si se produce alg�n error volver� a solicitarlo.
	 * @param msg
	 * @return
	 */
	public static char solicitarCaracter(String msg) {
		char caracter = 0;
		String cadena;
		boolean hayError = true;
		
		do {

			System.out.println(msg);
			cadena = teclado.nextLine();
			hayError = false;

			if (cadena.length() != 1) {
				hayError = true;
				System.out.println("Error de formato");
			} else {
				caracter = cadena.charAt(0);
			}
			
		} while (hayError);
		
		return caracter;
		
	}
		
	/**
	 * Un m�todo solicitarCaracterSN, que reciba por par�metro cadena con un mensaje,
	 * lo muestre y devuelva un car�cter le�do por teclado asegur�ndose que sea �S� o �N�.
	 * Si se produce alg�n error volver� a solicitarlo.
	 * @param msg
	 * @return
	 */
	public static char solicitarCaracterSN(String msg) {
		char caracter = 0;		
		String cadena;
		boolean hayError = false;
		
		do {

			System.out.println(msg);
			cadena = teclado.nextLine();


			if (!(cadena.equalsIgnoreCase(SI) || cadena.equalsIgnoreCase(NO))) {
				hayError = true;
				System.out.println("Error. No es el formato adecuado");
			} else {
				
				caracter= cadena.charAt(0);
				hayError = false;
			}
			
		} while (hayError);
		
		return caracter;
	}
	
	/*caractern m�todo solicitarCadena, que reciba por par�metro cadena con un mensaje, lo muestre y
	 * devuelva un una cadena le�da por teclado.
	 * Si se produce alg�n error volver� a solicitarlo.
	 * @param msg
	 * @return
	 */
	public static String solicitarCadena(String msg) {
		String cadena;
		
		//Se vuelve a solicitar la cadena si esta vacia.
		
		do {
			System.out.println(msg);
			cadena = teclado.nextLine();
		} while (cadena.length() == 0);
		
		return cadena;
	}
	
	

}

