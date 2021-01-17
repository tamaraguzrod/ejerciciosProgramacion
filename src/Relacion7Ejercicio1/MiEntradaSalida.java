package Relacion7Ejercicio1;

import java.util.Scanner;

/**
 * Crea una clase llamada MiEntradaSalida que tenga los siguientes métodos estáticos.
 * 
 * @author Tamara Guzmán.
 *
 */

public class MiEntradaSalida {
	
	//CONSTANTES
	
	private static final String SI = null;
	private static final String NO = null;
	
	private static Scanner teclado = new Scanner(System.in);
	
	

	/**
	 * Método que solicita un numero entero, que reciba por parámetro cadena con un
	 * mensaje, lo muestre y devuelva un número entero leído del teclado. Si se
	 * produce algún error volverá a solicitarlo.
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
				System.out.println("No es un número.");
				hayError = true;

			}

		} while (hayError);

		return numeroEntero;

	}

	/**
	 * Método que solicita un numero entero positivo, que reciba por parámetro
	 * cadena con un mensaje, lo muestre y devuelva un número entero positivo leído
	 * del teclado. Si se produce algún error volverá a solicitarlo.
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
					System.out.println("El número no puede ser ni negativo ni cero.");
					hayError = true;
				}

				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("No es un número.");
				hayError = true;
			}
		} while (hayError);

		return numeroPositivo;
	}

	/**
	 * Método que solicita un numero entero en rango, que reciba por parámetro cadena con un
	 * mensaje, y dos números enteros correspondientes al límite inferior y superior
	 * del rango. El método debe mostrar el mensaje y devuelva un número entero
	 * leído por teclado en el rango indicado. Si se produce algún error volverá a
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
				System.out.println("No es un número.");
				hayError = true;
			}
		} while (hayError);

		return numeroEnRango;
	}
	
	/**
	 * Método que solicita un caracter por teclado, que reciba por parámetro cadena con un mensaje,
	 * lo muestre y devuelva un carácter leído por teclado.
	 * Si se produce algún error volverá a solicitarlo.
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
	 * Un método solicitarCaracterSN, que reciba por parámetro cadena con un mensaje,
	 * lo muestre y devuelva un carácter leído por teclado asegurándose que sea ‘S’ o ‘N’.
	 * Si se produce algún error volverá a solicitarlo.
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
	
	/*caractern método solicitarCadena, que reciba por parámetro cadena con un mensaje, lo muestre y
	 * devuelva un una cadena leída por teclado.
	 * Si se produce algún error volverá a solicitarlo.
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

