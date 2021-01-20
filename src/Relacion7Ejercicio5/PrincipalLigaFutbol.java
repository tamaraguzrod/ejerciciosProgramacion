package Relacion7Ejercicio5;

import java.util.Scanner;

/**
 * Principal Ejercicio5 Relacion7.
 * 
 * @author Tamara Guzm�n.
 *
 */

public class PrincipalLigaFutbol {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// Equipos creados.
		Equipo equipo1 = new Equipo("REAL BETIS", "BENITO VILLAMARIN", "SEVILLA");
		Equipo equipo2 = new Equipo("REAL MADRID", "BERNABEU", "MADRID");
		Equipo equipo3 = new Equipo("VALENCIA C.F", "MESTALLA", "VALENCIA");
		Equipo equipo4 = new Equipo("BARCELONA F.C", "CAMP NOU", "BARCELONA");

		// Primer partido.
		crearPartido1(equipo1, equipo2);

		// Segundo y Tercer partido.
		crearPartido2Y3(equipo1, equipo2, equipo3, equipo4);

	}

	/**
	 * Metodo que crea el primer partido de la jornada entre dos equipos.
	 * 
	 * @param equipo1
	 * @param equipo2
	 */
	private static void crearPartido1(Equipo equipo1, Equipo equipo2) {
		int jornada;
		Partido partido1;

		try {

			System.out.println("Introduzca una jornada: ");
			jornada = Integer.parseInt(teclado.nextLine());
			// Se crea el partido.
			partido1 = new Partido(1, equipo1, equipo2);

			// Se pone el resultado del partido.
			partido1.ponerResultado("2-1");

			System.out.println(partido1);

		} catch (LigaException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo para crear el partido 2 y el partido 3.
	 * 
	 * @param equipo1
	 * @param equipo2
	 * @param equipo3
	 * @param equipo4
	 */
	private static void crearPartido2Y3(Equipo equipo1, Equipo equipo2, Equipo equipo3, Equipo equipo4) {
		int jornada;
		Partido partido2;
		Partido partido3;

		try {

			System.out.println("Introduzca una jornada: ");
			jornada = Integer.parseInt(teclado.nextLine());
			// Se crea el partido.
			partido2 = new Partido(2, equipo2, equipo4);
			// Se pone el resultado del partido.
			partido2.ponerResultado("0-0");
			System.out.println(partido2);

			partido3 = new Partido(3, equipo1, equipo3);
			partido3.ponerResultado("1-2");
			System.out.println(partido3);

		} catch (LigaException e) {
			System.out.println(e.getMessage());
		}
	}

}
