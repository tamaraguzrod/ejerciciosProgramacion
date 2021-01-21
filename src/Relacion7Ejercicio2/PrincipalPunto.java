package Relacion7Ejercicio2;

import java.util.Scanner;

public class PrincipalPunto {

	private static Scanner teclado = new Scanner(System.in);

	// CONSTANTES
	private static final int OPCION_MINIMA = 1;
	private static final int OPCION_MAXIMA = 3;

	public static void main(String[] args) {

		// VARIABLES
		int opcion;
		double coordenadaX, coordenadaY, coordenadaX2, coordenadaY2;
		Linea linea1;

		try {

			// Se crean los puntos.
			System.out.println("Introduzca la primera coordenada (X): ");
			coordenadaX = Double.parseDouble(teclado.nextLine());
			System.out.println("Introduzca la primera coordinada (Y): ");
			coordenadaY = Double.parseDouble(teclado.nextLine());
			System.out.println("Introduzca la segunda coordenada (X): ");
			coordenadaX2 = Double.parseDouble(teclado.nextLine());
			System.out.println("Introduzca la segunda coordenada (Y): ");
			coordenadaY2 = Double.parseDouble(teclado.nextLine());

			Punto punto1 = new Punto(coordenadaX, coordenadaY);
			Punto punto2 = new Punto(coordenadaX2, coordenadaY2);

			// Ahora se crea la linea.
			linea1 = new Linea(punto1, punto2);

			do {
				opcion = mostrarMenu();
				tratarMenu(opcion, linea1);
			} while (!(opcion == OPCION_MAXIMA));

		} catch (LineaException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Metodo que muestra el menu.
	 */
	private static int mostrarMenu() {
		int opcion = 0;
		do {
			try {
				System.out.println("1) Mover línea:Solicita el movimiento (A-arriba, B-ABajo, I-Izquierda,"
						+ "D-Derecha) y lo realiza.");
				System.out.println("\n2) Mostrar Línea.");
				System.out.println("\n3) Salir.");
				System.out.print("\nIntroduzca una de las opciones anteriores: ");

				opcion = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("No es un número.");
			}

		} while (opcion < OPCION_MINIMA || opcion > OPCION_MAXIMA);

		return opcion;
	}

	private static void tratarMenu(int opcion, Linea linea1) {
		char direccion;
		double cantidad;

		switch (opcion) {

		case 1:

			try {
				do {
					System.out.println("Introduzca hacia donde quiere realizar el movimiento: ");
					direccion = teclado.nextLine().charAt(0);
					direccion = Character.toUpperCase(direccion);
				} while (!(direccion == 'D' || direccion == 'I' || direccion == 'A' || direccion == 'B'));
				System.out.println("¿Qué cantidad desea mover los puntos?: ");
				cantidad = Double.parseDouble(teclado.nextLine());

				if (direccion == 'D') {
					linea1.moverDerecha(cantidad);
				} else {
					if (direccion == 'I') {
						linea1.moverIzquierda(cantidad);
					} else {
						if (direccion == 'A') {
							linea1.moverArriba(cantidad);
						} else {
							linea1.moverAbajo(cantidad);
						}
					}
				}
			} catch (LineaException e) {
				System.out.println(e.getMessage());
			}

			break;

		case 2:
			// Llama al toString.
			System.out.println(linea1);

			break;

		}

	}

}
