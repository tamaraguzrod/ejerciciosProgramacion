package Relacion7Ejercicio2;

public class Punto {

	//ATRIBUTOS
	private double x;
	private double y;
	
	//CONSTRUCTOR
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//METODO GETTER Y SETTER
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Metodo toString
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
		
	}
	
	/**
	 * Metodo equals que controla que los dos puntos no pueden ser iguales.
	 * @param otro
	 * @return
	 */
	public boolean equals(Punto otro) {
		boolean iguales = false;
		
		if (this.x == otro.x && this.y == otro.y) {
			iguales = true;
		}
		return iguales;
	}
	
	
	
	

}