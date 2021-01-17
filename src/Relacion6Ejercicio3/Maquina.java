package Relacion6Ejercicio3;

public class Maquina {

	// CONSTANTES
	public static final int MAXIMO_DOSIS_CAFE = 50;
	public static final int MAXIMO_DOSIS_LECHE = 50;
	public static final int MAXIMO_VASOS = 80;
	public static final double PRECIO_CAFE = 1;
	public static final double PRECIO_LECHE = 0.8;
	public static final double PRECIO_CAFE_CON_LECHE = 1.5;

	// ATRIBUTOS
	private double monedero;
	private int vasos, dosisCafe, dosisLeche;

	// CONSTRUCTOR
	public Maquina(double monedero) throws MaquinaException {
		setMonedero(monedero);
		llenarDepositos();
	}

	// METODOS GETTER Y SETTER
	public double getMonedero() {
		return monedero;
	}

	public int getVasos() {
		return vasos;
	}

	public int getDosisCafe() {
		return dosisCafe;
	}

	public int getDosisLeche() {
		return dosisLeche;
	}

	/**
	 * Modificacion del set de monedero, actualizado con la excepcion.
	 * 
	 * @param monedero
	 */
	public void setMonedero(double monedero) throws MaquinaException {
		if (monedero <= 0) {
			throw new MaquinaException("Error. El monedero no puede tener valor cero ni negativo.");
		}

		this.monedero = monedero;

	}

	/**
	 * Metodo toString que muestra la información sobre la máquina.
	 */
	public String toString() {
		return "Estado de la Maquina: \nMonedero: " + monedero + "€ \nVasos: " + vasos + "\nDosis Café: " + dosisCafe
				+ "\nDosis Leche: " + dosisLeche;
	}

	/**
	 * Metodo que inicializa los depositos de cafe, leche y vasos al maximo.
	 */
	public void llenarDepositos() {
		this.dosisCafe = MAXIMO_DOSIS_CAFE;
		this.dosisLeche = MAXIMO_DOSIS_LECHE;
		this.vasos = MAXIMO_VASOS;
	}

	/**
	 * Metodo para vaciar el monedero.
	 */
	public void vaciarMonedero() {
		double monederoVacio;
		this.monedero = 0;
		monederoVacio = this.monedero;

	}

	/**
	 * Metodo de servir cafe, actualizado con las excepciones.
	 * 
	 * @param dinero
	 * @return
	 */
	public double servirCafe(double dinero) throws MaquinaException {
		double cambio;

		if (dinero < PRECIO_CAFE) {
			throw new MaquinaException(
					"Error. No has introducido suficiente dinero." + "El precio del café es " + PRECIO_CAFE + "€.");
		}

		// Se actualiza el cambio.
		cambio = dinero - PRECIO_CAFE;

		if (dosisCafe == 0 || vasos == 0) {
			throw new MaquinaException("Error. Las dosis de café o los vasos están agotados.");
		}

		if (cambio > monedero) {
			throw new MaquinaException(
					"Error. No hay suficiente dinero en la máquina. Recoge tu cambio " + cambio + "€.");

		}

		// Se decrementan las dosis de cafe y los vasos.
		dosisCafe--;
		vasos--;
		// Se añade la ganancia al monedero.
		monedero = monedero + PRECIO_CAFE;

		return cambio;
	}

	/**
	 * Metodo que sirve la leche actualizado con las excepciones.
	 * 
	 * @param dinero
	 * @return
	 */
	public double servirLeche(double dinero) throws MaquinaException {
		double cambio;

		if (dinero < PRECIO_LECHE) {
			throw new MaquinaException(
					"Error. No has introducido suficiente dinero." + "El precio del café es " + PRECIO_LECHE + "€.");
		}

		// Se actualiza el cambio.
		cambio = dinero - PRECIO_LECHE;

		if (dosisLeche == 0 || vasos == 0) {
			throw new MaquinaException("Error. Las dosis de leche o los vasos están agotados.");
		}

		if (cambio > monedero) {
			throw new MaquinaException(
					"Error. No hay suficiente dinero en la máquina. Recoge tu cambio: " + cambio + "€.");

		}

		// Se decrementan las dosis de leche y los vasos.
		dosisLeche--;
		vasos--;
		// Se añade la ganancia al monedero.
		monedero = monedero + PRECIO_LECHE;

		return cambio;

	}

	/**
	 * Metodo que sirve el cafe con leche, actualizado con las excepciones.
	 * 
	 * @param dinero
	 * @return
	 */
	public double servirCafeConLeche(double dinero) throws MaquinaException {
		double cambio;

		if (dinero < PRECIO_CAFE_CON_LECHE) {
			throw new MaquinaException("Error. No has introducido suficiente dinero." + "El precio de la leche es "
					+ PRECIO_CAFE_CON_LECHE + "€.");
		}
		// Se actualiza el cambio.
		cambio = dinero - PRECIO_CAFE_CON_LECHE;

		if (dosisLeche == 0 || dosisCafe == 0 || vasos == 0) {
			throw new MaquinaException("Error. Las dosis de leche, café o los vasos están agotados.");
		}

		if (cambio > monedero) {
			throw new MaquinaException(
					"Error. No hay suficiente dinero en la máquina. Recoge tu cambio: " + cambio + "€.");

		}

		// Se decrementan las dosis de leche, café y los vasos.
		dosisLeche--;
		dosisCafe--;
		vasos--;
		// Se añade la ganancia al monedero.
		monedero = monedero + PRECIO_CAFE_CON_LECHE;

		return cambio;

	}

}
