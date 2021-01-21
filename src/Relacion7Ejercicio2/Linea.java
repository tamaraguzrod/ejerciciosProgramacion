package Relacion7Ejercicio2;

public class Linea {

	// ATRIBUTOS
	private Punto punto1;
	private Punto punto2;

	// CONSTRUCTOR
	public Linea(Punto punto1, Punto punto2) throws LineaException {
		if (punto1.equals(punto2)) {
			throw new LineaException("Error. Los puntos no pueden ser iguales.");
		}
		this.punto1 = punto1;
		this.punto2 = punto2;
	}

	// METODOS GETTER Y SETTER
	public Punto getPunto1() {
		return punto1;
	}

	public Punto getPunto2() {
		return punto2;
	}

	public void setPunto1(Punto punto1) {
		this.punto1 = punto1;
	}

	public void setPunto2(Punto punto2) {
		this.punto2 = punto2;
	}

	/**
	 * Metodo toString
	 */
	public String toString() {
		return "[" + punto1 + " , " + punto2 + "]";
	}

	// METODOS DE LA CLASE

	/**
	 * Metodo que realiza el movimiento hacia la derecha.
	 * 
	 * @param cantidad
	 */
	public void moverDerecha(double cantidad) { // x
		double resultadoPunto1, resultadoPunto2;

		// Se suma al get la cantidad de movimiento y se actualiza con set.
		resultadoPunto1 = punto1.getX() + cantidad;
		punto1.setX(resultadoPunto1);

		resultadoPunto2 = punto2.getX() + cantidad;
		punto2.setX(resultadoPunto2);

	}

	/**
	 * Metodo que realiza el movimiento hacia la izquierda.
	 * 
	 * @param cantidad
	 */
	public void moverIzquierda(double cantidad) {// x
		double resultadoPunto1, resultadoPunto2;

		// Se resta al get la cantidad de movimiento y se actualiza con set.
		resultadoPunto1 = punto1.getX() - cantidad;
		punto1.setX(resultadoPunto1);

		resultadoPunto2 = punto2.getX() - cantidad;
		punto2.setX(resultadoPunto2);

	}

	/**
	 * Metodo que realiza el movimiento hacia arriba de los puntos.
	 * 
	 * @param cantidad
	 */
	public void moverArriba(double cantidad) { // y
		double resultadoPunto1, resultadoPunto2;

		// Se suma al get la cantidad de movimiento y se actualiza con set.
		resultadoPunto1 = punto1.getY() + cantidad;
		punto1.setY(resultadoPunto1);

		resultadoPunto2 = punto2.getY() + cantidad;
		punto2.setY(resultadoPunto2);

	}

	/**
	 * Metodo que realiza el movimiento hacia abajo de los puntos.
	 * 
	 * @param cantidad
	 */
	public void moverAbajo(double cantidad) { // y
		double resultadoPunto1, resultadoPunto2;

		// Se resta al get la cantidad de movimiento y se actualiza con set.
		resultadoPunto1 = punto1.getY() - cantidad;
		punto1.setY(resultadoPunto1);

		resultadoPunto2 = punto2.getY() - cantidad;
		punto1.setY(resultadoPunto2);

	}

}
