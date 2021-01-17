package Relacion6Ejercicio3;

import java.util.Scanner;

/**
 * Realizar una programa en Java que sirva para simular una máquina de café. La
 * máquina tiene varios depósitos: Un depósito de café con capacidad para 50
 * dosis. Un depósito de leche con capacidad para 50 dosis. Un depósito de vasos
 * con capacidad para 80 vasos. También dispone de monedero con una cantidad de
 * euros. Cuando se cree una nueva máquina se hará con un monedero inicial y con
 * los depósitos llenos. El café cuesta 1 euro, la leche 0.8 euros y el café con
 * leche 1.5 euros. Al servir cada bebida debe descontarse una dosis de los
 * depósitos correspondientes, un vaso y añadir al monedero lo recaudado. Debe
 * implementarse un menú con 5 opciones: 1. Servir café solo (1 euro) 2. Servir
 * leche (0,8 euros) 3. Servir café con leche (1,5 euros) 4. Consultar estado
 * máquina. Aparecen los datos de los depósitos y del monedero 5. Apagar máquina
 * y salir Cuando se sirva una bebida habrá que solicitar el dinero que va a
 * introducir el usuario. Si introduce una cantidad inferior al precio o no hay
 * existencias debe informarse con el error correspondiente. También debe
 * producirse un error si la máquina no tiene cambio de esa cantidad. Si puede
 * dar cambio informará con el mensaje “Recoge tu cambio de XX euros”. La clase
 * Maquina debe disponer al menos de los siguientes métodos. Método para llenar
 * depósitos. No pueden llenarse los depósitos por separado. Método para vaciar
 * monedero. Método para consultar el estado de la máquina. Método para servir
 * café sólo, leche o café con leche. Este método mostrará los mensajes de error
 * correspondientes o el mensaje "Producto servido".
 * 
 * @author Tamara Guzmán.
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
	 * Metodo que muestra el menu de los cafés.
	 * 
	 * @return
	 */
	private static int mostrarMenu() {

		int opcion = 0;

		do {

			try {
				System.out.println("1. Servir Café Solo (" + Maquina.PRECIO_CAFE + " €.)");
				System.out.println("2. Servir Leche (" + Maquina.PRECIO_LECHE + "€.)");
				System.out.println("3. Servir Café con Leche (" + Maquina.PRECIO_CAFE_CON_LECHE + "€.)");
				System.out.println("4. Consultar el estado de la máquina.");
				System.out.println("5. Apagar máquina y salir.");
				System.out.print("\nIntroduzca una de las opciones anteriores: ");

				opcion = Integer.parseInt(teclado.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Error. No es un número.");
			}

		} while (opcion < MINIMO_OPCION || opcion > MAXIMA_OPCION);

		return opcion;
	}

	/**
	 * Metodo que da el cambio de la maquina si el cambio es mayor a cero.
	 */
	private static void recogerCambio(double cambio) {
		if (cambio > 0) {
			System.out.printf("Recoja su cambio: %.2f€ \n", cambio);
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
				System.out.println("Error. No es un número.");
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
				dinero = pedirDinero("Introduzca el dinero para el café solo: ");
				cambio = maquina1.servirCafe(dinero);
				recogerCambio(cambio);

				break;

			case 2:

				dinero = pedirDinero("Introduzca el dinero para la leche: ");
				cambio = maquina1.servirLeche(dinero);
				recogerCambio(cambio);

				break;

			case 3:
				dinero = pedirDinero("Introduzca el dinero para el café con leche: ");
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
