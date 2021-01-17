package Relacion7Ejercicio4;

import java.util.Scanner;

import Relacion6Ejercicio3.Maquina;

/**
 * Crear una clase Jarra que utilizaremos para simular algunas de las acciones
 * que podemos realizar con una jarra. Cada jarra tiene una determinada
 * capacidad (en litros). Además una jarra dispondrá de una cantidad de agua que
 * podrá ir variando a medida que realicemos operaciones con ellas. Las jarras
 * se crearán siempre vacías. Las acciones que podremos realizar sobre una jarra
 * son: Llenar la jarra por completo desde un grifo. Vaciarla por completo.
 * Volcar el contenido de una jarra en otra. Por ejemplo: Disponemos de dos
 * jarras A y B de capacidades 7 y 4 litros respectivamente. Podemos llenar la
 * jarra A (no podemos echar menos del total de la jarra porque no sabríamos a
 * ciencia cierta cuánta agua tendría). Luego volcar A sobre B (no cabe todo por
 * lo que en A quedan 3 litros y B está llena). Ahora vaciar B. Después volver a
 * volcar A sobre B. En esta situación, A está vacía y B tiene 3 litros. Además
 * se debe guardar en la clase Jarra el total de agua que se ha consumido
 * llenando objetos Jarra. Realizar un programa que cree dos jarras A y B
 * (solicitando las capacidades por teclado) inicialmente vacías. Después se
 * realizará un menú que permita: 1. Llenar jarra: Se solicitará con la pregunta
 * “¿Qué jarra desea llenar (A/B)?” y se llenará la jarra correspondiente. 2.
 * Vaciar jarra: Se realizará la pregunta “¿Qué jarra desea vaciar (A/ B)?” y se
 * vaciará la jarra correspondiente. 3. Volcar jarra A en B . 4. Volcar jarra B
 * en A. 5. Ver estado de las jarras: Se mostrará la capacidad y el agua que
 * contiene, tanto para la jarra A como para la B. 6. Salir: Cuando salga debe
 * mostrarse un mensaje que indique "El total de agua que se ha gastado llenando
 * jarras es XXX litros".
 * 
 * @author Tamara Guzmán.
 *
 */

public class PrincipalJarra {

	private static Scanner teclado = new Scanner(System.in);

	// CONSTANTES
	private static final int OPCION_MINIMA = 1;
	private static final int OPCION_MAXIMA = 6;

	public static void main(String[] args) {

		// VARIABLES
		Jarra jarra1, jarra2;
		int capacidadJarra;
		int opcion;
		char respuesta;

		try {
			// Se crean las Jarras.
			System.out.print("Introduzca la capacidad de la Jarra 1: ");
			capacidadJarra = Integer.parseInt(teclado.nextLine());
			jarra1 = new Jarra(capacidadJarra);

			System.out.print("Introduzca la capacidad de la Jarra 2: ");
			capacidadJarra = Integer.parseInt(teclado.nextLine());
			jarra2 = new Jarra(capacidadJarra);

			do {
				opcion = mostrarMenu();
				tratarMenu(opcion, jarra1, jarra2);
			} while (!(opcion == OPCION_MAXIMA));

		} catch (JarraException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Metodo que muestra el menú.
	 * 
	 * @return
	 */
	private static int mostrarMenu() {

		int opcion = 0;

		do {

			try {
				System.out.println("1) Llenar Jarra.");
				System.out.println("2) Vaciar Jarra.");
				System.out.println("3) Volcar Jarra A en Jarra B.");
				System.out.println("4) Volcar Jarra B en Jarra A.");
				System.out.println("5) Ver estado de las Jarras.");
				System.out.println("6) Salir.");
				System.out.print("\nIntroduzca una de las opciones anteriores: ");

				opcion = Integer.parseInt(teclado.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Error. No es un número.");
			}

		} while (opcion < OPCION_MINIMA || opcion > OPCION_MAXIMA);

		return opcion;
	}

	private static void tratarMenu(int opcion, Jarra jarra1, Jarra jarra2) {
		char respuesta;

		try {
			switch (opcion) {

			case 1:

				do {
					System.out.print("¿Qué Jarra desea llenar (A ó B)?: ");
					respuesta = teclado.nextLine().charAt(0);
					respuesta = Character.toUpperCase(respuesta);
				} while (!(respuesta == 'A' || respuesta == 'B'));

				if (respuesta == 'A') {
					jarra1.llenarLaJarra();
				} else {
					jarra2.llenarLaJarra();
				}

				break;

			case 2:
				do {
					System.out.print("¿Qué Jarra desea vaciar (A ó B)?: ");
					respuesta = teclado.nextLine().charAt(0);
					respuesta = Character.toUpperCase(respuesta);
				} while (!(respuesta == 'A' || respuesta == 'B'));

				if (respuesta == 'A') {
					jarra1.vaciarLaJarra();
				} else {
					jarra2.vaciarLaJarra();
				}

				break;

			case 3:

				jarra1.volcarUnaJarraEnOtra(jarra2);

				break;

			case 4:

				jarra2.volcarUnaJarraEnOtra(jarra1);

				break;

			case 5:

				System.out.println("Jarra A: " + jarra1);
				System.out.println("Jarra B: " + jarra2);

				break;

			case 6:

				System.out.println("El total de agua que se ha gastado llenando jarras es "
						+ Jarra.getTotalAguaConsumida() + " litros.");

				break;

			}
		} catch (JarraException e) {
			System.out.println(e.getMessage());
		}

	}

}
