package Relacion6Ejercicio3;

import java.util.Scanner;

/**
 * Realizar una programa en Java que sirva para simular una m�quina de caf�. La
 * m�quina tiene varios dep�sitos: Un dep�sito de caf� con capacidad para 50
 * dosis. Un dep�sito de leche con capacidad para 50 dosis. Un dep�sito de vasos
 * con capacidad para 80 vasos. Tambi�n dispone de monedero con una cantidad de
 * euros. Cuando se cree una nueva m�quina se har� con un monedero inicial y con
 * los dep�sitos llenos. El caf� cuesta 1 euro, la leche 0.8 euros y el caf� con
 * leche 1.5 euros. Al servir cada bebida debe descontarse una dosis de los
 * dep�sitos correspondientes, un vaso y a�adir al monedero lo recaudado. Debe
 * implementarse un men� con 5 opciones: 1. Servir caf� solo (1 euro) 2. Servir
 * leche (0,8 euros) 3. Servir caf� con leche (1,5 euros) 4. Consultar estado
 * m�quina. Aparecen los datos de los dep�sitos y del monedero 5. Apagar m�quina
 * y salir Cuando se sirva una bebida habr� que solicitar el dinero que va a
 * introducir el usuario. Si introduce una cantidad inferior al precio o no hay
 * existencias debe informarse con el error correspondiente. Tambi�n debe
 * producirse un error si la m�quina no tiene cambio de esa cantidad. Si puede
 * dar cambio informar� con el mensaje �Recoge tu cambio de XX euros�. La clase
 * Maquina debe disponer al menos de los siguientes m�todos. M�todo para llenar
 * dep�sitos. No pueden llenarse los dep�sitos por separado. M�todo para vaciar
 * monedero. M�todo para consultar el estado de la m�quina. M�todo para servir
 * caf� s�lo, leche o caf� con leche. Este m�todo mostrar� los mensajes de error
 * correspondientes o el mensaje "Producto servido".
 * 
 * @author Tamara Guzm�n.
 */

public class PrincipalMaquina {

	private static Scanner teclado = new Scanner(System.in);

	// CONSTANTES
	private static final int MAXIMA_OPCION = 5;
	private static final int MINIMO_OPCION = 1;

	public static void main(String[] args) {

		// VARIABLES
		Maquina maquina1;
		double monedero;
		int opcion;

		try {
			do {
				System.out.print("Introduzca una cantidad inicial en el monedero: ");
				monedero = Double.parseDouble(teclado.nextLine());
			} while (monedero <= 0);

			maquina1 = new Maquina(monedero);

			do {
				opcion = mostrarMenu();
				tratarMenu(maquina1, opcion);
			} while (!(opcion == MAXIMA_OPCION));
		} catch (MaquinaException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Metodo que muestra el menu de los caf�s.
	 * 
	 * @return
	 */
	private static int mostrarMenu() {

		int opcion = 0;

		do {

			try {
				System.out.println("1. Servir Caf� Solo (" + Maquina.PRECIO_CAFE + " �.)");
				System.out.println("2. Servir Leche (" + Maquina.PRECIO_LECHE + "�.)");
				System.out.println("3. Servir Caf� con Leche (" + Maquina.PRECIO_CAFE_CON_LECHE + "�.)");
				System.out.println("4. Consultar el estado de la m�quina.");
				System.out.println("5. Apagar m�quina y salir.");
				System.out.print("\nIntroduzca una de las opciones anteriores: ");

				opcion = Integer.parseInt(teclado.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Error. No es un n�mero.");
			}

		} while (opcion < MINIMO_OPCION || opcion > MAXIMA_OPCION);

		return opcion;
	}

	/**
	 * Metodo que da el cambio de la maquina si el cambio es mayor a cero.
	 */
	private static void recogerCambio(double cambio) {
		if (cambio > 0) {
			System.out.printf("Recoja su cambio: %.2f� \n", cambio);
		}
	}

	/**
	 * Metodo que solicita una cantidad de dinero.
	 * 
	 * @param msg
	 * @return
	 */
	private static double pedirDinero(String msg) {
		double dinero = 0;
		boolean hayError = true;

		do {
			try {
				System.out.print(msg);
				dinero = Double.parseDouble(teclado.nextLine());
				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("Error. No es un n�mero.");
				hayError = true;
			}

		} while (hayError);
		return dinero;
	}

	/**
	 * Metodo para tratar menu de la maquina de cafe.
	 * 
	 * @param maquina1
	 * @param opcion
	 */
	public static void tratarMenu(Maquina maquina1, int opcion) {
		double dinero, cambio;

		try {
			switch (opcion) {

			case 1:
				dinero = pedirDinero("Introduzca el dinero para el caf� solo: ");
				cambio = maquina1.servirCafe(dinero);
				recogerCambio(cambio);

				break;

			case 2:

				dinero = pedirDinero("Introduzca el dinero para la leche: ");
				cambio = maquina1.servirLeche(dinero);
				recogerCambio(cambio);

				break;

			case 3:
				dinero = pedirDinero("Introduzca el dinero para el caf� con leche: ");
				cambio = maquina1.servirCafeConLeche(dinero);
				recogerCambio(cambio);

				break;

			case 4:
				// Se llama al toString para mostrar la informacion de la maquina.
				System.out.println(maquina1);

				break;

			}
		} catch (MaquinaException e) {
			System.out.println(e.getMessage());
		}

	}

}
