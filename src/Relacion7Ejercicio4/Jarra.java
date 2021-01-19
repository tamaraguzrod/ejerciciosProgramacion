package Relacion7Ejercicio4;

public class Jarra {

	// ATRIBUTOS
	private int capacidad;
	private int cantidad;
	private static int totalAguaConsumida;

	// CONSTRUCTOR
	public Jarra(int capacidad) throws JarraException {
		if (capacidad <= 0) {
			throw new JarraException("Error. No se puede crear una Jarra con capacidad negativa o cero.");
		}
		this.capacidad = capacidad;
		this.cantidad = 0;

	}

	// METODOS GETTER
	public int getCapacidad() {
		return capacidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public static int getTotalAguaConsumida() {
		return totalAguaConsumida;
	}

	/**
	 * Metodo toString.
	 */
	public String toString() {
		String info;

		info = "\nCapacidad de Litros: " + capacidad + "\nCantidad de Agua: " + cantidad;
		return info;
	}

	// METODOS DE LA CLASE.

	/**
	 * Metodo para llenar la Jarra se controla la excepcion de si ya esta llena que
	 * muestre un mensaje.
	 * 
	 * @throws JarraException
	 */
	public void llenarLaJarra() throws JarraException {
		int aguaConsumida;

		// Si son iguales.
		if (capacidad == cantidad) {
			throw new JarraException("Error. No se puede llenar porque ya lo esta.");
		}
		// Calculo del agua que se consume.
		aguaConsumida = capacidad - cantidad;

		// Se acumula en la variable estatica.
		totalAguaConsumida = totalAguaConsumida + aguaConsumida;

		// Actualiza el agua de la jarra.
		cantidad = capacidad;

	}

	/**
	 * Metodo para vaciar la Jarra, se controla la excepcion de si la Jarra ya esta
	 * vacia mostrar mensaje.
	 * 
	 * @throws JarraException
	 */
	public void vaciarLaJarra() throws JarraException {

		if (cantidad == 0) {
			throw new JarraException("Error. La Jarra ya esta vacia.");
		}

		cantidad = 0;

	}

	/**
	 * Metodo que vuelca el contenido de agua de una Jarra en otra Jarra.
	 * 
	 * @param otraJarra
	 * @throws JarraException
	 */
	public void volcarUnaJarraEnOtra(Jarra otraJarra) throws JarraException {
		int cantidadSobrante;

		// Si la Jarra B esta llena.
		if (otraJarra.capacidad == otraJarra.cantidad) {
			throw new JarraException("Error. No se puede llenar porque ya esta llena.");
		}

		// Si la Jarra A esta vacia.
		if (this.cantidad == 0) {
			throw new JarraException("Error. No puedes volcar la Jarra, porque esta vacia.");
		}

		// Se calcula la cantidad de agua que tiene la otra Jarra.
		cantidadSobrante = capacidad - otraJarra.cantidad;

		// Si la cantidad del la Jarra 1 es menor o igual a la capacidad que sobra en la
		// otra Jarra.
		if (cantidad <= cantidadSobrante) {
			otraJarra.cantidad = otraJarra.cantidad + cantidad;
			// Si se vuelca por completo, la cantidad de Jarra 1 es cero.
			cantidad = 0;
		} else { // La Jarra no se vuelca por completo porque no cabe.
			cantidad = cantidad - cantidadSobrante;
			otraJarra.cantidad = otraJarra.capacidad;
		}

	}

}
