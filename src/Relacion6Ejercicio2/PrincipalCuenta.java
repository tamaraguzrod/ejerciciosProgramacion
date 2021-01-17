package Relacion6Ejercicio2;

import java.util.Scanner;

/**
 * Realizar un programa que permita gestionar el saldo de una cuenta corriente.
 * Una vez introducido el saldo inicial, se mostrará un menú que permitirá
 * efectuar las siguientes operaciones:
 * 
 * 1. Hacer un reintegro, se pedirá la cantidad a retirar. 2. Hacer un ingreso,
 * se pedirá la cantidad a ingresar. 3. Consultar el saldo y el número de
 * reintegros e ingresos realizados. 4. Finalizar las operaciones. Debe
 * confirmar si realmente desea salir e informar del saldo al final de todas las
 * operaciones.
 * 
 * Debe realizarse una clase Cuenta y la clase Principal.
 * 
 * @author Tamara Guzmán.
 *
 */

public class PrincipalCuenta {

	private static Scanner teclado = new Scanner(System.in);

	// CONSTANTES
	private static final int OPCION_MINIMA = 1;
	private static final int OPCION_MAXIMA = 4;

	public static void main(String[] args) {

		// VARIABLES
		Cuenta cuenta;
		String titular;
		double saldo;
		int opcion;
		char salir;

		try {
			// Se llama al metodo de solicitar el titular de la cuenta y el saldo.
			titular = solicitarTitularCuenta();
			saldo = solicitarSaldoBase();

			// Se crea una cuenta con todos los datos.
			cuenta = new Cuenta(saldo, titular);

			do {
				opcion = mostrarMenuCuenta();
				salir = tratarMenuCuenta(cuenta, opcion);
			} while (salir == 'N');

		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Metodo que solicita el titular de la cuenta.
	 * 
	 * @return
	 */
	private static String solicitarTitularCuenta() {
		String titular;

		System.out.println("Introduzca el nombre del titular de la cuenta: ");
		titular = teclado.nextLine();
		titular.toUpperCase();

		return titular;
	}

	/**
	 * Metodo que solicita un saldo de base comprobando que no sea negativo y si lo
	 * es se repite.
	 * 
	 * @return
	 */
	private static double solicitarSaldoBase() {
		double saldoInicial = 0;
		boolean hayError = true;

		do {
			try {
				System.out.println("Introduzca un saldo base: ");
				saldoInicial = Double.parseDouble(teclado.nextLine());
				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("Error. No es un número.");
				hayError = true;
			}

		} while (hayError);

		return saldoInicial;
	}

	/**
	 * Metodo que muestra por pantalla el menu.
	 * 
	 * @return
	 */
	private static int mostrarMenuCuenta() {
		int opcion = 0;

		do {

			try {
				System.out.println("1) Realizar un reintegro.");
				System.out.println("\n2) Realizar un ingreso.");
				System.out.println("\n3) Consultar su saldo y el nº de reintegros e ingresos.");
				System.out.println("\n4) Finalizar las operaciones.");
				System.out.print("\nElija una de las operaciones anteriores: ");
				opcion = Integer.parseInt(teclado.nextLine());

				if (opcion < OPCION_MINIMA || opcion > OPCION_MAXIMA) {
					System.out.println("Error. Opción incorrecta, vuelva a introducir un número.");

				}
			} catch (NumberFormatException e) {
				System.out.println("Error. No es un número.");

			}

		} while (opcion < OPCION_MINIMA || opcion > OPCION_MAXIMA);

		return opcion;

	}

	/**
	 * Metodo que trata el menu de la cuenta y realiza las operaciones.
	 * 
	 * @param cuentaBanco
	 * @param opcion
	 * @return
	 */
	private static char tratarMenuCuenta(Cuenta cuenta, int opcion) {
		double cantidad;
		char salir = 'N';

		try {
			switch (opcion) {

			case 1:

				System.out.println("Introduzca una cantidad a retirar: ");
				cantidad = Double.parseDouble(teclado.nextLine());
				// Se llama al metodo reintegro de la clase Cuenta.
				cuenta.sacarDinero(cantidad);

				break;

			case 2:

				System.out.println("Introduzca una cantidad a ingresar: ");
				cantidad = Double.parseDouble(teclado.nextLine());
				// Se llama al metodo ingresar de la clase Cuenta.
				cuenta.ingresarDinero(cantidad);

				break;

			case 3:
				// Se llama al metodo toString para que muestre la información.
				System.out.println(cuenta);

				break;

			case 4:

				do {
					System.out.println("¿Está seguro de que desea terminar las operaciones?: ");
					salir = teclado.nextLine().charAt(0);
					salir = Character.toUpperCase(salir);
				} while (!(salir == 'S' || salir == 'N'));

				// Si sale informa del su saldo final.
				if (salir == 'S') {
					System.out.println("Su saldo es de " + cuenta.getSaldo() + " €.");
				}

				break;
			}
		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		}

		return salir;
	}

}
