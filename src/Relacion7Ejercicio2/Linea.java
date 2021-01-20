package Relacion7Ejercicio2;

public class Linea {

	// ATRIBUTOS
	private Punto puntoA;
	private Punto puntoB;

	// CONSTRUCTOR
	public Linea(Punto punto1, Punto punto2) throws LineaException {
		if (punto1.equals(punto2)) {
			throw new LineaException("Error. Los puntos no pueden ser iguales.");
		}
		this.puntoA = punto1;
		this.puntoB = punto2;
	}

	// METODOS GETTER Y SETTER
	public Punto getPunto1() {
		return puntoA;
	}

	public Punto getPunto2() {
		return puntoB;
	}

	public void setPunto1(Punto punto1) {
		this.puntoA = punto1;
	}

	public void setPunto2(Punto punto2) {
		this.puntoB = punto2;
	}

	/**
	 * Metodo toString
	 */
	public String toString() {
		return "[" + puntoA + " , " + puntoB + "]";
	}

	// METODOS DE LA CLASE
	public void moverDerecha(double cantidad) { // x
		
		
	}

	public void moverIzquierda(double cantidad) {// x

	}

	public void moverArriba(double cantidad) { // y

	}

	public void moverAbajo(double cantidad) { // y

	}

}
